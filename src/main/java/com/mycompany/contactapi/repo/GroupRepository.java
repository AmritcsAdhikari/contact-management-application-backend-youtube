package com.mycompany.contactapi.repo;

import com.mycompany.contactapi.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
}
