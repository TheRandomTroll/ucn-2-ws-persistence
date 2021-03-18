package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.interfaces.ProductDBIF;
import models.ClothingProduct;
import models.EquipmentProduct;
import models.GunReplicaProduct;
import models.Product;
import models.enums.ProductType;

public class ProductDB implements ProductDBIF {

	private static final String GET_PRODUCTS_Q = "SELECT Id, Barcode, Name, PurchasePrice, SalesPrice, RentPrice, CountryOfOrigin, MinStock, ProductTypeId FROM Products;";
	private static final String GET_CLOTHING_PRODUCTS_Q = "SELECT Size, Colour FROM ClothingProducts WHERE Id = ?;";
	private static final String GET_EQUIPMENT_PRODUCTS_Q = "SELECT Type, Description FROM EquipmentProducts WHERE Id = ?;";
	private static final String GET_GUN_REPLICA_PRODUCTS_Q = "SELECT Calibre, Material FROM GunReplicaProducts WHERE Id = ?;";

	private PreparedStatement getProductsPS;
	private PreparedStatement getClothingProductsPS;
	private PreparedStatement getEquipmentProductsPS;
	private PreparedStatement getGunReplicaProductsPS;

	public ProductDB() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		getProductsPS = con.prepareStatement(GET_PRODUCTS_Q);
		getClothingProductsPS = con.prepareStatement(GET_CLOTHING_PRODUCTS_Q);
		getEquipmentProductsPS = con.prepareStatement(GET_EQUIPMENT_PRODUCTS_Q);
		getGunReplicaProductsPS = con.prepareStatement(GET_GUN_REPLICA_PRODUCTS_Q);
	}

	@Override
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<>();

		try {
			ResultSet rs = getProductsPS.executeQuery();
			products = buildObjects(rs);
		} catch (SQLException e) {
			System.out.println("Unable to fetch customers. Exception: " + e.getMessage());
		}
		return products;
	}

	private List<Product> buildObjects(ResultSet rs) {
		List<Product> products = new ArrayList<>();

		try {
			while (rs.next()) {
				Product p = buildObject(rs);
				products.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Unable to parse customers. Exception: " + e.getMessage());
		}

		return products;
	}

	private Product buildObject(ResultSet rs) {
		try {
			int productTypeId = rs.getInt("ProductTypeId");
			ProductType type = ProductType.valueOf(productTypeId)
					.orElseThrow(() -> new IllegalArgumentException("Invalid product type."));
			if (type == ProductType.CLOTHING) {
				ClothingProduct p = new ClothingProduct();

				int id = rs.getInt("Id");
				p.setId(id);
				p.setBarcode(rs.getInt("Barcode"));
				p.setName(rs.getString("Name"));
				p.setPurchasePrice(rs.getDouble("PurchasePrice"));
				p.setSalesPrice(rs.getDouble("SalesPrice"));
				p.setRentPrice(rs.getDouble("RentPrice"));
				p.setCountryOfOrigin(rs.getString("CountryOfOrigin"));
				p.setMinStock(rs.getInt("MinStock"));
				p.setProductType(type);

				getClothingProductsPS.setInt(1, id);
				ResultSet cprs = getClothingProductsPS.executeQuery();
				if (cprs.next()) {
					p.setSize(cprs.getString("Size"));
					p.setColour(cprs.getString("Colour"));
				}
				return p;
			} else if (type == ProductType.EQUIPMENT) {
				EquipmentProduct p = new EquipmentProduct();

				int id = rs.getInt("Id");
				p.setId(id);
				p.setBarcode(rs.getInt("Barcode"));
				p.setName(rs.getString("Name"));
				p.setPurchasePrice(rs.getDouble("PurchasePrice"));
				p.setSalesPrice(rs.getDouble("SalesPrice"));
				p.setRentPrice(rs.getDouble("RentPrice"));
				p.setCountryOfOrigin(rs.getString("CountryOfOrigin"));
				p.setMinStock(rs.getInt("MinStock"));
				p.setProductType(type);

				getEquipmentProductsPS.setInt(1, id);
				ResultSet eprs = getEquipmentProductsPS.executeQuery();
				if (eprs.next()) {
					p.setType(eprs.getString("Type"));
					p.setDescription(eprs.getString("Description"));
				}
				return p;
			} else if (type == ProductType.GUN_REPLICA) {
				GunReplicaProduct p = new GunReplicaProduct();
				int id = rs.getInt("Id");
				p.setId(id);
				p.setBarcode(rs.getInt("Barcode"));
				p.setName(rs.getString("Name"));
				p.setPurchasePrice(rs.getDouble("PurchasePrice"));
				p.setSalesPrice(rs.getDouble("SalesPrice"));
				p.setRentPrice(rs.getDouble("RentPrice"));
				p.setCountryOfOrigin(rs.getString("CountryOfOrigin"));
				p.setMinStock(rs.getInt("MinStock"));
				p.setProductType(type);

				getGunReplicaProductsPS.setInt(1, id);
				ResultSet grprs = getGunReplicaProductsPS.executeQuery();
				if (grprs.next()) {
					p.setCalibre(grprs.getDouble("Calibre"));
					p.setMaterial(grprs.getString("Material"));
				}
				return p;
			}
		} catch (SQLException e) {
			System.out.println("Unable to parse customer. Exception: " + e.getMessage());
		}
		return null;
	}

}
