package com.esprit.entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String userName;
private String email;
private String password;
private String name;
private String lastName;
private Boolean active;
@ManyToMany(cascade = CascadeType.PERSIST, fetch
= FetchType.EAGER)
private Set<Roles> roles;
}