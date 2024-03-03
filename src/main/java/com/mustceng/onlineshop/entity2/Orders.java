package com.mustceng.onlineshop.entity2;

import com.mustceng.onlineshop.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends BaseEntity {

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "address")
	private String address;

	@Column(name = "cancel_order")
    private Boolean cancelOrder ;

	@OneToMany(mappedBy = "order")
	private Set<OrderDetail> orderDetails = new HashSet<>();

}
