package com.mycompany.contactapi.controller;

import com.mycompany.contactapi.exception.GroupNotFoundException;
import com.mycompany.contactapi.model.Group;
import com.mycompany.contactapi.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
@Tag(name = "Groups", description = "APIs for groups")
public class GroupController {

    private final GroupService groupService;

    @Operation(summary = "Create a new Group")
    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody @Valid Group group){
        System.out.println(group.getName());
        Group createdGroup  = groupService.createGroup(group);
        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Groups")
    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups(){
        return new ResponseEntity<>(groupService.getAllGroups(), HttpStatus.OK);
    }

    @Operation(summary = "Get a Group by its Id")
    @GetMapping("/{groupId}")
    public ResponseEntity<Group> getGroupById(@PathVariable String groupId) throws GroupNotFoundException {

        return new ResponseEntity<Group>(groupService.getGroupById(groupId), HttpStatus.OK);
    }

}
