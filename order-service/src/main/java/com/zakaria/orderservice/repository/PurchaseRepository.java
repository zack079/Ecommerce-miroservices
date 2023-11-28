package com.zakaria.orderservice.repository;

import com.zakaria.orderservice.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
