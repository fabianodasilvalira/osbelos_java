package fasira.osbelos.usuario;

import java.util.Objects;

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
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String url_foto;
	private String bebidas_alcoolicas;
	private String bebida_predileta;
	private String contato;
	private String senha;
	@Enumerated
	private Status status;
	
	public Usuario() {
		super();
	}

	public Usuario(DadosCadastroUsuario dados) {
		this.nome = dados.nome();
		this.url_foto = dados.url_foto();
		this.bebida_predileta = dados.bebida_predileta();
		this.bebidas_alcoolicas = dados.bebidas_alcoolicas();
		this.contato = dados.contato();
		this.senha = dados.senha();
		this.status = dados.status();
		
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
	
	

}
