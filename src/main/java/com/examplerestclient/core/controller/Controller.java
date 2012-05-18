/*
 * created : Jul 14, 2011
 * by : Latief
 */
package com.examplerestclient.core.controller;

import com.examplerestclient.core.service.RestService;
import java.util.List;

/**
 *
 * @author Latief
 */
public interface Controller {
    
    /**
     * Menambahkan RestService yang digunakan dalam operasi di controller ini.
     * @param restService 
     */
    public void addRestService(RestService restService);
    
    /**
     * Menambahkan RestService yang digunakan dalam operasi di controller ini.
     * @param restServices 
     */
    public void addRestServices(List<RestService> restServices);
}
