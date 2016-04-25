package com.romajs.components.adl;

import io.yawp.repository.Repository;

import java.util.ArrayList;

import com.romajs.helpers.TestHelper;
import com.romajs.models.product.Product;
import com.romajs.models.user.User;

public class FoodshelfDataLoad implements ApplicationDataLoad {

	Repository yawp; // TODO

	@Override
	public void seed() {
	}

	@Override
	public void importation() {
		for (User user : this.getUsers()) {
			yawp.saveWithHooks(user);
		}
		for (Product product : this.getProducts()) {
			yawp.saveWithHooks(product);
		}
	}

	private ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<>();
		users.add(new User("user1@a.com", "user1", "name1", TestHelper.userPassword("123")));
		return users;
	}

	private ArrayList<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product("Product1", "", TestHelper.bigDecimal(5.00), 0l));
		products.add(new Product("Product2", "", TestHelper.bigDecimal(5.00), 0l));
		products.add(new Product("Product3", "", TestHelper.bigDecimal(5.00), 0l));
		return products;
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub

	}

}
