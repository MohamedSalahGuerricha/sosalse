package DAO;

import Model.Invoice;

import java.util.List;

public interface IINvoiceDAO {

    List<Model.Invoice> getAllInvoices();
    Model.Invoice getInvoiceById(int id);
    void saveInvoice(Invoice invoice);
    void updateInvoice(Invoice invoice,int id);
    void deleteInvoice(int id,Boolean reorder);


}
