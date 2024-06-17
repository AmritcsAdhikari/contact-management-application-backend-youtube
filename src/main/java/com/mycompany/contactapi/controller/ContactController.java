package com.mycompany.contactapi.controller;

import com.mycompany.contactapi.exception.ContactNotFoundException;
import com.mycompany.contactapi.model.Contact;
import com.mycompany.contactapi.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
@Tag(name = "Contacts", description = "APIs for contacts")
public class ContactController {

    private final ContactService contactService;

    @Operation(
            summary = "Create a new Contact",
            description = "Returns a Contact after successful creation",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400"
                    )
            }

    )
    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody @Valid Contact contact){

        Contact createdContact  = contactService.createContact(contact);
        return new ResponseEntity<>(createdContact, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Contacts")
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts(){
        return new ResponseEntity<>(contactService.getAllContacts(), HttpStatus.OK);
    }

    @Operation(summary = "Get a Contact by its Id")
    @GetMapping("/{contactId}")
    public ResponseEntity<Contact> getContactById(@PathVariable String contactId) throws ContactNotFoundException {

        return new ResponseEntity<Contact>(contactService.getContactById(contactId), HttpStatus.OK);
    }

    @Operation(summary = "update a existing Contact")
    @PutMapping("/{contactId}")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact, @PathVariable String contactId) throws ContactNotFoundException {

        Contact updatedContact = contactService.updateContact(contact, contactId);
        return new ResponseEntity<Contact>(updatedContact,HttpStatus.OK);
    }

    @Operation(summary = "Delete a Contact by its Id")
    @DeleteMapping("/{contactId}")
    public ResponseEntity<?> deleteContact(@PathVariable String contactId) throws ContactNotFoundException {
        contactService.deleteContact(contactId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
