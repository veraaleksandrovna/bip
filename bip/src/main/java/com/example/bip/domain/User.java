package com.example.bip.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User  {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column (name= "userid", nullable = false)
   private Long userID;

   @Column(name="login", nullable = false)
   private String login;
   @Column(name="password", nullable = false)
   private String password;
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "user_role",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id"))
   private Set<Role> role = new HashSet<>();

   public User() {
   }

   public Long getUserID() {
      return userID;
   }

   public void setUserID(Long userID) {
      this.userID = userID;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Set<Role> getRole() {
      return role;
   }

   public void setRole(Set<Role> role) {
      this.role = role;
   }

}