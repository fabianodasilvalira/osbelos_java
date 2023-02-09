package fasira.osbelos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fasira.osbelos.domain.comentarios.ComentariosRepository;
import fasira.osbelos.domain.comentarios.DadosListagemComentarios;


@RestController
@RequestMapping("comentarios") 
public class ComentariosControllers {
	
	@Autowired
	private ComentariosRepository repository;
	
	 
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemComentarios>> listar(Pageable paginacao) {
		
		var page = repository.findAll(paginacao).map(DadosListagemComentarios::new);
		
		return ResponseEntity.ok(page);
//		return ResponseEntity.ok(page);
	}

}










