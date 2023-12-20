package com.example.ContractManagement.service;

import com.example.ContractManagement.model.Contact;
import com.example.ContractManagement.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;



    //Get all contact
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }


    public Optional<Contact> getContactById(Long id) {

        return contactRepository.findById(id);
    }

    public Optional<Contact> getContactByPhoneNumber(String phoneNumber) {

        return contactRepository.findByPhoneNumber(phoneNumber);
    }

    public Contact createContact(Contact contact) {

        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
