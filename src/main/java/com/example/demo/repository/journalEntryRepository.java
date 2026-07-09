package com.example.demo.repository;

import com.example.demo.entites.journalEntry;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface journalEntryRepository extends MongoRepository<journalEntry, ObjectId> {

}
