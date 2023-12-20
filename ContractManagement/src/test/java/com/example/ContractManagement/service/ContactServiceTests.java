package com.example.ContractManagement.service;


import com.example.ContractManagement.model.Contact;
import com.example.ContractManagement.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//COntactServiceTests.java
@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTests {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;



    @Test
    public void testgetAllContacts(){


        //Mocking repository
        Mockito.when(contactRepository.findAll()).thenReturn(Collections.emptyList());


        List<Contact> allContacts = contactService.getAllContacts();

        //Assertions
        assertEquals(0,allContacts.size());

    }

    @Test
    public void testGetContactById(){
        Contact c=new Contact();
        c.setId(1L);
        c.setName("Rahul");
        Mockito.when(contactService.getContactById(1L)).thenReturn(Optional.of(c));

       Optional<Contact> result= contactService.getContactById(1L);
       assertTrue(result.isPresent());
       assertEquals("Rahul",result.get().getName());
    }
}
