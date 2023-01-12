package fasira.osbelos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fasira.osbelos.domain.usuario.DadosAtualizacaoUsuario;
import fasira.osbelos.domain.usuario.DadosCadastroUsuario;
import fasira.osbelos.domain.usuario.DadosDetalhamentoUsuario;
import fasira.osbelos.domain.usuario.DadosListagemUsuario;
import fasira.osbelos.domain.usuario.Usuario;
import fasira.osbelos.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("usuarios")
public class UsuarioControllers {
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
		var usuario = new Usuario(dados);
		repository.save(usuario);
		
		var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
		
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemUsuario>> listar(Pageable paginacao){
		var page = repository.findAll(paginacao).map(DadosListagemUsuario::new);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoUsuario> detalhar(@PathVariable Long id) {
		var usuario = repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoUsuario> atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
		var usuario = repository.getReferenceById(dados.id());
		usuario.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> excluir(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}










