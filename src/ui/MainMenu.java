package ui;

import controllers.OrderController;

import java.util.Scanner;

public class MainMenu {
	private Scanner sc;
	private OrderController orderController;

	public MainMenu() {
		this.sc = new Scanner(System.in);
		this.orderController = new OrderController();
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
	}
}
