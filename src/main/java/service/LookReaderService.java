package service;

import java.util.List;

import org.json.simple.JSONArray;

import model.Look;
import dao.LookDao;

/**
 * 
 * @author sharadb
 *
 */
public class LookReaderService
{
	private LookDao dao = new LookDao();

	public List<Look> getAllLooks() {
		return dao.getAllLooks();
	}
	
	public JSONArray getAllLooksAllJson() {
		return dao.getAllLooksAllJson();
	}
}
