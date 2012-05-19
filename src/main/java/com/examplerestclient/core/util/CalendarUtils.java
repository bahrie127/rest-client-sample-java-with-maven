/*
 * created : Jan 2, 2012
 * by : Latief
 */
package com.examplerestclient.core.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Latief
 */
public final class CalendarUtils {
    public static Calendar timeInMilisToCalendar(long timeInMilis){
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(timeInMilis);
        return cal;
    }
    public static Calendar timeInMilisToCalendar(String timeInMilis){
        long l = NumberUtils.stringToLong(timeInMilis);
        return timeInMilisToCalendar(l);
    }
}
