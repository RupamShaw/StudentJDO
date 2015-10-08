package org.jagruti.javaweb;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

import org.jagruti.javaweb.model.Customer;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class TestinJDOServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
		Entity e=new Entity("Customer");
		e.setProperty("name", "toe");
		e.setProperty("email", "e@tt.com");
		e.setProperty("date", new Date());
		ds.put(e);
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Customer.class);
		q.setOrdering("date desc");

		List<Customer> results = null;

		try {
			results = (List<Customer>) q.execute();
System.out.println("got result results"+results);
			if (results.isEmpty()) {
			//	model.addAttribute("customerList", null);
			System.out.println("in if");
			} else {
				//model.addAttribute("customerList", results);
			System.out.println("else");
			}

		} finally {
			q.closeAll();
			pm.close();
		}
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
