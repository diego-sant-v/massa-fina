package com.backend.pizzaria.dto;

import com.backend.pizzaria.user.UserRole;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class RegisterDTO {
    private String login;
    private String password;
    private UserRole role;
    private String email;
    private Date dateOfBirth;
    private String gender;
    private String street;
    private Integer streetNumber;
    @NotBlank
    private String cep;
    private String neighborhood;
    private String complement;
    private String locality;
    private String uf;
    private Integer dd;
    private Boolean isAdmin;
    private Boolean isConfirmedUser;
    private String phoneNumber;
    private Boolean enabled;

    // Constructors
    public RegisterDTO() {
    }

    public RegisterDTO(String login, String password, UserRole role, String email, Date dateOfBirth, String gender, String street, Integer streetNumber, @NotBlank String cep, String neighborhood, String complement, String locality, String uf, Integer dd, Boolean isAdmin, Boolean isConfirmedUser, String phoneNumber, Boolean enabled) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.street = street;
        this.streetNumber = streetNumber;
        this.cep = cep;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.locality = locality;
        this.uf = uf;
        this.dd = dd;
        this.isAdmin = isAdmin;
        this.isConfirmedUser = isConfirmedUser;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getDd() {
        return dd;
    }

    public void setDd(Integer dd) {
        this.dd = dd;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getConfirmedUser() {
        return isConfirmedUser;
    }

    public void setConfirmedUser(Boolean confirmedUser) {
        isConfirmedUser = confirmedUser;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
