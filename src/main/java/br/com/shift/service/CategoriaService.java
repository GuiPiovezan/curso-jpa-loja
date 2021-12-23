package br.com.shift.service;

import br.com.shift.model.Categoria;
import br.com.shift.repository.CategoriaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CategoriaService {

    @Inject
    CategoriaRepository repository;

    public void adicionar(Categoria categoria){
        repository.persist(categoria);
    }

    public List<Categoria> listAll() {
        return repository.listAll();
    }
}
