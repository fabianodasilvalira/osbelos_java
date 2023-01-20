package fasira.osbelos.domain.postagens;

import fasira.osbelos.util.Status;

public record DadosListagemPostagens(Long id, String usuario, String url_postagem, String legenda, Status status) {
	
	public DadosListagemPostagens(Postagens postagens) {
		this(postagens.getId() , postagens.getUsuario_nome(),  postagens.getUrl_postagem(), postagens.getLegenda(), postagens.getStatus());
	}

}
