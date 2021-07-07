package com.example.a1010test2;

import android.app.Application;

public class MyGlobals extends Application
{
    private String userID;

    public String getuserID()
    {
        return userID;
    }

    public void setuserID(String userID)
    {
        this.userID = userID;
    }


}
