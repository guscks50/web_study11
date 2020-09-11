package web_study_11.dao.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import web_study_11.dao.impl.ProductDaoImpl;
import web_study_11.ds.JdbcUtil;
import web_study_11.dto.Product;
import web_study_11.service.ProductService;



@WebServlet("/ProductListHandler")
public class ProductListHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
	private static Connection con;
	private static ProductDaoImpl dao;

	public void init() throws ServletException {
		service = new ProductService();
		con = JdbcUtil.getConnection();
		dao = ProductDaoImpl.getInstance();
		dao.setCon(con);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");
			List<Product> list = service.showProduct();
			request.setAttribute("list", list);
			request.getRequestDispatcher("productList.jsp").forward(request, response);
			
		}else {
			System.out.println("POST");
			List<Product> list = service.showProduct();
			Gson gson = new Gson();
			
			String result = gson.toJson(list, new TypeToken<List<Product>>(){}.getType());
			System.out.println(result);
			
			response.setContentType("Application/json");
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			
			PrintWriter pw = response.getWriter();
			pw.print(result);
			pw.flush();

		}
		
	}

}
