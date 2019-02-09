package com.example.retrolib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class MainActivity extends AppCompatActivity {


    Web_Api_Config myWebInterface;

    OkHttpClient mOkHttpClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        try {
            initializeRestAdapter();
            myWebInterface.Login("admin","1234", registrationCallback);
        }       catch (Exception e){e.printStackTrace();}



    }


    public void initializeRestAdapter()
    {
        try {
            mOkHttpClient = new OkHttpClient();
            mOkHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
            mOkHttpClient.setReadTimeout(30, TimeUnit.SECONDS);

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setConverter(new GsonConverter(new Gson()))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(Config.BASE_DOMAIN)
                    .setClient(new OkClient(mOkHttpClient))
                    .build();

            myWebInterface = restAdapter.create(Web_Api_Config.class);

        }       catch (Exception e){e.printStackTrace();}

    }
    Callback<RegistrationResponse> registrationCallback = new Callback<RegistrationResponse>() {
        @Override
        public void success(RegistrationResponse registrationResponse, Response response) {
            try {
                for (int i=0;i<registrationResponse.getModel_inside().size();i++){
                    if(registrationResponse.getModel_inside().get(i).getCode().equals("0"))
                    {
                        Log.e("successs",""+registrationResponse.getModel_inside().get(i).getOwnerID()+"\t"+registrationResponse.getModel_inside().get(i).getName());
                    }
//                    Log.e("--->",""+registrationResponse.getModel_inside().get(i).getCode());
//                    Log.e("--->",""+registrationResponse.getModel_inside().get(i).getMessage());
                }
            }
            catch (Exception e){e.printStackTrace();}
        }

        @Override
        public void failure(RetrofitError error) {
            Toast.makeText(MainActivity.this, "Network Error Occured... Try Again", Toast.LENGTH_LONG).show();

        }
    };


}
