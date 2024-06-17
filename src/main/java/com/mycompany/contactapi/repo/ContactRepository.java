package com.mycompany.contactapi.repo;

import com.mycompany.contactapi.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
}
