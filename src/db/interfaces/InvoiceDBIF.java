package db.interfaces;

import models.Invoice;
import models.SaleOrder;

public interface InvoiceDBIF {
	Invoice addInvoice(SaleOrder order);
}
