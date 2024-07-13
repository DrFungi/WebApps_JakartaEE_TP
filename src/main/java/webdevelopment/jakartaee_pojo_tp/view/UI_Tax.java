package webdevelopment.jakartaee_pojo_tp.view;

import webdevelopment.jakartaee_pojo_tp.persistance.ITaxBracketDAO;
import webdevelopment.jakartaee_pojo_tp.persistance.TaxBracketDAO_JDBC;
import webdevelopment.jakartaee_pojo_tp.service.TaxCalculatorCanada;
import webdevelopment.jakartaee_pojo_tp.service.TaxCalculatorQuebec;


public class UI_Tax {
    public TaxCalculatorCanada taxCalculatorCanada;
    public TaxCalculatorQuebec taxCalculatorQuebec;

    public UI_Tax(){
        ITaxBracketDAO dao_tax = new TaxBracketDAO_JDBC();
        //ITaxBracketDAO dao_tax = new TaxBracketDAO_JPA;  if this implementation exists
        this.taxCalculatorCanada = new TaxCalculatorCanada(dao_tax);
        this.taxCalculatorQuebec = new TaxCalculatorQuebec(dao_tax);
    } // end of constructor

    public double displayTaxToPayCanada(String taxAuthority, double income) {
        return taxCalculatorCanada.calculateTax(taxAuthority, income);
    }
    public double displayTaxToPayQuebec(String taxAuthority, double income) {
        return taxCalculatorQuebec.calculateTax(taxAuthority, income);
    }
    public static void main(String[] args) {
        UI_Tax tax = new UI_Tax();
        String taxAuthorityQ = "Quebec";
        double incomeQ = 25000;
        double taxToPayQ = tax.displayTaxToPayQuebec(taxAuthorityQ, incomeQ);
        String taxAuthorityC = "Canada";
        double incomeC = 25000;
        double taxToPayC = tax.displayTaxToPayCanada(taxAuthorityC, incomeC);
        double taxToPayT = taxToPayC + taxToPayQ;
        System.out.println("the tax to pay quebec is:");
        System.out.println("$ "+taxToPayQ);
        System.out.println("the tax to pay canada is:");
        System.out.println("$ "+taxToPayC);
        System.out.println("the tax to pay combined is:");
        System.out.println("$ " +taxToPayT);
    }

}
