package web_study_11.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_study_11.dao.impl.ProductDaoImpl;
import web_study_11.ds.JdbcUtil;
import web_study_11.dto.Product;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {
	private static Connection con;
	private static ProductDaoImpl dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = JdbcUtil.getConnection();
		dao = ProductDaoImpl.getInstance();
		dao.setCon(con);
	}

	@Test
	public void testSelectProductByAll() {
		System.out.println("testSelectProductByAll()");
		List<Product> list = dao.selectProductByAll();
		Assert.assertNotNull(list);
		System.out.println(list);
	}

	@Test
	public void test01InsertProduct() {
		  System.out.println("testInsertProduct");
	      int res = dao.insertProduct(new Product("스리랑", 40000, "mac.jpg","무엇이냐"));
	      Assert.assertEquals(1, res);
	      System.out.println(res);
	}

	@Test
	public void testSelectProductBycode() {
		  System.out.println("testSelectProductBycode()");
	      Product selectEmployee = dao.selectProductBycode(new Product(1));
	      Assert.assertNotNull(selectEmployee);
	      System.out.println(selectEmployee);
	}

	@Test
	public void test02UpdateProduct() {
		  System.out.println("testUpdateProduct()");
	     Product updateproduct = dao.selectProductBycode(new Product(2));
	      updateproduct.setCode(1);
	      int res = dao.updateProduct(updateproduct);
	      Assert.assertEquals(1, res);
	      System.out.println(res);
	}

	@Test
	public void test03DeleteProduct() {
		 System.out.println("testDeleteProduct()");
	      Product delelteproduct = dao.selectProductBycode(new Product(2));
	      int res = dao.deleteProduct(delelteproduct);
	      Assert.assertEquals(1, res);
	}

}
