    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hermes.service;

import hermes.Branches;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Sergio Josemar Pavez Vera
 */
@Stateless
@Path("hermes.branches")
public class BranchesFacadeREST extends AbstractFacade<Branches> {

    @PersistenceContext(unitName = "HermesWSPU")
    private EntityManager em;

    public BranchesFacadeREST() {
        super(Branches.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    @Produces("text/plain")
    public String create(Branches entity) {
        return super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Branches entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Branches find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Branches> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Branches> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("/getBranches/{sport}/{date}")
    @Produces({"application/xml", "application/json"})
    public List<Branches> availableBranches(@PathParam("sport") String sport, @PathParam("date") String date) {
        List<Branches> branches;
        try{
            branches = (List<Branches>) em.createNamedQuery("Branches.getBranches")
                    .setParameter("sport", sport)
                    .setParameter("date", getDate(date))
                    .getResultList();
            em.flush();
        } catch (NoResultException e) {
            branches = null;
            System.out.println(e.toString());
        }
        return branches;
    }

}
