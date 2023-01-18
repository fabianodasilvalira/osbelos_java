package fasira.osbelos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fasira.osbelos.domain.postagens.DadosCadastroPostagens;
import fasira.osbelos.domain.postagens.DadosDetalhamentoPostagens;
import fasira.osbelos.domain.postagens.DadosListagemPostagens;
import fasira.osbelos.domain.postagens.Postagens;
import fasira.osbelos.domain.postagens.PostagensRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("postagens")
public class PostagensControllers {
	
	@Autowired
	private PostagensRepository repository;
	
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoPostagens> cadastrar(@RequestBody @Valid DadosCadastroPostagens dados, UriComponentsBuilder uriBuilder) {
		System.out.println(" ----- "+ dados);
		var postagem = new Postagens(dados);
		repository.save(postagem);
		
		var uri = uriBuilder.path("/postagem/{id}").buildAndExpand(postagem.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoPostagens(postagem));
		
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemPostagens>> listar(Pageable paginacao){

		var page = repository.findAll(paginacao).map(DadosListagemPostagens::new);
		return ResponseEntity.ok(page);
	}
//	
	
//	@GetMapping("/{id}")
//	public ResponseEntity<DadosDetalhamentoUsuario> detalhar(@PathVariable Long id) {
//		var usuario = repository.getReferenceById(id);
//		return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
//	}
//	
//	@PutMapping
//	@Transactional
//	public ResponseEntity<DadosDetalhamentoUsuario> atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
//		var usuario = repository.getReferenceById(dados.id());
//		usuario.atualizarInformacoes(dados);
//		
//		return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));	}
//	
//	@DeleteMapping("/{id}")
//	@Transactional
//	public ResponseEntity<String> excluir(@PathVariable Long id) {
//		repository.deleteById(id);
//		return ResponseEntity.noContent().build();
//	}

}










