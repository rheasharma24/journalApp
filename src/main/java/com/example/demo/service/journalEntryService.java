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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Component
@Slf4j
public class journalEntryService {


    @Autowired
    private journalEntryRepository journalEntryRepository;

    @Autowired
    private userService userService;

    private static final Logger logger = LoggerFactory.getLogger(journalEntryService.class);

    @Transactional
    public void saveEntry(journalEntry journalEntry, String userName) {
        try {
            User user = userService.findByUsername(userName);
            LocalDateTime now = LocalDateTime.now();
            journalEntry.setDate(now);

            System.out.println(journalEntry.getDate());

            journalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {
            throw new RuntimeException("An error occured while saving the Entry:" + e);
        }
    }

    public void saveEntry(journalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<journalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<journalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }


    @Transactional
    public boolean deleteById(ObjectId id, String username) {
        boolean removed = false;
        try {
            User user = userService.findByUsername(username);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException("An error occured while deleting the Entry:" + e);
        }
        return removed;
    }
}



//controller ---> service ---> repository
