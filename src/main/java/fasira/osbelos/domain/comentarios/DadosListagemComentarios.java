package fasira.osbelos.domain.comentarios;

import java.util.Date;

import fasira.osbelos.util.Status;

public record DadosListagemComentarios(Long id, String usuario, String postagem, String comentario, Date date,
		Status status) {
	public DadosListagemComentarios(Comentarios comentario) {
		this(comentario.getId(), comentario.getUsuarioNome(), comentario.getPostagem_id(), comentario.getComentario(),
				comentario.getData(), comentario.getStatus());
	}
}
