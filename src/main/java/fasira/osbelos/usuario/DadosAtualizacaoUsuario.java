package fasira.osbelos.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(	
		@NotNull
		Long id,
		String nome, 
		String url_foto, 
		String bebidas_alcoolicas, 
		String bebida_predileta, 
		String contato, 
		String senha, 
		Status status) {

}
