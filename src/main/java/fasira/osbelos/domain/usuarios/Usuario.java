package fasira.osbelos.domain.usuarios;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fasira.osbelos.util.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String url_foto;
	private String bebidas_alcoolicas;
	private String bebida_predileta;
	private String contato;
	private String login;
	private String senha;
	@Enumerated
	private Status status;
	

	public Usuario(DadosCadastroUsuario dados) {
		this.nome = dados.nome();
		this.url_foto = dados.url_foto();
		this.bebida_predileta = dados.bebida_predileta();
		this.bebidas_alcoolicas = dados.bebidas_alcoolicas();
		this.contato = dados.contato();
		this.login = dados.login();
		this.senha = dados.senha();
		this.status = dados.status();
		
	}
	
	public void atualizarInformacoes(DadosAtualizacaoUsuario dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.url_foto() != null) {
			this.url_foto = dados.url_foto();
		}
		if (dados.bebidas_alcoolicas() != null) {
			this.bebidas_alcoolicas = dados.bebidas_alcoolicas();
		}
		if (dados.bebida_predileta() != null) {
			this.bebida_predileta = dados.bebida_predileta();
		}
		if (dados.contato() != null) {
			this.contato = dados.contato();
		}
		if (dados.login() != null) {
			this.login = dados.login();
		}

		if (dados.status() != null) {
			this.status = dados.status();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}

	public String getBebidas_alcoolicas() {
		return bebidas_alcoolicas;
	}

	public void setBebidas_alcoolicas(String bebidas_alcoolicas) {
		this.bebidas_alcoolicas = bebidas_alcoolicas;
	}

	public String getBebida_predileta() {
		return bebida_predileta;
	}

	public void setBebida_predileta(String bebida_predileta) {
		this.bebida_predileta = bebida_predileta;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	public void excluir() {
		this.status = Status.INATIVO;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Usuario listarUsuarios() {
		
		return null;
	}


	
	

}
