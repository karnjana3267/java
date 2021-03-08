package com.karnjana.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.karnjana.model.Product;
import com.karnjana.model.ResponseData;
import com.karnjana.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/select-all")
	@ResponseBody
	public ResponseData<List<Product>> selectProductAll() {
		ResponseData<List<Product>> responseData = new ResponseData<List<Product>>();
		try {
			responseData.setData(productService.selectProductAll());
			responseData.setStatus("success");
		} catch (Exception e) {
			e.printStackTrace();
			responseData.setStatus("fail");
		}
		return responseData;
	}
	
	@PostMapping("/insert-product")
	@ResponseBody
	public ResponseData<Integer> insertProduct(@RequestBody Product request) {
		ResponseData<Integer> responseData = new ResponseData<Integer>();
		try {
			responseData.setData(productService.insert(request));
			responseData.setStatus("success");
		} catch (Exception e) {
			e.printStackTrace();
			responseData.setStatus("fail");
		}
		return responseData;
	}
	
	@GetMapping("/select-by-id/{id}")
	@ResponseBody
	public ResponseData<Product> selectProductById(@PathVariable("id") int id) {
		ResponseData<Product> responseData = new ResponseData<Product>();
		try {
			responseData.setData(productService.selectProductById(id));
			responseData.setStatus("success");
		} catch (Exception e) {
			e.printStackTrace();
			responseData.setStatus("fail");
		}
		return responseData;
	}
	
	@GetMapping("/delete-by-id/{id}")
	@ResponseBody
	public ResponseData<Integer> deleteData(@PathVariable("id") int id) {
		ResponseData<Integer> responseData = new ResponseData<Integer>();
		try {
			responseData.setData(productService.delete(id));
			responseData.setStatus("success");
		} catch (Exception e) {
			e.printStackTrace();
			responseData.setStatus("fail");
		}
		return responseData;
	}
}
