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

    public static String getData(PackageParams params){
        BufferedReader br = null;
        String uri = params.getUri();
        if(params.getMethod().equals("GET")){
            uri+="?"+params.getEncodedParam();
        }
        try {
            URL url = new URL(params.getUri());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(params.getMethod());
            if(params.getMethod().equals("POST")){
                con.setDoOutput(true);
                OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
                writer.write(params.getEncodedParam());
                writer.flush();
            }
            System.out.println(params.getEncodedParam());
            StringBuilder sb = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }

            return sb.toString();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }finally{
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}