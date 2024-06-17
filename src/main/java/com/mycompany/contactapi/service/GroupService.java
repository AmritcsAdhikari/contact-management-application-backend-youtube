package com.mycompany.contactapi.service;

import com.mycompany.contactapi.exception.GroupNotFoundException;
import com.mycompany.contactapi.model.Group;

import java.util.List;

public interface GroupService {

    public Group createGroup(Group group);

    public List<Group> getAllGroups();

    public Group getGroupById(String id) throws GroupNotFoundException;
}
