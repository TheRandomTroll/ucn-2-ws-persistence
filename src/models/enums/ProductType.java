package models.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProductType {
	CLOTHING, EQUIPMENT, GUN_REPLICA;

	public static Optional<ProductType> valueOf(int value) {
		return Arrays.stream(values()).filter(x -> x.getValue() == value).findFirst();
	}

	public int getValue() {
		return ordinal() + 1;
	}
}
