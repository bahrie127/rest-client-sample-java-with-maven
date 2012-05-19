/*
 * created : Dec 24, 2011
 * by : Latief
 */
package com.examplerestclient.core.util;

/**
 *
 * @author Latief
 */
public final class StringUtils {
    public static String convertString(Object o){
        if(o == null)
            return null;
        return o + "";
    }
}
