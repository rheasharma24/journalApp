package com.example.demo.entites;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper=false)
//@Builder
@Data
@NoArgsConstructor
public class journalEntry {
    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    public LocalDateTime date;


}
