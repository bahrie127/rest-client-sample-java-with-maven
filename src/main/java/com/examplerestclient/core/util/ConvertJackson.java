/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplerestclient.core.util;

import com.examplerestclient.core.Person;
import java.util.LinkedHashMap;

/**
 *
 * @author bahrie
 */
public final class ConvertJackson {
    
     public static Person convertMapToPerson(LinkedHashMap linkedHashMap) {
        if (linkedHashMap == null) {
            return null;
        }

        Person person = new Person();
        person.setNama(linkedHashMap.get("nama")+"");
        return person;
    }
    
}
