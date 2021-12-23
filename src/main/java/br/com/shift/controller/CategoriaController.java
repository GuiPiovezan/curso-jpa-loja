package br.com.shift.controller;

import br.com.shift.model.Categoria;
import br.com.shift.service.CategoriaService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/categorias")
public class CategoriaController {

    @Inject
    CategoriaService service;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionar(Categoria categoria){
        service.adicionar(categoria);
        return Response.created(URI.create("/categorias")).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> listAll(){
        return service.listAll();
    }
}
