package com.matsubara.headphonealarmapp.connector;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeConnector {

    public String getCurrentTime() {
        long currentTimeMillis = System.currentTimeMillis();
        Date currentDate = new Date(currentTimeMillis);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        return dateFormat.format(currentDate);
    }
}
