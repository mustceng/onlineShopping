package com.mustceng.onlineshop.dto2;

import com.mustceng.onlineshop.dto1.ProductJson;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class CartDTO extends ProductJson {
    @Getter
    @Setter
    private Long id;
}
