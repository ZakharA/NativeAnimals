/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.country;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author zakhar
 */
@Stateless
@Path("/country")
public class CountryResource {

    @Context
    private UriInfo context;
    
    @EJB
    private CountryBean bean;
    /**
     * Creates a new instance of CountryResource
     */
    public CountryResource() {
    }

    /**
     * Retrieves representation of an instance of me.arsentii.country.CountryResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        return "hi";
    }
    
    @GET
    @Path("/{string}")
    @Produces(MediaType.APPLICATION_JSON)
    public Countries getCountry(@PathParam("string") String countryLetter) {
         return bean.getCountry(countryLetter);
    }
    /**
     * PUT method for updating or creating an instance of CountryResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
