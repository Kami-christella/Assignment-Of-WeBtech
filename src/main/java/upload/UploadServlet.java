package upload;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet implements Filter{

	 @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	        HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;

	        String email = req.getParameter("email");
	        String pictureParameter = req.getParameter("picture");
	        byte[] picture = (pictureParameter != null) ? pictureParameter.getBytes() : null;

	        String documentParameter = req.getParameter("document");
	        byte[] document = (documentParameter != null) ? documentParameter.getBytes() : null;

	        

	        System.out.println("This is before the filter chain");

	        if (email != null && picture != null && document != null) {
	            chain.doFilter(request, response);
	        }

	        System.out.println("This is after the filter chain");
	    }

	    @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	        // Initialization code if needed
	    }

	    @Override
	    public void destroy() {
	        // Cleanup code if needed
	    }
	
}
