package fasira.osbelos.domain.postagens;

import fasira.osbelos.domain.usuarios.Usuario;
import fasira.osbelos.util.Status;

public record DadosDetalhamentoPostagens(Long id, Usuario  usuario_id, String url_postagem, String legenda, Status status) {
	
	public DadosDetalhamentoPostagens(Postagens postagens) {
		this(postagens.getId() ,postagens.getUsuario_id(),  postagens.getUrl_postagem(), postagens.getLegenda(), postagens.getStatus());
	}

}
