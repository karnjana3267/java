package com.karnjana.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.karnjana.model.Product;

@Repository
public class ProductRepositoryJdbc {
	@Autowired
    JdbcTemplate jdbcTemplate;

	private RowMapper<Product> producteRowMapper = new RowMapper<Product>() {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
        	product.setProductId(rs.getInt("PRODUCT_ID"));
            product.setProductName(rs.getString("PRODUCT_NAME"));
            product.setProductDesc(rs.getString("PRODUCT_DESC"));
            product.setProductPrice(rs.getDouble("PRODUCT_PRICE"));
            product.setProductStock(rs.getInt("PRODUCT_STOCK"));
			return product;
		}
	};
	
    public List<Product> findAll() {
        return jdbcTemplate.query("select * from product", producteRowMapper);
    }

    public Product findById(int id) {
        return jdbcTemplate.queryForObject("select * from product where PRODUCT_ID=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper<>(Product.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from product where PRODUCT_ID=?", new Object[] {
            id
        });
    }

    public int insert(Product product) {
        return jdbcTemplate.update("insert into product (PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESC, PRODUCT_PRICE, PRODUCT_STOCK) " + "values(?, ?, ?, ?, ?)",
            new Object[] {
            		product.getProductId(), product.getProductName(), product.getProductDesc(), product.getProductPrice(), product.getProductStock()
            });
    }

    public int update(Product product) {
        return jdbcTemplate.update("update product " + " set PRODUCT_NAME = ?, PRODUCT_DESC = ?, PRODUCT_PRICE = ?, PRODUCT_STOCK = ? " + " where PRODUCT_ID = ?",
            new Object[] {
            		product.getProductName(), product.getProductDesc(), product.getProductPrice(), product.getProductStock(), product.getProductId()
            });
    }
}
