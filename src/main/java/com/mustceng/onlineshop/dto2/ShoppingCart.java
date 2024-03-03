package com.mustceng.onlineshop.dto2;

import com.mustceng.onlineshop.dto2.CartDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    @Getter
    @Setter
    List<CartDTO> cart;

    public String getTotalPrice(){
        double total = 0D;
        for (CartDTO item : cart){
            total += item.getNetPrice().doubleValue() * (( 100 + item.getProduct().getCategory().getVat())/100D);
        }
        return String.format("%.2f", total);
    }
}
