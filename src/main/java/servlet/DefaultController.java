package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Look;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import service.LookReaderService;

@SuppressWarnings("serial")
@WebServlet(
        name = "Servlet", 
        urlPatterns = {"/home"}
    )
public class DefaultController extends HttpServlet {
    protected final Log logger = LogFactory.getLog(getClass());
 
    private LookReaderService lookReaderService = new LookReaderService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort(); 
    	request.setAttribute("path", host);
        
    	//HttpSession session = request.getSession();
        //ServletContext sc = session.getServletContext();
        //String x = sc.getRealPath("/");
    	
        //ServletOutputStream out = response.getOutputStream();
        //out.write(host.getBytes());
        //out.flush();
        
    	List<Look> allLooks = lookReaderService.getAllLooks();
    	
    	String now = (new Date()).toString();
        request.setAttribute("now", now);
        request.setAttribute("allLooks", allLooks);
        request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	ServletOutputStream out = resp.getOutputStream();
        out.write("heroku".getBytes());
        out.flush();
    	handleRequest(req, resp);
    }
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
        return new ModelAndView("/WEB_INF/jsp/main.jsp", "now", now);
    }
}

