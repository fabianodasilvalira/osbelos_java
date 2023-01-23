package fasira.osbelos.domain.postagens;

import fasira.osbelos.domain.usuarios.Usuario;
import fasira.osbelos.util.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPostagens(
		@NotNull
		Usuario usuario_id, 
		@NotBlank
		String url_postagem, 
		@NotBlank
		String legenda, 
		Status status
		) {


}
