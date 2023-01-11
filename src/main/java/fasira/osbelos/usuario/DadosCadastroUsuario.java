package fasira.osbelos.usuario;

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
		String senha, 
		Status status
		) {

}
