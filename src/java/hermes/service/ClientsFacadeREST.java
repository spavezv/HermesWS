/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hermes.service;

import hermes.Clients;
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
@Path("hermes.clients")
public class ClientsFacadeREST extends AbstractFacade<Clients> {

    @PersistenceContext(unitName = "HermesWSPU")
    private EntityManager em;

    public ClientsFacadeREST() {
        super(Clients.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Clients entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Clients entity) {
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
    public Clients find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Clients> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Clients> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("authenticate/{email}/{password}")
    @Produces({"application/xml", "application/json"})
    public Clients name(@PathParam("email") String email, @PathParam("password") String password) {
        Clients c = null;
        try {
            c = (Clients) em.createNamedQuery("Clients.authenticate")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.toString());
            c = new Clients(-1);
        }
        System.out.println(c.getEncryptedPassword());
        return c;
    }
}
