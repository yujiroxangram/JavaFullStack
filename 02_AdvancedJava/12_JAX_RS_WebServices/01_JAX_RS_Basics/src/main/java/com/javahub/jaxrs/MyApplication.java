// File: 02_AdvancedJava/12_JAX_RS_WebServices/01_JAX_RS_Basics/src/main/java/com/javahub/jaxrs/MyApplication.java
package com.javahub.jaxrs;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import com.javahub.jaxrs.resource.HelloResource;

/**
 * Defines the root path for the JAX-RS application and registers resources.
 * The @ApplicationPath annotation specifies the base URI for all resource URIs.
 * This class extends jakarta.ws.rs.core.Application to tell the JAX-RS runtime
 * which classes are resources.
 */
@ApplicationPath("/api") // Base URI for the application
public class MyApplication extends Application {

    /**
     * Returns a set of root resource classes and provider classes.
     * In this case, we register our HelloResource.
     * @return A set containing the resource classes.
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        // Register your resource classes here
        classes.add(HelloResource.class);
        return classes;
    }
}
