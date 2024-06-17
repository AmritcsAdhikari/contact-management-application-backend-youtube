package com.mycompany.contactapi.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "contacts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contact {

    @Id
    private String id;

    @NotBlank (message = "Name must not be null or blank")
    private String name;

    @NotBlank (message = "Image URL must not be null or blank")
    private String imageUrl;

    @Indexed(unique = true)
    private String mobile;

    @NotBlank(message = "Email must not be null or blank")
    @Email
    private String email;

    @NotBlank(message = "Company must not be null or blank")
    private String company;

    @NotBlank(message = "Title must not be null or blank")
    private String title;

    @NotBlank(message = "Group Id must not be null")
    private String groupId;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
