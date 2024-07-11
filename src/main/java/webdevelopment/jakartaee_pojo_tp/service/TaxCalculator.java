package webdevelopment.jakartaee_pojo_tp.service;

import webdevelopment.jakartaee_pojo_tp.model.TaxAuthority;
import webdevelopment.jakartaee_pojo_tp.model.TaxBracket;
import webdevelopment.jakartaee_pojo_tp.persistance.ITaxBracketDAO;

import java.util.List;

public class TaxCalculator {

    // DAO call
    private ITaxBracketDAO daoTax;

    // dependency injection
    public TaxCalculator(ITaxBracketDAO dao){this.daoTax =dao;}


    /*public double calculateTax(String taxAuthority, double income) {
        TaxAuthority authority = this.daoTax.getTaxAuthorityByLabel(taxAuthority);
        double taxFreeThreshold = authority.getTaxFreeThreshold();
        if (taxFreeThreshold >= income){
            return 0.0;
        }
        List<TaxBracket> taxBracketList = this.daoTax.getTaxBracketsByAuthorityId(authority.getId());
        //double taxableIncome = income - taxFreeThreshold;
        double taxOwed = 0.0;
        double maxIncomeInBracket = 0.0;
        double incomeInBracket = 0.0;
        for (TaxBracket item : taxBracketList){
            if (income > item.getMinIncome()) {
                //find maxIncomeInBracket
                if (item.getMaxIncome() != 0.0){
                    maxIncomeInBracket = item.getMaxIncome();
                }else {
                    maxIncomeInBracket = income;
                }
            }// end if
            incomeInBracket = maxIncomeInBracket - item.getMinIncome();
            taxOwed += incomeInBracket * (item.getTaxRate()/100);
        }
        return taxOwed;
    }*/

    public double calculateTax(String taxAuthority, double income) {
        TaxAuthority authority = this.daoTax.getTaxAuthorityByLabel(taxAuthority);
        double taxFreeThreshold = authority.getTaxFreeThreshold();
        if (taxFreeThreshold >= income) {
            return 0.0;
        }

        double taxableIncome = income; //- taxFreeThreshold;
        List<TaxBracket> taxBracketList = this.daoTax.getTaxBracketsByAuthorityId(authority.getId());
        double taxOwed = 0.0;

        for (TaxBracket item : taxBracketList) {
            if (taxableIncome > item.getMinIncome()) {
                double maxIncomeInBracket = (item.getMaxIncome() != 0.0) ? Math.min(taxableIncome, item.getMaxIncome()) : taxableIncome;
                double incomeInBracket = maxIncomeInBracket - item.getMinIncome();
                taxOwed += incomeInBracket * (item.getTaxRate() / 100);
            }
        }
        return taxOwed;
    }
}
