package com.example.bip.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User  {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column (name= "userID", nullable = false)
   private Long userID;

   @Column(name="login", nullable = false)
   private String login;
   @Column(name="password", nullable = false)
   private String password;
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "user_role",
           joinColumns = @JoinColumn(name = "userID"),
           inverseJoinColumns = @JoinColumn(name = "role_id"))
   private Set<Role> roles = new HashSet<>();

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

   public Integer getRole() {
      return role;
   }

   public void setRole(Integer role) {
      this.role = role;
   }
}