/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplerestclient.core;

/**
 *
 * @author bahrie
 */
public class Auth {

    private String server;
    private String http_user;
    private String http_pass;
    private String http_auth;

    public Auth() {
        server = "http://localhost/rest-server-sample-php/index.php/";
        http_user = "admin";
        http_pass = "1234";
        http_auth = "basic";
    }

    public String getHttp_auth() {
        return http_auth;
    }

    public void setHttp_auth(String http_auth) {
        this.http_auth = http_auth;
    }

    public String getHttp_pass() {
        return http_pass;
    }

    public void setHttp_pass(String http_pass) {
        this.http_pass = http_pass;
    }

    public String getHttp_user() {
        return http_user;
    }

    public void setHttp_user(String http_user) {
        this.http_user = http_user;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auth other = (Auth) obj;
        if ((this.server == null) ? (other.server != null) : !this.server.equals(other.server)) {
            return false;
        }
        if ((this.http_user == null) ? (other.http_user != null) : !this.http_user.equals(other.http_user)) {
            return false;
        }
        if ((this.http_pass == null) ? (other.http_pass != null) : !this.http_pass.equals(other.http_pass)) {
            return false;
        }
        if ((this.http_auth == null) ? (other.http_auth != null) : !this.http_auth.equals(other.http_auth)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.server != null ? this.server.hashCode() : 0);
        hash = 23 * hash + (this.http_user != null ? this.http_user.hashCode() : 0);
        hash = 23 * hash + (this.http_pass != null ? this.http_pass.hashCode() : 0);
        hash = 23 * hash + (this.http_auth != null ? this.http_auth.hashCode() : 0);
        return hash;
    }
}
