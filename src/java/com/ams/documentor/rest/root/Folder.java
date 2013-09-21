/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.documentor.rest.root;

import com.ams.documentor.hql.HibernateUtil;
import com.ams.utilities.XML;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.dom4j.Document;
import org.dom4j.Element;
import org.hibernate.Session;

/**
 *
 * @author kapil
 */
@Path(value = "/folder")
public class Folder {

    @GET
    @Path(value = "/{id}")
    @Produces()
    public Response getFolderProperties(
            @PathParam(value = "id") int id,
            @QueryParam(value = "labels") String labels,
            @QueryParam(value = "metaclass") boolean metaClass,
            @QueryParam(value = "alt") String format) {

        Session session = HibernateUtil.getSessionFromSessionFactory();
        String output = "<folderproperties>";
        if (session == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        try {
            com.ams.documentor.model.Folder folder = (com.ams.documentor.model.Folder) session.get(com.ams.documentor.model.Folder.class, id);
            XML xml = new XML("folderproperties");
            Element rootElement = xml.getRootElement();
            rootElement.addElement("status").addText("0");
            Element folderEl = rootElement.addElement("folder");
            folderEl.addElement("foldername").addText(folder.getFolderName());
            folderEl.addElement("folderindex").addText(Integer.toString(folder.getFolderIndex()));
            output = xml.writeToString();
            System.out.println("output = " + output);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
        }
        
        return Response.ok(output, MediaType.APPLICATION_XML_TYPE).status(Response.Status.OK).build();
    }
}
