package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.Look;
import model.SearchResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.springframework.web.servlet.ModelAndView;

import service.LookReaderService;
import service.SearchService;
import util.SearchResultsExtractor;

@SuppressWarnings("serial")
@WebServlet(name = "Servlet", urlPatterns =
{ "/home" })
public class DefaultController extends HttpServlet
{
	protected final Log logger = LogFactory.getLog(getClass());

	private LookReaderService lookReaderService = new LookReaderService();
	private SearchService searchService = new SearchService();
	private SearchResultsExtractor extractor = new SearchResultsExtractor();

	private JSONArray allLooksJson = lookReaderService.getAllLooksAllJson();
	private List<Look> allLooks = lookReaderService.getAllLooks();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("DefaultController called");

		String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		request.setAttribute("path", host);

		String realizeLookIndex = request.getParameter("realizeLookIndex");
		if (realizeLookIndex != null && !realizeLookIndex.isEmpty())
		{
			Look look = allLooks.get(Integer.parseInt(realizeLookIndex));

			Map<Item, String> rawResults = searchService.getSearchResults(look);

			List<SearchResult> searchResults = extractor.extract(rawResults);

			request.setAttribute("realizeLookIndex", realizeLookIndex);
			request.setAttribute("searchResults", searchResults);
			request.getRequestDispatcher("/WEB-INF/jsp/searchResults.jsp").forward(request, response);
		}
		else
		{

			// HttpSession session = request.getSession();
			// ServletContext sc = session.getServletContext();
			// String x = sc.getRealPath("/");

			// ServletOutputStream out = response.getOutputStream();
			// out.write(host.getBytes());
			// out.flush();

			// List<Look> allLooks = lookReaderService.getAllLooks();

			// request.setAttribute("allLooks", allLooks);
			request.setAttribute("allLooksJson", allLooksJson);
			request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
