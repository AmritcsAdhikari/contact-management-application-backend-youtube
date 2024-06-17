package com.mycompany.contactapi.service.impl;

import com.mycompany.contactapi.exception.ContactNotFoundException;
import com.mycompany.contactapi.exception.GroupNotFoundException;
import com.mycompany.contactapi.model.Group;
import com.mycompany.contactapi.repo.ContactRepository;
import com.mycompany.contactapi.repo.GroupRepository;
import com.mycompany.contactapi.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    /**
     * usage : create Group
     * url : localhost:9000/groups/
     * method : POST
     * param : name
     */
    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }
    /**
     * usage : get all Groups
     * url : localhost:9000/groups/
     * method : GET
     * param : no-params
     */

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    /**
     * usage : get a Group
     * url : localhost:9000/groups/:groupId
     * method : GET
     * param : no-params
     */
    @Override
    public Group getGroupById(String id) throws GroupNotFoundException {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        return optionalGroup.orElseThrow(()-> new GroupNotFoundException("Group Not Found for ID - " + id));

    }
}
