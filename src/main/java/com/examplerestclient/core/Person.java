/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplerestclient.core;

/**
 *
 * @author bahrie
 */
public class Person {
    private String nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        return hash;
    }
    
    
    
}
