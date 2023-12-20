package com.example.ContractManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Data
public class Contact {



    @Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

   @NotBlank
    private String name;

    private String address;


    @Column(unique = true)
    @NotBlank
    private String phoneNumber;


    private String email;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) && name.equals(contact.name) && Objects.equals(address, contact.address) && phoneNumber.equals(contact.phoneNumber) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phoneNumber, email);
    }


}
