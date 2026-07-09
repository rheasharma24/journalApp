package com.example.demo.service;

import com.example.demo.controller.journalEntryController;
import com.example.demo.entites.User;
import com.example.demo.entites.journalEntry;
import com.example.demo.repository.journalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Component
@Slf4j
public class journalEntryService {


    @Autowired
    private journalEntryRepository journalEntryRepository;

    @Autowired
    private  userService userService;

    private static  final Logger logger = LoggerFactory.getLogger(journalEntryService.class);

    @Transactional
    public  void saveEntry(journalEntry journalEntry,String userName){
        try {
            User user = userService.findByUsername(userName);
            journalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        }catch (Exception e){
            logger.info("khikhikhi");
            throw new RuntimeException("An error occured while saving the Entry:"+e);
        }
     }
    public  void saveEntry(journalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

     public List<journalEntry> getAll(){
         return journalEntryRepository.findAll();
     }

     public Optional<journalEntry> findById(ObjectId id){
         return journalEntryRepository.findById(id);
     }


     @Transactional
     public boolean deleteById(ObjectId id, String username){
        boolean remove=false;
        try {
            User user = userService.findByUsername(username);
           remove = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (remove) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
            return remove;
        }catch (Exception e){
          log.error("error",e);
            throw new RuntimeException("An error occured while deleting the Entry:"+e);
        }
     }

    /* public List<journalEntry> findByUsername(String username){
       return journalEntryRepository.findByUsername(username);
     }*/
    /*public void deleteEntryById(ObjectId myId, String username) {

    }*/
}


//controller ---> service ---> repository
