package com.web2project.WEB2P.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/register") //was ("/myresource")
public class register {
	
	@GET 
    @Produces("text/plain")
    public String showIt() {
        return "this is registration page";
    }
}
