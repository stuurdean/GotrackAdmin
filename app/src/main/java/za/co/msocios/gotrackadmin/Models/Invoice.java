package za.co.msocios.gotrackadmin.Models;

public class Invoice {

    private   String Invoicedate,Status,InvoiceAmount;

    public Invoice() {
    }

    public Invoice(String invoicedate, String status, String invoiceAmount) {
        Invoicedate = invoicedate;
        Status = status;
        InvoiceAmount = invoiceAmount;
    }

    public String getInvoicedate() {
        return Invoicedate;
    }

    public void setInvoicedate(String invoicedate) {
        Invoicedate = invoicedate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getInvoiceAmount() {
        return InvoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        InvoiceAmount = invoiceAmount;
    }





}
