/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hermes.service;

import hermes.Blocks;
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
@Path("hermes.blocks")
public class BlocksFacadeREST extends AbstractFacade<Blocks> {

    @PersistenceContext(unitName = "HermesWSPU")
    private EntityManager em;

    public BlocksFacadeREST() {
        super(Blocks.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    @Produces("text/plain")
    public String create(Blocks entity) {
        return super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Blocks entity) {
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
    public Blocks find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Blocks> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Blocks> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("getBlocks/{sport}/{date}/{branch}")
    @Produces({"application/xml", "application/json"})
    public List<Blocks> getBlocks(@PathParam("sport") String sport, @PathParam("date") String date, @PathParam("branch") Integer branch) {
        List<Blocks> blocks;
        try{
            blocks = (List<Blocks>) em.createNamedQuery("Blocks.getBlocks")
                    .setParameter("sport", sport)
                    .setParameter("date", getDate(date))
                    .setParameter("branch", branch)
                    .getResultList();
            em.flush();
        } catch (NoResultException e) {
            blocks = null;
            System.out.println(e.toString());
        }
        return blocks;
    }


}
