package com.karnjana.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karnjana.jdbc.ProductRepositoryJdbc;
import com.karnjana.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepositoryJdbc productRepositoryJdbc;

	public int insert(Product vo) {
		if(vo.getProductId() != null) {
			return productRepositoryJdbc.update(vo);
		} else {
			return productRepositoryJdbc.insert(vo);
		}
	}

	public List<Product> selectProductAll() {
		List<Product> product = new ArrayList<>();
		product = productRepositoryJdbc.findAll();
		return product;
	}
	
	public Product selectProductById(int id) {
		Product product = new Product();
		product = productRepositoryJdbc.findById(id);
		return product;
	}
	
	public int delete(int id) {
		return productRepositoryJdbc.deleteById(id);
	}
}
