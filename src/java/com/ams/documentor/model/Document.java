/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.documentor.model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author kapil
 */
@Entity
@Table(name = "ams_document")
public class Document implements Model {
    @Id
    @GeneratedValue
    @Column(name = "documentindex")
    int documentIndex;
    
    @Column(name = "parentfolderindex")
    int parentFolderIndex;
    
    @Column(name = "owner")
    int owner;
    
    @Column(name = "documentname")
    String name;
    
    @Column(name = "doctype")
    String docType;
    
    @Column(name = "istype")
    String isType;
    
    @Column(name = "createdat")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date createdAt;
    
    @Column(name = "lastmodifiedat")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date lastModifiedAt;
    
    @Column(name = "lastaccessedat")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date lastAccessedAt;
    
    

    public int getDocumentIndex() {
        return documentIndex;
    }

    public void setDocumentIndex(int documentIndex) {
        this.documentIndex = documentIndex;
    }

    public int getParentFolderIndex() {
        return parentFolderIndex;
    }

    public void setParentFolderIndex(int parentFolderIndex) {
        this.parentFolderIndex = parentFolderIndex;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getIsType() {
        return isType;
    }

    public void setIsType(String isType) {
        this.isType = isType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(Date lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public Date getLastAccessedAt() {
        return lastAccessedAt;
    }

    public void setLastAccessedAt(Date lastAccessedAt) {
        this.lastAccessedAt = lastAccessedAt;
    }

   
            
    
    
}
