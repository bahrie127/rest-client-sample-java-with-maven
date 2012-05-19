/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplerestclient.core.util;

import com.examplerestclient.core.Person;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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
        person.setId(Long.parseLong(linkedHashMap.get("id")+""));
        person.setNama(linkedHashMap.get("nama")+"");
        return person;
    }
     
     public static List<Person> convertMapToPersons(List<LinkedHashMap> linkedHashMaps){
         if(linkedHashMaps==null)return null;
         
         List<Person> persons=new ArrayList<Person>();
         for(LinkedHashMap linkedHashMap:linkedHashMaps){
             persons.add(convertMapToPerson(linkedHashMap));
         }
         
         return persons;
     }
    
}
