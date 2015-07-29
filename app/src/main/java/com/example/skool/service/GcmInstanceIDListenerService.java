package com.example.skool.service;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by IBM_ADMIN on 7/26/2015.
 */
public class GcmInstanceIDListenerService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
        //Intent intent = new Intent(this, RegistrationIntentService.class);
        //startService(intent);
    }
}
