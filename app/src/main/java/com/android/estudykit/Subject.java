package com.android.estudykit;



import java.sql.Time;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Florence A. Pereira on 2/22/2017.
 */

public class Subject {
    private UUID sId;
    private String sCode;
    private String sTitle;
    private String sDay1;
    private String sDay2;
    private String sDay3;

    private String sTime1start;
    private String sTime1end;

    private String sTime2start;
    private String sTime2end;

    private String sTime3start;
    private String sTime3end;


    private String sLocation1;
    private String sLocation2;
    private String sLocation3;


    private String sLecturer;


    public Subject () {
        this(UUID.randomUUID());

    }

    public Subject (UUID id) {
        sId = id;
    }

    public UUID getId() {
        return sId;
    }

    public String getCode() {
        return sCode;
    }

    public void setCode(String code) {
        sCode = code;
    }


    public String getTitle() {
        return sTitle;
    }

    public void setTitle(String title) {
        sTitle = title;
    }

    public String getDay1() {
        return sDay1;
    }

    public void setDay1(String day1) {
        sDay1 = day1;
    }


    public String getDay2() {
        return sDay2;
    }

    public void setDay2(String day2) {
        sDay2 = day2;
    }

    public String getDay3() {
        return sDay3;
    }

    public void setDay3(String day3) {
        sDay3 = day3;
    }



    public String getTime1start() {
        return sTime1start;
    }

    public void setTime1start(String time1start) {
        sTime1start = time1start;
    }

    public String getTime1end() {
        return sTime1end;
    }

    public void setTime1end(String time1end) {
        sTime1end = time1end;
    }



    public String getTime2start() {
        return sTime2start;
    }

    public void setTime2start(String time2start) {
        sTime2start = time2start;
    }


    public String getTime2end() {
        return sTime2end;
    }

    public void setTime2end(String time2end) {
        sTime2end = time2end;
    }




    public String getTime3start() {
        return sTime3start;
    }

    public void setTime3start(String time3start) {
        sTime3start = time3start;
    }


    public String getTime3end() {
        return sTime3end;
    }

    public void setTime3end(String time3end) {
        sTime3end = time3end;
    }




    public String getLocation1() {
        return sLocation1;
    }

    public void setLocation1(String location1) {
        sLocation1 = location1;
    }



    public String getLocation2() {
        return sLocation2;
    }

    public void setLocation2(String location2) {
        sLocation2 = location2;
    }



    public String getLocation3() {
        return sLocation3;
    }

    public void setLocation3(String location3) {
        sLocation3 = location3;
    }



    public String getLecturer() {
        return sLecturer;
    }

    public void setLecturer(String lecturer) {
        sLecturer = lecturer;
    }


}
