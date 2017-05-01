package scoproject.com.peoplemvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 5/1/17.
 */

public class PeopleResult {

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("name")
    @Expose
    private PeopleName name;
    @SerializedName("location")
    @Expose
    private PeopleLocation location;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("login")
    @Expose
    private PeopleLogin login;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("registered")
    @Expose
    private String registered;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("cell")
    @Expose
    private String cell;
    @SerializedName("id")
    @Expose
    private PeopleId id;
    @SerializedName("picture")
    @Expose
    private PeoplePicture picture;
    @SerializedName("nat")
    @Expose
    private String nat;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PeopleName getName() {
        return name;
    }

    public void setName(PeopleName name) {
        this.name = name;
    }

    public PeopleLocation getLocation() {
        return location;
    }

    public void setLocation(PeopleLocation location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PeopleLogin getLogin() {
        return login;
    }

    public void setLogin(PeopleLogin login) {
        this.login = login;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public PeopleId getId() {
        return id;
    }

    public void setId(PeopleId id) {
        this.id = id;
    }

    public PeoplePicture getPicture() {
        return picture;
    }

    public void setPicture(PeoplePicture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }
}
