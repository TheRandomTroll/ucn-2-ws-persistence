package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controllers.OrderController;
import controllers.ProductController;
import models.ClothingProduct;
import models.Invoice;
import models.Product;

public class MainMenu {
	private Scanner sc;
	private OrderController orderController;
	private ProductController productController;

	public MainMenu() {
		this.sc = new Scanner(System.in);
		this.orderController = new OrderController();
		this.productController = new ProductController();
	}

	public void run() {
		System.out.println("---- MAIN MENU ----");
		System.out.println("(1) Create order");
		System.out.print("Enter your option: ");
		int choice = Integer.parseInt(sc.nextLine());
		if (choice == 1) {
			createOrder();
		}
	}

	private void createOrder() {
		System.out.print("Enter the customer's phone number: ");
		String phoneNo = sc.nextLine();
		List<Product> selectedProducts = new ArrayList<>();

		boolean isRunning = true;
		while (isRunning) {
			System.out.print("Enter the product's barcode, or \"Checkout\" to finish the order: ");
			String input = sc.nextLine();
			if (input.equals("Checkout")) {
				Invoice i = this.orderController.createOrder(selectedProducts, phoneNo);
				System.out.printf("Order #%d has been placed!\nEstimated delivery date: %s", i.getOrder().getId(), i.getOrder().getDeliveryDate().toString());
				System.out.println(i.toString());
				isRunning = false;
			} else if (isNumeric(input)) {
				int barcode = Integer.parseInt(input);
				Product p = this.productController.findByBarcode(barcode);
				if (p == null) {
					System.out.printf("Product with barcode %d not found.\n", barcode);
				} else {
					selectedProducts.add(p);
					System.out.printf("%s added to order!\n", p.getName());
				}
			} else {
				System.out.println("Invalid input!");
			}
		}
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
