package shopcart;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "EncodeFilter", urlPatterns = { "/*" })
public class EncodeFilter implements Filter {
	private String encode;

	public EncodeFilter() {

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		String encode = filterConfig.getInitParameter("encode");
		if (encode == null) {
			encode = "UTF-8";
			this.encode = encode;
		}
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding(encode);
		resp.setCharacterEncoding(encode);
		resp.setContentType("text/html;charset=utf-8");
		chain.doFilter(req, resp);
	}

	public void destroy() {

	}

}
