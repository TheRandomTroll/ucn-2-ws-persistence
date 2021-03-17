package db.interfaces;

import models.Invoice;
import models.SaleOrder;

public interface InvoiceDBIF {
	public Invoice addInvoice(SaleOrder order);
}
