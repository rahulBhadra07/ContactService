package com.example.ContractManagement.controller;


import com.example.ContractManagement.model.Contact;
import com.example.ContractManagement.service.ContactService;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    public void testGetAllContacts() throws Exception {
        Mockito.when(contactService.getAllContacts()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/contacts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(0)));
    }

    public void testContactsById() throws Exception {
        Contact c=new Contact();
        c.setId(1L);
        c.setName("Rahul");
        Mockito.when(contactService.getContactById(1L)).thenReturn(Optional.of(c));

        mockMvc.perform(get("/api/contacts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is("Rahul")));
    }
}
