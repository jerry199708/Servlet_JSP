package security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtFilter implements Filter {
	private static final String SECRET_KEY = "kwefne324ji532nin63kno53k5jk4j5o43k5po34";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String jwtToken = httpRequest.getHeader("Authorization");
		System.out.println(jwtToken);
		chain.doFilter(request, response);
	}

	private static String generateJwtToken() {
		String result = Jwts.builder().claim("userId", "kwefne324ji532nin63kno53k5jk4j5o43k5po34")
				.signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes())).compact();
		System.out.println("GenerateJwtToken: " + result);
		return result;
	}

	private static boolean encodeJwt(String jwtToken) {
		try {
			Claims claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes())).build()
					.parseClaimsJws(jwtToken).getBody();
			claims.get("userId", String.class);
			return true;
		} catch (Exception E) {
			return false;
		}
	}

	public static void main(String[] args) {
		String token = generateJwtToken();
		boolean isAuthorized = encodeJwt(token);
		if (isAuthorized == true) {
			System.out.println("授權通過");
		} else {
			System.out.println("授權失敗");
		}
	}
}
