package br.com.shift.service;

import br.com.shift.model.Categoria;
import br.com.shift.model.Produto;
import br.com.shift.repository.CategoriaRepository;
import br.com.shift.repository.ProdutoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository repository;

    public void cadastrar(Produto produto){
        CategoriaRepository categoriaRepository = new CategoriaRepository();
        categoriaRepository.findById(produto.getCategoria().getId());
        repository.persist(produto);
    }

    public List<Produto> listProdutos(){
        return repository.listAll();
    }
}
