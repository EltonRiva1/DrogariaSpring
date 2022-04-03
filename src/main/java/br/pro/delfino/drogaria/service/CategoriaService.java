package br.pro.delfino.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.delfino.drogaria.dominio.Categoria;
import br.pro.delfino.drogaria.exception.RecursoNaoEncontradoException;
import br.pro.delfino.drogaria.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscarPorCodigo(Short codigo) {
		Optional<Categoria> optional = this.categoriaRepository.findById(codigo);
		if (!optional.isPresent()) {
			throw new RecursoNaoEncontradoException();
		}
		Categoria categoria = optional.get();
		return categoria;
	}

	public List<Categoria> listar() {
		// TODO Auto-generated method stub
		List<Categoria> categorias = this.categoriaRepository.findAll();
		return categorias;
	}
}
