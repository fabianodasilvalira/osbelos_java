package fasira.osbelos.domain.postagens;

import java.util.Objects;

import fasira.osbelos.domain.usuarios.Usuario;
import fasira.osbelos.util.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "postagens")
@Entity(name = "Postagens")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Postagens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
	private Usuario usuario_id;
	private String url_postagem;
	private String legenda;

	@Enumerated
	private Status status;


	public Postagens(DadosCadastroPostagens dados, String caminho) {
		this.usuario_id = dados.usuario_id();
		this.url_postagem = caminho;
		this.legenda = dados.legenda();
		this.status = dados.status();

	}
 
	public void atualizarInformacoes(DadosAtualizacaoPostagens dados) {
//		if (dados.nome() != null) {
//			this.nome = dados.nome();
//		}
//		if (dados.url_foto() != null) {
//			this.url_foto = dados.url_foto();
//		}
//		if (dados.bebidas_alcoolicas() != null) {
//			this.bebidas_alcoolicas = dados.bebidas_alcoolicas();
//		}
//		if (dados.bebida_predileta() != null) {
//			this.bebida_predileta = dados.bebida_predileta();
//		}
//		if (dados.contato() != null) {
//			this.contato = dados.contato();
//		}
//		if (dados.login() != null) {
//			this.login = dados.login();
//		}
//		if (dados.senha() != null) {
//			this.senha = dados.senha();
//		}
//		if (dados.status() != null) {
//			this.status = dados.status();
//		}
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario_nome() {
		var nome_usuario = this.usuario_id.getNome();
		return nome_usuario;
		
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getUrl_postagem() {
		return url_postagem;
	}

	public void setUrl_postagem(String url_postagem) {
		this.url_postagem = url_postagem;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
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
		Postagens other = (Postagens) obj;
		return Objects.equals(id, other.id);
	}

	public void excluir() {
		this.status = Status.INATIVO;

	}

}
