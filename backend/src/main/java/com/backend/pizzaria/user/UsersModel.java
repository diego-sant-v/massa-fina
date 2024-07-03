package com.backend.pizzaria.user;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

@Entity
@Component
@Table(name = "users")
public class UsersModel implements UserDetails  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "street_number", nullable = false)
    private Integer streetNumber;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;

    @Column(name = "complement", nullable = false)
    private String complement;

    @Column(name = "locality", nullable = false)
    private String locality;

    @Column(name = "uf", nullable = false, length = 2)
    private String uf;

    @Column(name = "dd", nullable = false)
    private Integer dd;

    @Column(name = "is_admin", nullable = false)
    private Boolean isAdmin;

    @Column(name = "is_confirmed", nullable = false)
    private Boolean isConfirmedUser;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "img_relative_path")
    private String imgRelativePath;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public UsersModel() {}

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsersModel(String login, String password, UserRole role){
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getImgRelativePath() {
        return imgRelativePath;
    }

    public void setImgRelativePath(String imgRelativePath) {
        this.imgRelativePath = imgRelativePath;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersModel that)) return false;
        return getId() == that.getId() && Objects.equals(getLogin(), that.getLogin()) && role == that.role && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getDateOfBirth(), that.getDateOfBirth()) && Objects.equals(getGender(), that.getGender()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getStreetNumber(), that.getStreetNumber()) && Objects.equals(getCep(), that.getCep()) && Objects.equals(getNeighborhood(), that.getNeighborhood()) && Objects.equals(getComplement(), that.getComplement()) && Objects.equals(getLocality(), that.getLocality()) && Objects.equals(getUf(), that.getUf()) && Objects.equals(getDd(), that.getDd()) && Objects.equals(isAdmin, that.isAdmin) && Objects.equals(isConfirmedUser, that.isConfirmedUser) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(isEnabled(), that.isEnabled()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), role, getEmail(), getPassword(), getDateOfBirth(), getGender(), getStreet(), getStreetNumber(), getCep(), getNeighborhood(), getComplement(), getLocality(), getUf(), getDd(), isAdmin, isConfirmedUser, getPhoneNumber(), isEnabled(), getCreatedAt(), getUpdatedAt());
    }

    public UsersModel(long id, String login, UserRole role, String email, String password, Date dateOfBirth, String gender, String street, Integer streetNumber, String cep, String neighborhood, String complement, String locality, String uf, Integer dd, Boolean isAdmin, Boolean isConfirmedUser, String phoneNumber, Boolean enabled, Date createdAt, Date updatedAt) {
        this.id = id;
        this.login = login;
        this.role = role;
        this.email = email;
        this.password = password;
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
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
