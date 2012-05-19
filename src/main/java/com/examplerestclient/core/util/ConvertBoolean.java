/*
 * created : Oct 13, 2011
 * by : Latief
 */
package com.examplerestclient.core.util;

/**
 *
 * @author Latief
 */
public class ConvertBoolean {
    /**
     * Mengkonversi String yang berisi "true" atau "false" (not case sensitive)
     * menjadi tipe Boolean.TRUE atau Boolean.FALSE.
     * @param s
     * @return true atau false. Jika String tidak berisi "true" / "false" kembalikan null.
     */
    public static Boolean convertStringToBoolean(String s){
        Boolean b = null;
        if(s.trim().equalsIgnoreCase("true"))
            b = true;
        if(s.trim().equalsIgnoreCase("false"))
            b = false;
        return b;
    }
}
