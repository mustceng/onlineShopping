package com.mustceng.onlineshop.dto1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mustceng.onlineshop.dto1.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class ProductJson {
    @Setter
    @Getter
    @JsonIgnore
    private ProductDTO product;

    public Long getProduct_id(){
        return this.product.getId();
    }
    public String getTitle(){
        return this.product.getTitle();
    }

    public String getCategory(){
        return this.product.getCategory().getName();
    }

    public BigDecimal getNetPrice(){
        return this.product.getNetPrice();
    }

    public Long getVatRate(){
        return this.product.getCategory().getVat();
    }

    public String getPrice(){
        return String.format("%.2f", this.getNetPrice().doubleValue() * ((100+this.product.getCategory().getVat())/100D));
    }
}
