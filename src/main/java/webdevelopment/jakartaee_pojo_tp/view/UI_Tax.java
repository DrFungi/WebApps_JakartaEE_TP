package webdevelopment.jakartaee_pojo_tp.view;

import webdevelopment.jakartaee_pojo_tp.persistance.ITaxBracketDAO;
import webdevelopment.jakartaee_pojo_tp.persistance.TaxBracketDAO_JDBC;
import webdevelopment.jakartaee_pojo_tp.service.TaxCalculator;

public class UI_Tax {
    public TaxCalculator taxCalculator;

    public UI_Tax(){
        ITaxBracketDAO dao_tax = new TaxBracketDAO_JDBC();
        //ITaxBracketDAO dao_tax = new TaxBracketDAO_JPA;  if this implementation exists
        this.taxCalculator = new TaxCalculator(dao_tax);
    } // end of constructor

    private double displayTaxToPay(String taxAuthority, double income) {
        return taxCalculator.calculateTax(taxAuthority, income);
    }
    public static void main(String[] args) {
        UI_Tax tax = new UI_Tax();
        String taxAuthorityQ = "Quebec";
        double incomeQ = 22000;
        double taxToPayQ = tax.displayTaxToPay(taxAuthorityQ, incomeQ);
        String taxAuthorityC = "Canada";
        double incomeC = 22000;
        double taxToPayC = tax.displayTaxToPay(taxAuthorityC, incomeC);
        double taxToPayT = taxToPayC + taxToPayQ;
        System.out.println("the tax to pay quebec is:");
        System.out.println("$ "+taxToPayQ);
        System.out.println("the tax to pay canada is:");
        System.out.println("$ "+taxToPayC);
        System.out.println("the tax to pay combined is:");
        System.out.println("$ " +taxToPayT);
    }

}
