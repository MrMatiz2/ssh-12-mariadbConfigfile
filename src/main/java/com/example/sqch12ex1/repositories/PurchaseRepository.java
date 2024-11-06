package com.example.sqch12ex1.repositories;

import com.example.sqch12ex1.entities.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";
        jdbcTemplate.update(
                sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    public List<Purchase> getPurchases() {
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase purchase = new Purchase();
            purchase.setId(r.getInt("id"));
            purchase.setProduct(r.getString("product"));
            purchase.setPrice(r.getBigDecimal("price"));
            return purchase;
        };

        return jdbcTemplate.query(sql, purchaseRowMapper);
    }

}
