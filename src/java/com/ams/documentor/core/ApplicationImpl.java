
package com.ams.documentor.core;

import com.ams.documentor.folder.test;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author kapil
 */
public class ApplicationImpl extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> rootClasses = new HashSet<Class<?>>();
        // add all the root resources to rootClasses
        rootClasses.add(test.class);
        return rootClasses;
    }
    
}
