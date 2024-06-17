package com.mycompany.contactapi.service.impl;

import com.mycompany.contactapi.exception.ContactNotFoundException;
import com.mycompany.contactapi.model.Contact;
import com.mycompany.contactapi.repo.ContactRepository;
import com.mycompany.contactapi.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    /**
     * usage : create Contact
     * url : localhost:8080/api/contacts/
     * method : POST
     * param : name,imageUrl, mobile,email,company,title,groupId
     */
    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    /*
     * usage get all Contacts
     * url : localhost:9000/contacts/
     * method : GET
     * param : no-params
     */
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    /**
     * usage : get a Contact
     * url : localhost:9000/contacts/:contactId
     * url-param : contactId
     * method : GET
     * param : no-params
     * return: a contact
     */
    @Override
    public Contact getContactById(String id) throws ContactNotFoundException {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        return optionalContact.orElseThrow(()-> new ContactNotFoundException("Contact Not Found for ID - " + id));
    }

    /**
     * usage update Contact
     * url : localhost:9000/contacts/:contactId
     * url-param : contactId
     * method : PUT
     * param : name,imageUrl, mobile,email,company,title,groupId
     */
    @Override
    public Contact updateContact(Contact contact, String id) throws ContactNotFoundException {

        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(optionalContact.isEmpty()){
            throw new ContactNotFoundException("Update Failed: Contact Not found for ID-" + id);
        }
        else {
            contact.setId(id);
            return contactRepository.save(contact);
        }
    }

    /**
     * usage delete a Contact
     * url : localhost:9000/contacts/:contactId
     * method : DELETE
     * url-param : contactId
     * param : no-params
     */
    public void deleteContact(String id) throws ContactNotFoundException {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(optionalContact.isEmpty()){
            throw new ContactNotFoundException("Delete Failed: Contact Not found for ID-" + id);
        }
        else {
            contactRepository.deleteById(id);
        }
    }
}
