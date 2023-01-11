package fasira.osbelos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fasira.osbelos.usuario.DadosCadastroUsuario;
import fasira.osbelos.usuario.DadosListagemUsuario;
import fasira.osbelos.usuario.Usuario;
import fasira.osbelos.usuario.UsuarioRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("usuarios")
public class UsuarioControllers {
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
		repository.save(new Usuario(dados));
	}
	
	@GetMapping
	public Page<DadosListagemUsuario> listar(Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemUsuario::new);
	}

}
