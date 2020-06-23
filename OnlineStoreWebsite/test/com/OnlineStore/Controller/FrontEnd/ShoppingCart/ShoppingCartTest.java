package com.OnlineStore.Controller.FrontEnd.ShoppingCart;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.OnlineStore.Entity.Product;

public class ShoppingCartTest {

	@Test
	public void test() {

		ShoppingCart cart = new ShoppingCart();
		Product product = new Product();
		product.setProductId(1);

		cart.addItem(product);
		cart.addItem(product);

		Map<Product, Integer> items = cart.getItems();
		int quantity = items.get(product);

		assertEquals(2, quantity);
	}

	@Test
	public void testRemoveItem() {

		ShoppingCart cart = new ShoppingCart();
		Product product = new Product();
		product.setProductId(1);

		cart.addItem(product);
		cart.addItem(product);

		cart.removeItem(product);
		assertTrue(cart.getItems().isEmpty());
	}

	@Test
	public void testTestGetQuantity() {

		ShoppingCart cart = new ShoppingCart();
		Product product = new Product();
		product.setProductId(2);
		product.setProductId(3);
		product.setPrice(10);

		cart.addItem(product);
		cart.addItem(product);
		cart.addItem(product);

		assertEquals(3, cart.getTotalQuantity());
	}

	@Test
	public void testTestTotalAmout() {

		ShoppingCart cart = new ShoppingCart();
		assertEquals(0.0f, cart.getTotalAmount(), 0.0f);
	}

	@Test
	public void testTestTotalAmout2() {

		ShoppingCart cart = new ShoppingCart();

		Product product = new Product();
		product.setProductId(2);
		product.setProductId(3);
		product.setPrice(10);

		cart.addItem(product);
		cart.addItem(product);
		cart.addItem(product);

		assertEquals(30.0f, cart.getTotalAmount(), 0.0f);
	}

	@Test
	public void testClearCart() {

		ShoppingCart cart = new ShoppingCart();

		Product product = new Product();
		product.setProductId(2);
		product.setProductId(3);
		product.setPrice(10);

		cart.addItem(product);
		cart.addItem(product);
		cart.addItem(product);
		
		cart.clearCart();
		assertEquals(0, cart.getTotalQuantity());
	}

}
