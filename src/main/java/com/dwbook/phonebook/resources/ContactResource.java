package com.dwbook.phonebook.resources;

import com.dwbook.phonebook.dao.ContactDAO;
import com.dwbook.phonebook.representations.Contact;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/contact") //URI Template of the resource --- the URI Template is defined here
@Produces(MediaType.APPLICATION_JSON)
//Response Content-Type heasder --> it is used to instruct Jackson to transform the represenntation to the appt format _> JSON
public class ContactResource {
    /*@GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        //Retrieve the record
        return Response.ok("{contact_id: " + id + ", name: \"Dummy Name\", phone: \"+0123456789\"  }").build();
    }
*/

    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        //Retrieve the record
        Contact contact = contactDao.getContactById(id);
        //return Response.ok(new Contact(id, "John", "Doe", "+9123456789")).build();
        return Response.ok(contact).build();
    }

   /* @POST
    public Response createContact(@FormParam("name") String name, @FormParam("phone") String phone) {
        return Response.created(null).build(); //send a 201 created response code to the client--> along with the URI of the newly created resource... the URI can be passed as a parameter to this method and will be use as the value for the Location header of the RESPONSE
    }*/

    @POST
    public Response createContact(Contact c) {
        return Response.created(null).build(); //send a 201 created response code to the client--> along with the URI of the newly created resource... the URI can be passed as a parameter to this method and will be use as the value for the Location header of the RESPONSE
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        //delete the contact for this id
        return Response.noContent().build(); // this no content method sends a 204 No content response code
    }

    private final ContactDAO contactDao;


    /*@PUT
    @Path("/{id}")
    public Response updateContact(
            @PathParam("id") int id,
            @FormParam("fName") String fName,
            @FormParam("sName") String sName,
            @FormParam("phone") String phone
    ) {
        //update the contact with provided ID

        //now returning ResponseBuilder istance after building the ResponseBuilder instance
        return Response.ok(new Contact(id, fName, sName, phone)).build(); //The method ok accepts an Object instance s the parameterwhich is then serialised to our service's response format defined by the @Produces annotation ... the usage of this method returns an HTTP 200 ok response code to the client
    }*/

    @PUT
    @Path("/{id}")
    public Response updateContact(@PathParam("id") int id, Contact c) {
        //update the contact with provided ID

        //now returning ResponseBuilder istance after building the ResponseBuilder instance
        return Response.ok(new Contact(id, c.getFirstName(), c.getLastName(), c.getPhone())).build(); //The method ok accepts an Object instance s the parameterwhich is then serialised to our service's response format defined by the @Produces annotation ... the usage of this method returns an HTTP 200 ok response code to the client
    }

    public ContactResource(DBI jdbi) {
        contactDao = jdbi.onDemand(ContactDAO.class);
    }


}
