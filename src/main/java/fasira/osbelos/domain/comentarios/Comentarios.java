package fasira.osbelos.domain.comentarios;

import java.util.Date;

import fasira.osbelos.domain.postagens.Postagens;
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

@Table(name = "comentarios")
@Entity(name = "Comentarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comentarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
	private Usuario usuario_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postagem_id")
	private Postagens postagem_id;
	
	private String comentario;
	
	private Date data;

	@Enumerated
	private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getPostagem_id() {
		return postagem_id.getId().toString();
	}

	public void setPostagem_id(Postagens postagem_id) {
		this.postagem_id = postagem_id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getUsuarioNome() {
		// TODO Auto-generated method stub
		return usuario_id.getId().toString();
	}

	
	

}
