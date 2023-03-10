package fasira.osbelos.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

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
import fasira.osbelos.util.Conversor;

@RestController
@RequestMapping("postagens")
public class PostagensControllers {

	@Autowired
	private PostagensRepository repository;

	private static String caminhoImagem = System.getProperty("user.dir") + "/src/main/resources/uploadImages/";

	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoPostagens> cadastrar(@RequestBody @Valid DadosCadastroPostagens dados,
			UriComponentsBuilder uriBuilder) throws IOException {

		String base64string = dados.url_postagem();
		var extension = base64string.substring(11, 14);
		base64string = base64string.replaceFirst("^data:image/[^;]*;base64,?", "");

		byte[] decodeImg = Base64.getDecoder().decode(base64string);
		Date dataAtual = new Date();

		var nomeArquivo = Conversor.getHashMd5(dataAtual.toString());
		java.nio.file.Path caminho = Paths.get(caminhoImagem + nomeArquivo + "." + extension);

		Files.write(caminho, decodeImg);

		var url_postagem = caminhoImagem + nomeArquivo +  "." + extension;
		var postagem = new Postagens(dados, url_postagem);
		repository.save(postagem);

		var uri = uriBuilder.path("/postagem/{id}").buildAndExpand(postagem.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoPostagens(postagem));

	}

	@GetMapping
	public ResponseEntity<Page<DadosListagemPostagens>> listar(Pageable paginacao) {
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
