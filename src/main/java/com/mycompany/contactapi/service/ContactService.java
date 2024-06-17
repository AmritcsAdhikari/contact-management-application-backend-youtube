package com.mycompany.contactapi.service;

import com.mycompany.contactapi.exception.ContactNotFoundException;
import com.mycompany.contactapi.model.Contact;

import java.util.List;

public interface ContactService {

    public Contact createContact(Contact contact);

    public List<Contact> getAllContacts();

    public Contact getContactById(String id) throws ContactNotFoundException;

    public Contact updateContact(Contact contact, String id) throws ContactNotFoundException;

    public void deleteContact(String id) throws ContactNotFoundException;
}
