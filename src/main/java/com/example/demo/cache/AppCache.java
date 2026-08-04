package com.example.demo.cache;

import com.example.demo.entites.ConfigJournalAppEntity;
import com.example.demo.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {


    public enum Keys{
       WEATHER_API;
    }

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String,String> appCache=new HashMap<>();


    @PostConstruct
    public void intit() {
        List<ConfigJournalAppEntity> all=configJournalAppRepository.findAll();
        for(ConfigJournalAppEntity c:all){
            appCache.put(c.getKey(),c.getValue());
        }
    }
}
