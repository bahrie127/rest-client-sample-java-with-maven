/*
 * created : Jul 5, 2011
 * by : Latief
 */
package com.examplerestclient.core.service;

import com.examplerestclient.core.controller.FileSystemController;
import java.util.*;
import javax.swing.JOptionPane;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Class yang mendefinisikan komunikasi dengan server secara umum, atau generic.
 *
 * @author Latief
 */
@Service("restService")
public class RestService {

    /**
     * URL default dari server
     */
//    public final static String PATTERN_SERVER_URL = "http://localhost:8084/mgm/";
    //   public final static String PATTERN_SERVER_URL = "http://180.235.150.97:8080/mgm/";
    public final static String PATTERN_SERVER_URL = "http://host";
    static final String username = "admin";
    static final String password = "1234";
    protected RestTemplate restTemplate;
    protected HttpHeaders headers;
    protected FileSystemController fileSystemController;

    public RestService(RestTemplate restTemplate, FileSystemController fileSystemController) {
        this.restTemplate = restTemplate;
        this.fileSystemController = fileSystemController;


        initDefaultHeaders();
    }

    /**
     * Inisialisasi Awal dari headers.
     *
     */
    private void initDefaultHeaders() {
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers = new HttpHeaders();
        headers.setAccept(mediaTypes);
    }

    /**
     * Cari data di server
     *
     * @param url
     * @param uriVariables
     * @return
     * @throws RestClientException
     */
    protected Object find(String url, HttpEntity httpEntity, Map<String, Object> uriVariables) throws RestClientException {
        try {
            ResponseEntity<Object> response = restTemplate.exchange(getServerURL() + url, HttpMethod.GET, httpEntity, Object.class, uriVariables);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return new LinkedHashMap<String, Object>();
        }
    }

    /**
     * Cari data di server
     *
     * @param url
     * @param uriVariables
     * @return
     * @throws RestClientException
     */
    protected Object find(String url, HttpEntity httpEntity) throws RestClientException {
        try {
            ResponseEntity<Object> response = restTemplate.exchange(getServerURL() + url, HttpMethod.GET, httpEntity, Object.class);
            return response.getBody();
        } catch (RestClientException rce) {
            rce.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Cari data di server dengan method POST
     *
     * @param url
     * @param uriVariables
     * @return
     * @throws RestClientException
     */
    protected Object findPost(String url, HttpEntity httpEntity, Map<String, Object> uriVariables) throws RestClientException {
        try {
            ResponseEntity<Object> response = restTemplate.exchange(getServerURL() + url, HttpMethod.POST, httpEntity, Object.class, uriVariables);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return new LinkedHashMap<String, Object>();
        }
    }

    /**
     * Cari data di server dengan method POST
     *
     * @param url
     * @param uriVariables
     * @return
     * @throws RestClientException
     */
    protected Object findPost(String url, HttpEntity httpEntity) throws RestClientException {
        try {
            ResponseEntity<Object> response = restTemplate.exchange(getServerURL() + url, HttpMethod.POST, httpEntity, Object.class);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return new LinkedHashMap<String, Object>();
        }
    }

    /**
     * Simpan data ke server.
     *
     * @param url
     * @param httpEntity
     * @param uriVariables
     * @return
     * @throws RestClientException
     */
    protected Map<String, Object> save(String url, HttpEntity httpEntity, Map<String, Object> uriVariables) throws RestClientException {
        try {
            ResponseEntity<Map> response = restTemplate.exchange(getServerURL() + url, HttpMethod.POST, httpEntity, Map.class, uriVariables);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return new HashMap<String, Object>();
        }
    }

    /**
     * Simpan data ke server.
     *
     * @param url
     * @param httpEntity
     * @return
     * @throws RestClientException
     */
    protected Map<String, Object> save(String url, HttpEntity httpEntity) throws RestClientException {
        try {
            ResponseEntity<Map> response = restTemplate.exchange(getServerURL() + url, HttpMethod.POST, httpEntity, Map.class);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return new HashMap<String, Object>();
        }
    }

    /**
     *
     * Rubah data server.
     *
     * @param url
     * @param httpEntity
     * @param uriVariables
     * @return
     * @throws RestClientException
     */
    protected Map<String, Object> update(String url, HttpEntity httpEntity, Map<String, Object> uriVariables) throws RestClientException {
        try {
            ResponseEntity<Map> response = restTemplate.exchange(getServerURL() + url, HttpMethod.PUT, httpEntity, Map.class, uriVariables);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return new HashMap<String, Object>();
        }
    }

    /**
     *
     * Rubah data server.
     *
     * @param url
     * @param httpEntity
     * @return
     * @throws RestClientException
     */
    protected Map<String, Object> update(String url, HttpEntity httpEntity) throws RestClientException {
        try {
            ResponseEntity<Map> response = restTemplate.exchange(getServerURL() + url, HttpMethod.PUT, httpEntity, Map.class);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return new HashMap<String, Object>();
        }
    }

    /**
     * Hapus data server
     *
     * @param url
     * @param uriVariables
     * @return
     * @throws RestClientException
     */
    protected Map<String, Object> delete(String url, HttpEntity httpEntity, Map<String, Object> uriVariables) throws RestClientException {
        try {
            ResponseEntity<Map> response = restTemplate.exchange(getServerURL() + url, HttpMethod.DELETE, httpEntity, Map.class, uriVariables);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return new HashMap<String, Object>();
        }
    }

    /**
     * Hapus data server
     *
     * @param url
     * @return
     * @throws RestClientException
     */
    protected Map<String, Object> delete(String url, HttpEntity httpEntity) throws RestClientException {
        try {
            ResponseEntity<Map> response = restTemplate.exchange(getServerURL() + url, HttpMethod.DELETE, httpEntity, Map.class);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return new HashMap<String, Object>();
        }
    }

    /**
     * Hapus banyak data server
     *
     * @param url
     * @return
     * @throws RestClientException
     */
    protected Map<String, Object> deleteMore(String url, HttpEntity httpEntity) throws RestClientException {
        try {
            ResponseEntity<Map> response = restTemplate.exchange(getServerURL() + url + "/delete", HttpMethod.POST, httpEntity, Map.class);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return new HashMap<String, Object>();
        }
    }

    /**
     * Dapatkan Jumlah record data.
     *
     * @param url
     * @param uriVariables
     * @return
     * @throws RestClientException
     */
    protected Long count(String url, HttpEntity httpEntity, Map<String, Object> uriVariables) throws RestClientException {
        try {
            ResponseEntity<Long> response = restTemplate.exchange(getServerURL() + url, HttpMethod.GET, httpEntity, Long.class, uriVariables);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return 0l;
        }
    }

    /**
     * Dapatkan Jumlah record data.
     *
     * @param url
     * @param uriVariables
     * @return
     * @throws RestClientException
     */
    protected Long count(String url, HttpEntity httpEntity) throws RestClientException {
        try {
            ResponseEntity<Long> response = restTemplate.exchange(getServerURL() + url, HttpMethod.GET, httpEntity, Long.class);
            return response.getBody();
        } catch (RestClientException rce) {
            JOptionPane.showMessageDialog(null, "Connection Failed \n Periksa setting koneksi server", "error connection", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    protected String getServerURL() {
        String url = PATTERN_SERVER_URL.replaceAll("host", fileSystemController.readServer().getProperty(FileSystemController.KEY_HOST));
        // url = url.replaceAll("port", fileSystemController.readServer().getProperty(FileSystemController.KEY_PORT));
        return url;
    }
}
