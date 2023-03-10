package fasira.osbelos.domain.usuarios;

import fasira.osbelos.util.Status;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
		@NotBlank
		String nome, 
		
		String url_foto, 
		String bebidas_alcoolicas, 
		String bebida_predileta, 
		
		@NotBlank
		String contato, 
		@NotBlank
		String login, 
		@NotBlank
		String senha, 
		Status status
		) {

}
