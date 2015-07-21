package com.example.skool.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

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
}
