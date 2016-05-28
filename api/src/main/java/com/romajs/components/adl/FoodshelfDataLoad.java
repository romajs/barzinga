package com.romajs.components.adl;

import io.yawp.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.romajs.helpers.TestHelper;
import com.romajs.models.attachment.Attachment;
import com.romajs.models.product.Product;
import com.romajs.models.user.User;

public class FoodshelfDataLoad implements ApplicationDataLoad {

	class Importation {

		ArrayList<Attachment> getAttachments() {
			String json = TestHelper.resourceContent("data-loader/importation/attachment.json");
			return gson.fromJson(json, new TypeToken<List<Attachment>>() {
			}.getType());
		}

		ArrayList<Product> getProducts() {
			String json = TestHelper.resourceContent("data-loader/importation/product.json");
			return gson.fromJson(json, new TypeToken<List<Product>>() {
			}.getType());
		}

		ArrayList<User> getUsers() {
			ArrayList<User> users = new ArrayList<>();
			users.add(new User("user1@a.com", "user1", "name1", TestHelper.userPassword("123")));
			return users;
		}
	}

	class Perform {

		List<JSONObject> productAttachment() {
			List<JSONObject> jsonObjects = new ArrayList<>();
			String json = TestHelper.resourceContent("data-loader/perform/product-attachment.json");
			try {
				JSONArray jsonArray = new JSONArray(json);
				for (int i = 0; i < jsonArray.length(); i++) {
					jsonObjects.add(jsonArray.getJSONObject(i));
				}
				return jsonObjects;
			} catch (JSONException e) {
				throw new RuntimeException(e);
			}
		}

	}

	public static void main(String[] args) {
		FoodshelfDataLoad dataLoad = new FoodshelfDataLoad();
		// dataLoad.importation();
		dataLoad.perform();
	}

	Gson gson = new Gson();

	Repository yawp; // TODO

	@Override
	public void importation() {
		Importation importation = new Importation();
		for (User user : importation.getUsers()) {
			// yawp.saveWithHooks(user);
		}
		for (Product product : importation.getProducts()) {
			System.out.println(product.toString());
			// yawp.saveWithHooks(product);
		}
		for (Attachment attachment : importation.getAttachments()) {
			System.out.println(attachment.toString());
			// yawp.saveWithHooks(attachment);
		}
	}

	@Override
	public void perform() {
		Perform perform = new Perform();
		for (JSONObject jsonObject : perform.productAttachment()) {
			try {
				String productName = jsonObject.getJSONObject("product").getString("name");
				Product product = yawp.query(Product.class).where("name", "=", productName).first();

				String attachmentName = jsonObject.getJSONObject("attachment").getString("name");
				Attachment attachment = yawp.query(Attachment.class).where("name", "=", attachmentName).first();

				attachment.setProductId(product.getId());
				yawp.saveWithHooks(attachment);
			} catch (JSONException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void seed() {
		
	}

}
