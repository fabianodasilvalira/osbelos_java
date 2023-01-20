package fasira.osbelos.domain.usuarios;

import fasira.osbelos.util.Status;

public record DetalhamentoUsuarioListagem(Long id, String nome, String url_foto, String bebidas_alcoolicas, String bebida_predileta, String contato, String login, Status status)  {
	public DetalhamentoUsuarioListagem(Usuario usuario) {
		this(usuario.getId(),usuario.getNome(), usuario.getUrl_foto(), usuario.getBebidas_alcoolicas(), usuario.getBebida_predileta(), usuario.getContato(), usuario.getLogin(), usuario.getStatus());
	}
}
