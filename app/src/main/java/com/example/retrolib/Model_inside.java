package com.example.retrolib;

import com.google.gson.annotations.SerializedName;

public class Model_inside {


    @SerializedName("responseCode")
    private String code;

    @SerializedName("responseMessage")
    private String message;

    @SerializedName("userType")
    private String Utype;

    @SerializedName("ownerId")
    private String ownerID;

    @SerializedName("Name")
    private String Name;

    @SerializedName("UserName")
    private String Uname;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUtype() {
        return Utype;
    }

    public void setUtype(String utype) {
        Utype = utype;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }
}
