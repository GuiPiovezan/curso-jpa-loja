package br.com.shift.controller;

import br.com.shift.model.Produto;
import br.com.shift.service.ProdutoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/produtos")
public class ProdutoController {

    @Inject
    ProdutoService service;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(Produto produto){
        service.cadastrar(produto);
        return Response.created(URI.create("/produtos")).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listarAll(){
        return service.listProdutos();
    }

}
