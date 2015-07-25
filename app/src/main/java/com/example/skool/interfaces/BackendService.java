package com.example.skool.interfaces;

import com.example.skool.models.REST_OTP_Register;
import com.example.skool.models.REST_Phone_Register;

import retrofit.Callback;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by IBM_ADMIN on 7/25/2015.
 */
public interface BackendService {
    @POST("/android/api/v1/user/register")
    void registerMobileNumber(@Header("phone") String phoneNumber, Callback<REST_Phone_Register> cb);

    @POST("/android/api/v1/otp/register")
    void registerOTP(@Header("otp") String otp, Callback<REST_OTP_Register> cb);
}
