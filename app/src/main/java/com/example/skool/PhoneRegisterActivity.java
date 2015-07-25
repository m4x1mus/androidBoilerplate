package com.example.skool;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.skool.common.Constants;
import com.example.skool.common.Utils;
import com.example.skool.interfaces.BackendService;
import com.example.skool.models.Preferences;
import com.example.skool.models.REST_Phone_Register;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PhoneRegisterActivity extends ActionBarActivity {
    @Bind(R.id.register)
    Button register;

    @Bind(R.id.progressBar)
    ProgressBar pb;

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_register);
        this.ctx = this;
        ButterKnife.bind(this);
        pb.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.register)
    public void register(){
        if(Utils.isOnline(ctx)) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Constants.DOMAIN)
                    .build();

            BackendService bs = restAdapter.create(BackendService.class);
            pb.setVisibility(View.VISIBLE);
            bs.registerMobileNumber(Constants.PHONE, new Callback<REST_Phone_Register>() {
                @Override
                public void success(REST_Phone_Register rest_phone_register, Response response) {
                    pb.setVisibility(View.INVISIBLE);
                    if (rest_phone_register.isValid()) {
                        Intent intent = new Intent(ctx, OTPSubmitActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //Handle Error
                    }
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    pb.setVisibility(View.INVISIBLE);
                    Toast.makeText(ctx, "Fail:" + retrofitError, Toast.LENGTH_LONG).show();
                    //Temporary Redirect for testing purpose. Remove in production below code
                    Intent intent = new Intent(ctx, OTPSubmitActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }else{
            Toast.makeText(ctx, "Connect to Internet", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_phone_register, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}