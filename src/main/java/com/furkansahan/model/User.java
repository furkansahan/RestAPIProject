package com.furkansahan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "userPortal")
@NamedQuery(name = "User.getUserByName",
        query = "select u from User u order by u.name desc")

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_id")
    private String name;

    @Column(name = "lastname_id")
    private String lastname;

    @Column(name = "email_id")
    private String email;

    @Column(name = "password_id")
    private String password;
}
