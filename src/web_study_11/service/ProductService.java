package web_study_11.service;

import java.util.List;

import web_study_11.dao.ProductDao;
import web_study_11.dao.impl.ProductDaoImpl;
import web_study_11.dto.Product;

public class ProductService {
	private ProductDao productdao = ProductDaoImpl.getInstance();
	public List<Product> showProduct(){
		return productdao.selectProductByAll();
	}
	

	
	public int addPdt(Product pdt) {
		return productdao.insertProduct(pdt);
	}
	
	public Product getpdt(Product pdt) {
		return productdao.selectProductBycode(pdt);
	}
	
	public int removepdt(Product pdt) {
		return productdao.deleteProduct(pdt);
	}

	public int updatepdt(Product pdt) {
		return productdao.updateProduct(pdt);
	}
	
	public Product seleProductByCode(Product pdt) {
		return productdao.selectProductBycode(pdt);
	}
}
