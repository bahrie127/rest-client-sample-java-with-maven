/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplerestclient.core.controller;

import com.examplerestclient.core.service.RestService;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * ini adalah class FileSystemController
 */
public class FileSystemController implements Controller{

    private final static String FILE_HOST = "system/server.properties";
    public final static String KEY_HOST = "host";
    public final static String KEY_PORT = "port";

    public Properties readServer() {
        try {

            Properties p = new Properties();
            p.load(new FileInputStream(FILE_HOST));
            return p;
        } catch (IOException ex) {
            Logger.getLogger(FileSystemController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "file server.properties not found");
            return null;
        }
    }

    public void writeServer(Properties p) {
        try {
            p.store(new FileOutputStream(FILE_HOST), null);
        } catch (IOException ex) {
            Logger.getLogger(FileSystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addRestService(RestService restService) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addRestServices(List<RestService> restServices) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }
}
