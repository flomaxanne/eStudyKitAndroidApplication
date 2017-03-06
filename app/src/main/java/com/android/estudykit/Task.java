package com.android.estudykit;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Florence A. Pereira on 2/22/2017.
 */

public class Task {
    private UUID tId;
    private String tCode;
    private String tTitle;
    private String tType;
    private Date tDate;
    private boolean tCompleted;

    public Task () {
        this(UUID.randomUUID());
    }

    public Task (UUID id) {
        tId = id;
        tDate = new Date();
    }

    public UUID getId() {
        return tId;
    }

    public String getCode() {
        return tCode;
    }

    public void setCode(String code) {
        tCode = code;
    }

    public String getTitle() {
        return tTitle;
    }

    public void setTitle(String title) {
        tTitle = title;
    }


    public String getType() {
        return tType;
    }

    public void setType(String type) {
        tType = type;
    }

    public Date getDate() {
        return tDate;
    }

    public void setDate(Date date) {
        tDate = date;
    }

    public boolean isCompleted() {
        return tCompleted;
    }

    public void setCompleted(boolean completed) {
        tCompleted = completed;
    }
}
