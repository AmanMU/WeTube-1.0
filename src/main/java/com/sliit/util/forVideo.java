package com.sliit.util;

import java.util.ArrayList;
import java.util.Date;

public class forVideo {
    public static String generateID() {
        Date date = new Date();
        String milli = Long.toString(date.getTime());
        String id = "VID" + milli;
        String videoID = id;
        return videoID;
    }
}
