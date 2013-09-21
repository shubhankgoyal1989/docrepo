/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.documentor.rest.root;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 *
 * @author kapil
 */
@Path(value = "/folder")
public class Folder {
    @GET

    @Path(value = "/{id}")
    public Response getFolderProperties(@PathParam(value = "id") String id){
        String query = "FROM com.ams.documentor.model.Folder AS F where F.folderIndex = " + id;
        
        return Response.ok().build();
    }
}
