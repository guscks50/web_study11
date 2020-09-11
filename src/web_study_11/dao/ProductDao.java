package web_study_11.dao;

import java.util.List;

import web_study_11.dto.Product;

public interface ProductDao {
	List<Product> selectProductByAll();
	int insertProduct(Product pdt);
//	int confirmId(String userId);
//	int userCheck(String userId, String pwd);
	Product selectProductBycode(Product pdt);
	int updateProduct(Product pdt);
	int deleteProduct(Product pdt);
}
