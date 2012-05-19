/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.examplerestclient.core;

import com.examplerestclient.core.controller.FileSystemController;
import com.examplerestclient.core.service.PersonRestService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml", App.class);
        RestTemplate restTemplate = applicationContext.getBean("restTemplate", RestTemplate.class);

        Person p = new Person();
        p.setId(3L);
        p.setNama("hamdani");
//
//        List<MediaType> mediaTypes = new ArrayList<MediaType>();
//        mediaTypes.add(MediaType.APPLICATION_JSON);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(mediaTypes);
//        HttpEntity<Person> httpEntity = new HttpEntity<Person>(p, headers);
//        restTemplate.exchange("http://localhost/rest-server-sample-php/index.php/person/save", HttpMethod.POST, httpEntity, Map.class);
        
        PersonRestService personRestService=new PersonRestService(restTemplate, new FileSystemController());
        
//        Map<String,Object> respon=personRestService.save(p);
//        Person person=(Person) respon.get("data");
//        System.out.println(person.getNama());
//
//        Map<String,Object> respon=personRestService.delete(p);
//        System.out.println(respon);
        
        List<Person> persons=personRestService.findPersons();
        for(Person person:persons){
            System.out.println(person.getId()+" "+person.getNama());
        }
        
    }
}
