package com.zakaria.orderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal unit_price;
    private Integer quantity;
    private String code;
    @JsonIgnore
    @OneToMany(mappedBy = "purchase",cascade = CascadeType.ALL)
    private List<PurchaseLineItem> purchaseLineItemList;

}
