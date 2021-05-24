package com.max.restApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account", schema = "public")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "account_status")
    private AccountStatus accountStatus;
    @Column(name = "email")
    private String email;
    @Column(name = "codeword")
    private String codeword;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}