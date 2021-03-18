package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import db.interfaces.OrderDBIF;
import models.Customer;
import models.Product;
import models.SaleOrder;
import models.enums.DeliveryStatus;

public class OrderDB implements OrderDBIF {

	private static final String ADD_ORDER_Q = "INSERT INTO SaleOrders(CustomerId, Date, Amount, DeliveryStatusId, DeliveryDate) VALUES (?, ?, ?, ?, ?)";
	private static final String ADD_ORDER_ITEMS_Q = "INSERT INTO OrderItems(SaleOrderId, ProductId, Quantity) VALUES (?, ?, ?)";
	private PreparedStatement addOrderPS;
	private PreparedStatement addOrderItemsPS;

	public OrderDB() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		addOrderPS = con.prepareStatement(ADD_ORDER_Q, Statement.RETURN_GENERATED_KEYS);
		addOrderItemsPS = con.prepareStatement(ADD_ORDER_ITEMS_Q);
	}

	@Override
	public SaleOrder addOrder(List<Product> products, Customer customer) {
		try {
			SaleOrder order = new SaleOrder();
			Date date = Date.valueOf(LocalDate.now());
			Date deliveryDate = Date.valueOf(LocalDate.now().plusDays(7));
			double amount = 0.0;
			for (Product p : products) {
				amount += p.getSalesPrice();
			}
			DeliveryStatus status = DeliveryStatus.PROCESSING;

			order.setCustomer(customer);
			order.setDate(date);
			order.setAmount(amount);
			order.setDeliveryStatus(status);
			order.setDeliveryDate(deliveryDate);
			order.setProducts(products);

			addOrderPS.setInt(1, customer.getId());
			addOrderPS.setDate(2, date);
			addOrderPS.setDouble(3, amount);
			addOrderPS.setInt(4, status.getValue());
			addOrderPS.setDate(5, deliveryDate);

			addOrderPS.executeUpdate();

			int orderId = 0;

			ResultSet generatedKeys = addOrderPS.getGeneratedKeys();
			if (generatedKeys.next()) {
				orderId = generatedKeys.getInt(1);
			} else {
				throw new SQLException("Could not insert order, no ID obtained.");
			}

			order.setId(orderId);

			Map<Integer, Long> counted = products.stream()
					.collect(Collectors.groupingBy(Product::getId, Collectors.counting()));

			for (Map.Entry<Integer, Long> entry : counted.entrySet()) {
				addOrderItemsPS.setInt(1, orderId);
				addOrderItemsPS.setInt(2, entry.getKey());
				addOrderItemsPS.setInt(3, entry.getValue().intValue());

				addOrderItemsPS.executeUpdate();
			}

			return order;

		} catch (SQLException e) {
			System.out.println("Could not insert order. Exception: " + e.getMessage());
		}

		return null;
	}

}
