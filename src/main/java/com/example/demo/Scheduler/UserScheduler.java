package com.example.demo.Scheduler;

import com.example.demo.cache.AppCache;
import com.example.demo.entites.User;
import com.example.demo.entites.journalEntry;
import com.example.demo.enums.Sentiment;
import com.example.demo.repository.UserRespositoryImpl;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRespositoryImpl userRespository;


    @Autowired
    private AppCache appCache;

    @Scheduled(cron="0 0 9 * * SUN")
   // @Scheduled(cron="0 * * ? * *")
    public void fetchUsersAndSendSaMail(){
        List<User> users = userRespository.getUserforSA();
        for(User user:users){
            List<journalEntry>journalEntries = user.getJournalEntries();
           List<Sentiment> sentiments= journalEntries.stream().filter(x->x.getDate()!=null)
                   .filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x ->x.getSentiment()).collect(Collectors.toList());
            Map<Sentiment,Integer> sentimentCounts=new HashMap<>();
            for(Sentiment sentiment:sentiments){
                if(sentiment != null){
                    sentimentCounts.put(sentiment,sentimentCounts.getOrDefault(sentiment,0)+1);
                }
            }

            Sentiment mostFrequentSentiment=null;
            int maxCount=0;
            for (Map.Entry<Sentiment,Integer> entry:sentimentCounts.entrySet()) {
                if(entry.getValue()>maxCount){
                    maxCount=entry.getValue();
                    mostFrequentSentiment=entry.getKey();
                }
            }

          if(mostFrequentSentiment!=null) {
              emailService.sendEmail(user.getEmail(), "Sentiments for last 7 days", mostFrequentSentiment.toString());
          }
        }
    }


    @Scheduled(cron="0 0/10 * ? * *")
    public void clearAppCache(){
      appCache.intit();
    }
}
