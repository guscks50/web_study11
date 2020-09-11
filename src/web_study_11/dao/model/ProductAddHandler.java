package web_study_11.dao.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import web_study_11.dao.ProductDao;
import web_study_11.dao.impl.ProductDaoImpl;
import web_study_11.ds.JdbcUtil;
import web_study_11.dto.Product;
import web_study_11.service.ProductService;



@WebServlet("/ProductAddHandler")
public class ProductAddHandler extends HttpServlet {
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
		if(request.getMethod().equalsIgnoreCase("GET")) {response.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("productAdd.jsp");
		dispatcher.forward(request, response);}else {
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType="UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path,sizeLimit,encType,new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		
		
		Product pdt = new Product();
		pdt.setName(name);
		pdt.setPrice(price);
		pdt.setDescription(description);
		pdt.setPictureurl(pictureUrl);
		
		service.addPdt(pdt);
		
		
		response.sendRedirect("ProductListHandler");
		}
		}
		
	}


