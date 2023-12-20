package com.example.ContractManagement.controller;

import com.example.ContractManagement.model.Contact;
import com.example.ContractManagement.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;


    @GetMapping
    public List<Contact> getAllContact(){
        return contactService.getAllContacts();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id){

        Optional<Contact> contactById = contactService.getContactById(id);

        return contactById.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact){

        Optional<Contact> contactByPhoneNumber = contactService.getContactByPhoneNumber(contact.getPhoneNumber());

        if(contactByPhoneNumber.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Contact createContact = contactService.createContact(contact);
        return new ResponseEntity<>(createContact,HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable Long id){
        if(contactService.getContactById(id).isPresent()){
            contactService.deleteContact(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
