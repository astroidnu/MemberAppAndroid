package scoproject.com.peoplemvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by ibnumuzzakkir on 4/26/17.
 */

public class Member implements Serializable {
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

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException{
        stream.writeObject(userid);
        stream.writeObject(fullname);
        stream.writeObject(dateofbirth);
        stream.writeObject(address);
    }

    private void readObjectNoData()
            throws ObjectStreamException {

    }

    private void readObject(ObjectInputStream stream)
            throws ClassNotFoundException, IOException {
        userid = (String) stream.readObject();
        fullname = (String) stream.readObject();
        dateofbirth = (String) stream.readObject();
        address = (String) stream.readObject();
    }

}
