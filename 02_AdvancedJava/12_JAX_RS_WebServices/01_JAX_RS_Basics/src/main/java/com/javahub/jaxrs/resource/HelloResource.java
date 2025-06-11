// File: 02_AdvancedJava/12_JAX_RS_WebServices/01_JAX_RS_Basics/src/main/java/com/javahub/jaxrs/resource/HelloResource.java
package com.javahub.jaxrs.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * A simple JAX-RS resource class to handle HTTP requests.
 * The @Path annotation defines the URI path for this resource.
 */
@Path("/hello") // Relative path from MyApplication's @ApplicationPath("/api")
public class HelloResource {

    /**
     * Handles GET requests to /api/hello.
     * The @Produces annotation specifies the MIME type of the response.
     * @param name Optional query parameter for personalization.
     * @return A greeting message.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN) // Responds with plain text
    public String getHelloMessage(@QueryParam("name") String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello from JAX-RS! Welcome to JavaFullStack.";
        } else {
            return "Hello, " + name + "! Welcome to JavaFullStack JAX-RS API.";
        }
    }
}
