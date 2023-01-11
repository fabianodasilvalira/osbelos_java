package fasira.osbelos.usuario;

public record DadosListagemUsuario(String nome, String url_foto, String bebidas_alcoolicas, String bebida_predileta, String contato, String senha, Status status) {
	
	public DadosListagemUsuario(Usuario usuario) {
		this(usuario.getNome(), usuario.getUrl_foto(), usuario.getBebidas_alcoolicas(), usuario.getBebida_predileta(), usuario.getContato(), usuario.getSenha(), usuario.getStatus());
	}

}
