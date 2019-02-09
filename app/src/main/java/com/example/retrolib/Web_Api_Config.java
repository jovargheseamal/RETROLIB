package com.example.retrolib;

import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Query;

public interface Web_Api_Config {

    @POST(Config.URL_LOGIN)
    void Login(@Query("UserName") String namee, @Query("Password") String mobilee, Callback<RegistrationResponse> registrationCallback);

}
