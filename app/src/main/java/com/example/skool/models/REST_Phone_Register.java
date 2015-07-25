package com.example.skool.models;

/**
 * Created by IBM_ADMIN on 7/25/2015.
 */
import java.util.HashMap;
import java.util.Map;

public class REST_Phone_Register {

    private boolean valid;
    private int status;

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
     * The status
     */
    public int getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(int status) {
        this.status = status;
    }
}