package scoproject.com.peoplemvvm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 4/26/17.
 */

public class Member {
    @SerializedName("userid")
    private String userid;
    @SerializedName("fullname")
    private String fullname;
    @SerializedName("dateofbirth")
    private String dateofbirth;
    @SerializedName("address")
    private String address;

    public Member(String userid, String fullname, String dateofbirth, String address) {
        this.userid = userid;
        this.fullname = fullname;
        this.dateofbirth = dateofbirth;
        this.address = address;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
