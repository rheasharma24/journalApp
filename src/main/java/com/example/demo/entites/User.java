package com.example.demo.entites;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")

public class User {
        @Id
        private ObjectId id;
        @Indexed(unique = true)
        @NonNull
        private String username;
        @NonNull
        private String password;

        @DBRef
        private List<journalEntry> journalEntries=new ArrayList<>();
        public List<String>roles=new ArrayList<>();

}
