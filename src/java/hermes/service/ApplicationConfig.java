/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Sergio Josemar Pavez Vera
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(hermes.service.BlocksFacadeREST.class);
        resources.add(hermes.service.BranchesFacadeREST.class);
        resources.add(hermes.service.BusinessesFacadeREST.class);
        resources.add(hermes.service.ClientsFacadeREST.class);
        resources.add(hermes.service.CourtsFacadeREST.class);
        resources.add(hermes.service.UsersFacadeREST.class);
        resources.add(hermes.service.WorkersFacadeREST.class);
    }

}
