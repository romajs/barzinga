package com.romajs.components.adl;

import io.yawp.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import com.romajs.models.product.Product;

public class FoodshelfDataLoad implements ApplicationDataLoad {

	Repository yawp;

	@Override
	public void seed() {
	}

	@Override
	public void importation() {
		List<Product> users = new ArrayList<>();
		for (Product user : users) {
			yawp.saveWithHooks(user);
		}
		List<Product> products = new ArrayList<>();
		for (Product product : products) {
			yawp.saveWithHooks(product);
		}

	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub

	}

}
