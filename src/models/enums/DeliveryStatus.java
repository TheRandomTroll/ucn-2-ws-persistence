package models.enums;

public enum DeliveryStatus {
	PROCESSING, PROCESSED, DISPATCHED, DELIVERED;

	public int getValue() {
		return ordinal() + 1;
	}
}
