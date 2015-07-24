package com.example.skool.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IBM_ADMIN on 7/19/2015.
 */

@DatabaseTable(tableName = "preferences")
public class Preferences {
    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String token;

    @DatabaseField
    private Date dateCreated;

    public Preferences() {
    }

    public Preferences(String token, long dateCreated) {
        this.token = token;
        this.dateCreated = new Date(dateCreated);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
