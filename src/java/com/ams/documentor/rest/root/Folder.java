/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.documentor.rest.root;

import com.ams.documentor.hql.HibernateUtil;
import com.ams.utilities.XML;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kapil
 */
@Path(value = "/folder")
public class Folder {

    @GET
    @Path(value = "/{id}")
    public Response getFolderProperties(
            @PathParam(value = "id") int id,
            @QueryParam(value = "labels") String labels,
            @QueryParam(value = "metaclass") boolean metaClass,
            @QueryParam(value = "alt") String format) {

        Session session = HibernateUtil.getSessionFromSessionFactory();
        String output = "";
        if (session == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        try {
            com.ams.documentor.model.Folder folder = (com.ams.documentor.model.Folder) session.get(com.ams.documentor.model.Folder.class, id);
            XML xml = new XML("folderproperties");

            xml.addElement("status", "0");
            Element folderEl = xml.addElement("folder");
            xml.addElement(folderEl, "foldername", folder.getFolderName());
            xml.addElement(folderEl, "folderindex", folder.getFolderIndex());
            output = xml.writeToString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return Response.ok(output, MediaType.APPLICATION_XML_TYPE).build();
    }

    @POST
    public Response createFolder(String reqBody) {
        SAXReader sax = null;
        com.ams.documentor.model.Folder folder = new com.ams.documentor.model.Folder("foldername ", 4, 0);
        Session session = null;
        Transaction tx = null;
        try {
            sax = new SAXReader();
            Document requestXML = sax.read(new ByteInputStream(reqBody.getBytes(), reqBody.length()));
            session = HibernateUtil.getSessionFromSessionFactory();
            tx = session.getTransaction();
            tx.begin();
            session.save(folder);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }

        return Response.ok("folder created - " + folder.getFolderIndex()).build();

    }
}
