package com.mustceng.onlineshop.dto1;

import com.mustceng.onlineshop.entity1.Category;
import com.mustceng.onlineshop.entity1.CategoryCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO  {
	private Long id;
	private Long vat;

	private String name;
	private CategoryCode categoryCode;
	private Category parentCategory;

	public void setCategoryCodeMap(Map<String, String> categoryCodeMap) {
		if (categoryCodeMap != null) {
			this.categoryCode = CategoryCode.fromValue(categoryCodeMap.get("value"));
		}
	}

	public Map<String, String> getCategoryCodeMap() {
		if (categoryCode == null) return null;
		Map<String, String> categoryCodeMap = new HashMap<>();
		categoryCodeMap.put("name", categoryCode.name());
		categoryCodeMap.put("value", categoryCode.getValue());
		return categoryCodeMap;
	}

}
