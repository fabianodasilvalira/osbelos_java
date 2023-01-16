package fasira.osbelos.domain.usuarios;

import fasira.osbelos.util.Status;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(	
		@NotNull
		Long id,
		String nome, 
		String url_foto, 
		String bebidas_alcoolicas, 
		String bebida_predileta, 
		String contato,
		String login, 
		String senha, 
		Status status) {

}
