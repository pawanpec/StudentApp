package com.lp.school.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class User extends Auditable<String> {

  private Long id;

  private Long schoolId;

  private Object data;

  private String name;

  private String fatherName;

  private String motherName;

  private String fatherMobileNumber;

  private String motherMobileNumber;

  // Student/Parents/Teacher
  private String userType;
  // lkg UKG
  private String classType;

  @Email private String email;

  private String imageUrl;

  private Boolean emailVerified = false;

  @JsonIgnore private String password;

  @NotNull private AuthProvider provider;

  private String providerId;

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public String getMotherName() {
    return motherName;
  }

  public void setMotherName(String motherName) {
    this.motherName = motherName;
  }

  public String getFatherMobileNumber() {
    return fatherMobileNumber;
  }

  public void setFatherMobileNumber(String fatherMobileNumber) {
    this.fatherMobileNumber = fatherMobileNumber;
  }

  public String getMotherMobileNumber() {
    return motherMobileNumber;
  }

  public void setMotherMobileNumber(String motherMobileNumber) {
    this.motherMobileNumber = motherMobileNumber;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getClassType() {
    return classType;
  }

  public void setClassType(String classType) {
    this.classType = classType;
  }

  public Long getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(Long schoolId) {
    this.schoolId = schoolId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Boolean getEmailVerified() {
    return emailVerified;
  }

  public void setEmailVerified(Boolean emailVerified) {
    this.emailVerified = emailVerified;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AuthProvider getProvider() {
    return provider;
  }

  public void setProvider(AuthProvider provider) {
    this.provider = provider;
  }

  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
