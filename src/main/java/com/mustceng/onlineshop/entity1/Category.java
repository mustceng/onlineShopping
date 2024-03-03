package com.mustceng.onlineshop.entity1;

import com.mustceng.onlineshop.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {
	@Column(name = "name", length = 100)
	private String name;

	@Column(name = "vat")
	private Long vat;

	@Enumerated(EnumType.STRING)
	@Column(name="category_code")
	private CategoryCode categoryCode;

	@ManyToOne
	@JoinColumn(name = "parent_category_id")
	private Category parentCategory;


}
