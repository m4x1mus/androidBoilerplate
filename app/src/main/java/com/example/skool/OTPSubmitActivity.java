package com.example.skool;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.skool.common.Constants;
import com.example.skool.common.PackageParams;
import com.example.skool.common.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class OTPSubmitActivity extends ActionBarActivity {
    @Bind(R.id.otp_submit)
    Button otp_submit;

    @Bind(R.id.progressBar2)
    ProgressBar pb;

    @Bind(R.id.otp_number)
    EditText otp_number;

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_register);
        this.ctx = this;
        ButterKnife.bind(this);
    }

    @OnClick(R.id.otp_submit)
    public void submit(){
        PackageParams params = new PackageParams();
        params.setMethod("POST");
        params.setUri(Constants.OTP_VERIFY_API);
        params.setParam("phone",Constants.PHONE);
        params.setParam("otp",otp_number.getText().toString());
        new PhoneRegistertask().execute(params);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_phone_register, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class PhoneRegistertask extends AsyncTask<PackageParams, String, String> {
        @Override
        protected void onPreExecute() {

            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(PackageParams... arg0) {
            return Utils.getData(arg0[0]);
        }

        @Override
        protected void onProgressUpdate(String... values) {

        }

        @Override
        protected void onPostExecute(String result) {
            pb.setVisibility(View.INVISIBLE);
            System.out.println(result);
            Intent intent = new Intent(ctx, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}