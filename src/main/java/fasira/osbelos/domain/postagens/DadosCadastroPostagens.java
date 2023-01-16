package fasira.osbelos.domain.postagens;

import fasira.osbelos.util.Status;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPostagens(
		@NotBlank
		String usuario_id, 
		@NotBlank
		String url_postagem, 
		@NotBlank
		String legenda, 
		@NotBlank
		Status status
		) {

}
