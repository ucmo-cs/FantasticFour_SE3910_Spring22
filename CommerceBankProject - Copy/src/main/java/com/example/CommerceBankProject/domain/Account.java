package com.example.CommerceBankProject.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String firstName;
    private String lastName;
    private boolean usertype;

    @OneToMany(mappedBy = "account")
    private Set<OpenSource> openSources = new HashSet<>();
}
