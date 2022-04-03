package br.pro.delfino.drogaria.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.pro.delfino.drogaria.dominio.Categoria;
import br.pro.delfino.drogaria.exception.RecursoNaoEncontradoException;
import br.pro.delfino.drogaria.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaControlador {
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<Categoria> listar() {
		List<Categoria> categorias = this.categoriaService.listar();
		return categorias;
	}

	@GetMapping("/{codigo}")
	public Categoria buscarPorCodigo(@PathVariable Short codigo) {
		try {
			Categoria categoria = this.categoriaService.buscarPorCodigo(codigo);
			return categoria;
		} catch (RecursoNaoEncontradoException e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada", e);
		}
	}

//	@PostMapping
//	public Categoria inserir(@RequestBody Categoria categoria) {
//		Categoria categoriaSalva = this.categoriaRepository.save(categoria);
//		return categoriaSalva;
//	}

//	@DeleteMapping("/{codigo}")
//	public Categoria excluir(@PathVariable Short codigo) {
//		Optional<Categoria> categoria = this.categoriaRepository.findById(codigo);
//		this.categoriaRepository.delete(categoria.get());
//		Categoria categoriaRetorno = categoria.get();
//		return categoriaRetorno;
//	}

//	@PutMapping
//	public Categoria editar(@RequestBody Categoria categoria) {
//		Categoria categoriaEditada = this.categoriaRepository.save(categoria);
//		return categoriaEditada;
//	}
}
