package com.example.skool.models;

/**
 * Created by IBM_ADMIN on 7/25/2015.
 */
import java.util.HashMap;
import java.util.Map;

public class REST_OTP_Register {

    private boolean valid;
    private String response;
    private String auth_key;

    /**
     *
     * @return
     * The valid
     */
    public boolean isValid() {
        return valid;
    }

    /**
     *
     * @param valid
     * The valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    /**
     *
     * @return
     * The response
     */
    public String getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(String response) {
        this.response = response;
    }

    public String getAuth_key() {
        return auth_key;
    }

    public void setAuth_key(String auth_key) {
        this.auth_key = auth_key;
    }
}
