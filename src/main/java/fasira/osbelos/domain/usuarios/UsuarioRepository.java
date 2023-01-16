package fasira.osbelos.domain.usuarios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Page<DadosListagemUsuario> findAllByStatusTrue(Pageable paginacao);

	UserDetails findByLogin(String login);

}
