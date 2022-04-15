package com.example.bip.domain;

import javax.persistence.*;

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
   @Enumerated(EnumType.STRING)
   @Column(name = "role")
   private UserRole role;


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

   public void setRole(UserRole role) {
      this.role = role;
   }

   public User(String login, String password, UserRole role) {
      this.login = login;
      this.password = password;
      this.role = role;
   }

}