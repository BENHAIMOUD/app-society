package org.society.models;




import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * this class define an Citizen (model) with its proprieties
 * @author Ayoub benHaimoud
 * @since 10/3/2020
 */

//@Table(name = "citizens")
@Entity
public class Citizen {

   // @ApiModelProperty(name="id", value="The id of the citizen", example="1")
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    //@ApiModelProperty(name="FirstName", value="The FirstName of the citizen", example="Ayoub")
    private String firstName;
    //@ApiModelProperty(name="lastName", value="The lastName of the citizen", example="Ben")
    @NonNull
    //@Column(name = "lastName",nullable = false)
    @Size(max = 64)
    private String lastName;
    //@ApiModelProperty(name="CNI", value="The CNI of the citizen", example="JH8978")
    @NonNull
    //@Column(nullable = false , name = "CNI")
    @Size(max = 64)
    private String cni;
    //@ApiModelProperty(name="age", value="The age of the citizen", example="45")
    @NonNull
    //@Column(nullable = false , name = "age")
    @Min(value = 18)
    private int age;
    //@ApiModelProperty(name="phone", value="The phone of the citizen", example="0687987878")
    @NonNull
    //@Column(nullable = false , name = "phone")
    @Size(max = 30)
    private String phone;
    //@ApiModelProperty(name="email", value="The email of the citizen", example="ben@gmail.com")
    @NonNull
   // @Column(nullable = false , name = "email")
    private String email;
    //@ApiModelProperty(name="code", value="The code of the citizen counter ", example="Ayoub")
    @NonNull
    //@Column(nullable = false , name = "code")
    @Size(max = 64)
    private String code;

 public Citizen() {}

 public Citizen(String firstName, String lastName, String cni, int age, String phone, String email, String code) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.cni = cni;
      this.age = age;
      this.phone = phone;
      this.email = email;
      this.code = code;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public String getLastName() {
  return lastName;
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 public String getCni() {
  return cni;
 }

 public void setCni(String cni) {
  this.cni = cni;
 }

 public int getAge() {
  return age;
 }

 public void setAge(int age) {
  this.age = age;
 }

 public String getPhone() {
  return phone;
 }

 public void setPhone(String phone) {
  this.phone = phone;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getCode() {
  return code;
 }

 public void setCode(String code) {
  this.code = code;
 }
 @Autowired
 public String toString() {
  return "Citizen [id=" + id + ", name="+firstName + lastName
          + ", CNI=" + cni + ", age=" + age + ", phone="+phone+
          "email"+email+  "code"+code+"]";
 }
}