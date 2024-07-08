package webdevelopment.jakartaee_pojo_tp.view;

import webdevelopment.jakartaee_pojo_tp.persistance.ITaxBracketDAO;
import webdevelopment.jakartaee_pojo_tp.persistance.TaxBracketDAO;
import webdevelopment.jakartaee_pojo_tp.service.TaxCalculator;

public class UI_Tax {
    public TaxCalculator taxCalculator;

    public UI_Tax(){
        ITaxBracketDAO dao_tax = new TaxBracketDAO();
        this.taxCalculator = new TaxCalculator(dao_tax);
    } // end of constructor

    private double displayTaxToPay(String taxAuthority, double income) {
        return 5.5;
    }
    public static void main(String[] args) {
        UI_Tax tax = new UI_Tax();
        String taxAuthority = "canada";
        double income = 54000;
        double taxToPay = tax.displayTaxToPay(taxAuthority, income);
        System.out.println(taxToPay);
    }

}
