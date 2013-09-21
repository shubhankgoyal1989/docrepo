/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.documentor.model;


import javax.persistence.*;

/**
 *
 * @author kapil
 */
@Entity
@Table(name = "ams_site")
public class Site implements Model{
    @Id
    @GeneratedValue
    @Column(name = "siteid")        
    int siteId;
    
    @Column(name = "inetaddress")
    String ipAddress;
    
    @Column(name = "port")
    int port;

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    
}
