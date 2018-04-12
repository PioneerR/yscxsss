package com.yscxsss.service.product;

import com.yscxsss.entity.Product;

import java.util.List;

public interface ProductService {

	/**
	 * 增加
	 * @param 
	 * @return
	 */
	public boolean addProduct(Product p);

	/**
	 * 删除
	 * @param 
	 * @return
	 */
	public boolean deleteProductById(int productId);

	/**
	 * 修改
	 * @param 
	 * @return
	 */
	public boolean updateProduct(Product p);

	/**
	 * 查询
	 * @return
	 */
	public List<Product> getAllProducts();

	/**
	 * 根据id查询
	 * @param 
	 * @return
	 */
	public Product getProductById(int productId);


	
	
	
}
