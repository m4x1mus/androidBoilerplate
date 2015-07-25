package com.example.skool.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IBM_ADMIN on 7/12/2015.
 */
public class Utils {
    public static boolean isOnline(Context ctx){
        ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (!(ni==null) && ni.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}