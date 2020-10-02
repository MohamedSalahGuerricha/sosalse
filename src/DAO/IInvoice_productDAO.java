package DAO;

import Model.Invoice_product;

import java.util.List;

public interface IInvoice_productDAO {
    List<Invoice_product> getAllInvoice_product();
    Invoice_product getInvoice_productById(int id);
    void saveInvoice_product(Invoice_product invoice_product);
    void updateInvoice_product(Invoice_product invoice_product,int id);
    void deleteInvoice_product(int id, Boolean reorder);
}
