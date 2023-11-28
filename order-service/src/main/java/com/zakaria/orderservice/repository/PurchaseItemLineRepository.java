package com.zakaria.orderservice.repository;

import com.zakaria.orderservice.model.Purchase;
import com.zakaria.orderservice.model.PurchaseLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemLineRepository extends JpaRepository<PurchaseLineItem,Long> {
}
