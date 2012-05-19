/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplerestclient.core.util;

/**
 *
 * ini adalah class NumberUtils
 */
public class NumberUtils {

    public static int stringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static long stringToLong(String string) {
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static float stringToFloat(String string) {
        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String convertToStringFormatted(Number number) {
        String format = number + "";

        return format;
    }
}
