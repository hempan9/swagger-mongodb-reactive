package com.hmp.reactive.model.documents;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
}
