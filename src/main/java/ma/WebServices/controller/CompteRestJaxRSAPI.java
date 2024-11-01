package ma.WebServices.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.WebServices.entity.Compte;
import ma.WebServices.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {

    @Autowired
    private CompteRepository compteRepository;



    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Compte> getComptes(){
        return compteRepository.findAll();
    }


    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Compte getCompteById(@PathParam("id") Long id){
        return compteRepository.findById(id).orElse(null);
    }

    @Path("/comptes")
    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Compte createCompte(Compte compte){
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Compte updateCompte(@PathParam("id") Long id, Compte compte){
       Compte existingCompte = compteRepository.findById(id).orElse(null);
       if(existingCompte != null){
           existingCompte.setSolde(compte.getSolde());
           existingCompte.setType(compte.getType());
           existingCompte.setDateCreation(compte.getDateCreation());
           return compteRepository.save(existingCompte);
       }
        return null;
    }


    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Void deleteCompte(@PathParam("id") Long id) {
        compteRepository.deleteById(id);
        return null;
    }



}
