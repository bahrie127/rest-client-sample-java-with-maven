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
        Map<String, Object> response = save("/person/save", httpEntity);
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
        Map<String, Object> response = update("/Person", httpEntity);
        if (response.containsKey("data")) {
           // response.put("data", ConvertJackson.convertMapToPerson((LinkedHashMap) response.get("data")));

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
        Map<String, Object> uriVariables = new HashMap<String, Object>();
       // uriVariables.put("id", Person.getId());
        return delete("/Person?id={id}", new HttpEntity<Person>(null, headers), uriVariables);
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
     * Dapatkan jumlah data Person
     * @return
     * @throws RestClientException 
     */
    public Long PersonsCount() throws RestClientException {
        return count("/Person/count", new HttpEntity<Person>(null, headers));
    }
}
