package com.ams.documentor.model;

import com.ams.utilities.OperandUtil;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author kapil
 */
@Entity
@Table(name = "ams_folder")
public class Folder implements Model{

    protected Folder() {
    
    }
    
    /**
     * Initialize the folder object, All the parameters are manadatory.
     * @param name
     * @param userIndex
     * @param parentFolderIndex 
     * 
     * @throws IllegalArgumentException if any of the parameters is null.
     */
    public Folder(String name,int userIndex, int parentFolderIndex){
        if(OperandUtil.isNull(name) || OperandUtil.isNull(userIndex) || OperandUtil.isNull(parentFolderIndex)){
            throw new IllegalArgumentException("Folder name, User Index, ParentFolder index are manadatory params");
        }
        this.folderName = name;
        this.hasChildFolders = false;
        this.createdAt = new Date();
        this.lastModifiedAt = new Date();
        this.owner = userIndex;
        this.parentFolderIndex = parentFolderIndex | 0;
    }
    @Id
    @GeneratedValue
    @Column(name = "folderindex")
    int folderIndex;
    
    @Column(name = "parentfolderindex")
    int parentFolderIndex;
    
    @Column(name = "name")
    String folderName;
    
    
    @Column(name = "owner")
    int owner;
    
    @Column(name = "createdat")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date createdAt;
    
    @Column(name = "lastmodifiedat")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date lastModifiedAt;
    
    @Column(name="haschildren")
    boolean hasChildFolders;

    public int getFolderIndex() {
        return folderIndex;
    }

    public void setFolderIndex(int folderIndex) {
        this.folderIndex = folderIndex;
    }

    public int getParentFolderIndex() {
        return parentFolderIndex;
    }

    public void setParentFolderIndex(int parentFolderIndex) {
        this.parentFolderIndex = parentFolderIndex;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
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

    public boolean isHasChildFolders() {
        return hasChildFolders;
    }

    public void setHasChildFolders(boolean hasChildFolders) {
        this.hasChildFolders = hasChildFolders;
    }

    /**
     * Get all the child folders for this folder.
     *
     * @return List<Folder> - folders which have (parentfolderindex ==
     * this.folderIndex), cannot be null.
     */
    public List<Folder> getChildFolders() {
        List<Folder> childFolders = null;
        return childFolders;
    }
}
