package com.example.retrolib;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RegistrationResponse {

    @SerializedName("LoginResponse")
    private ArrayList<Model_inside> model_inside = new ArrayList<Model_inside>();

    public ArrayList<Model_inside> getModel_inside() {
        return model_inside;
    }

    public void setModel_inside(ArrayList<Model_inside> model_inside) {
        this.model_inside = model_inside;
    }



}
