/*
 * created : Jul 5, 2011
 * by : Latief
 */
package com.examplerestclient.core.service;


import com.examplerestclient.core.Person;
import com.examplerestclient.core.controller.FileSystemController;
import com.examplerestclient.core.util.ConvertJackson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Latief
 */
@Service("personService")
public class PersonRestService extends RestService {

    public PersonRestService(RestTemplate restTemplate,FileSystemController fileSystemController) {
        super(restTemplate,fileSystemController);
    }

    /*** Person *****************************************************************/
    /**
     * Simpan data Person baru ke server.
     * @param Person
     * @return
     * @throws RestClientException 
     */
    public Map<String, Object> save(Person Person) throws RestClientException {
        HttpEntity<Person> httpEntity = new HttpEntity<Person>(Person, headers);
        Map<String, Object> response = save("/person_c/person", httpEntity);
        if (response.containsKey("data")) {
            response.put("data", ConvertJackson.convertMapToPerson((LinkedHashMap) response.get("data")));
        }
        return response;
    }

    /**
     * Rubah data Person di server
     * @param Person
     * @return
     * @throws RestClientException 
     */
    public Map<String, Object> update(Person Person) throws RestClientException {
        HttpEntity<Person> httpEntity = new HttpEntity<Person>(Person, headers);
        Map<String, Object> response = save("/person_c/person_update", httpEntity);
        if (response.containsKey("data")) {
            response.put("data", ConvertJackson.convertMapToPerson((LinkedHashMap) response.get("data")));

        }
        return response;
    }

    /**
     * Hapus data Person di server.
     * @param Person
     * @return
     * @throws RestClientException 
     */
    public Map<String, Object> delete(Person Person) throws RestClientException {
       HttpEntity<Person> httpEntity = new HttpEntity<Person>(Person, headers);
        Map<String, Object> response = save("/person_c/person_delete", httpEntity);
        if (response.containsKey("data")) {
            response.put("data", ConvertJackson.convertMapToPerson((LinkedHashMap) response.get("data")));

        }
        return response;
    }

    /**
     * Hapus banyak data Person di server.
     * @param Person
     * @return
     * @throws RestClientException 
     */
    public Map<String, Object> deleteMorePerson(List<Person> Persons) throws RestClientException {
        return deleteMore("/Person", new HttpEntity<List<Person>>(Persons, headers));
    }

     /**
     * Cari semua bank
     * @return
     * @throws RestClientException 
     */
    public List<Person> findPersons() throws RestClientException {
        List<LinkedHashMap> personsLinkedHashMap = (List<LinkedHashMap>) find("/person_c/person", new HttpEntity<Person>(null, headers));
        List<Person> persons= ConvertJackson.convertMapToPersons(personsLinkedHashMap);
        return persons;
    }
   

    /**
     * Dapatkan jumlah data Person
     * @return
     * @throws RestClientException 
     */
    public Long PersonsCount() throws RestClientException {
        return count("/Person/count", new HttpEntity<Person>(null, headers));
    }
}
