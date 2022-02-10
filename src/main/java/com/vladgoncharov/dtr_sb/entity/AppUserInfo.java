package com.vladgoncharov.dtr_sb.entity;


import com.vladgoncharov.dtr_sb.validation.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "app_user_info")
public class AppUserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @CheckAge
    @Column(name = "age")
    private String age;

    @CheckName(message = "В имени присутствуют некорректные символы")
    @Column(name = "name")
    private String name;

    @CheckName(message = "В фамилии присутствуют некорректные символы")
    @Column(name = "surname")
    private String surname;

    @CheckCity
    @Column(name = "city")
    private String city;

    @CheckEmail
    @Column(name = "email")
    private String email;

    @Column(name = "checking_email")
    private boolean checkingEmail;

    @CheckPhoneNumber
    @Column(name = "phone")
    private String phone;

    @Column(name = "img")
    private int img;

    public AppUserInfo() {
        age = "";
        name = "";
        surname = "";
        city = "";
        email = "";
        checkingEmail = false;
        phone = "";
        img = 1;
    }
    public AppUserInfo(long id) {
        this.id = id;
        age = "";
        name = "";
        surname = "";
        city = "";
        email = "";
        checkingEmail = false;
        phone = "";
        img = 1;
    }

    public boolean theUserIsReadyToCheckEmail() {
        return !isCheckingEmail() && !email.isEmpty();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isCheckingEmail() {
        return checkingEmail;
    }

    public void setCheckingEmail(boolean checkingEmail) {
        this.checkingEmail = checkingEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserInfo that = (AppUserInfo) o;
        return id == that.id && age == that.age && checkingEmail == that.checkingEmail
                && img == that.img && Objects.equals(name, that.name)
                && Objects.equals(surname, that.surname) && Objects.equals(city, that.city)
                && Objects.equals(email, that.email) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id) * 31 * 7 * 33 + 100;
        // как у User только на 100 больше;
    }

}
