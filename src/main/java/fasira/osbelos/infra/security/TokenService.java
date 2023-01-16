package fasira.osbelos.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import fasira.osbelos.domain.usuarios.Usuario;

@Service
public class TokenService {
	
	
	@Value("${api.security.token.secret}")
	private String secret;
	
	public String gerarToken(Usuario usuario) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secret);
		    return JWT.create()
		        .withIssuer("Api osbelos")
		        .withSubject(usuario.getLogin())
		        .withClaim("login", usuario.getLogin())
		        .withClaim("nome", usuario.getNome())
		        .withExpiresAt(dataExpiracao())
		        .sign(algorithm);
		} catch (JWTCreationException exception){
		    throw new RuntimeException("erro ao gerar token jwt", exception);
		}
	}
	
	public String getSubject(String tokenJWT) {

		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
		    return JWT.require(algorithm)
		        // specify an specific claim validations
			    .withIssuer("Api osbelos")
		        .build()
		        .verify(tokenJWT)
		        .getSubject();
		        

		} catch (JWTVerificationException exception){
			throw new RuntimeException("token JWT inválido ou expirado!t");
		}
	}
	
	private Instant dataExpiracao() {
		
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
		
	}

}
