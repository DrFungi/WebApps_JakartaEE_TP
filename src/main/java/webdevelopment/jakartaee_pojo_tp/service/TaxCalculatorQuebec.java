package webdevelopment.jakartaee_pojo_tp.service;

import webdevelopment.jakartaee_pojo_tp.model.TaxAuthority;
import webdevelopment.jakartaee_pojo_tp.model.TaxBracket;
import webdevelopment.jakartaee_pojo_tp.persistance.ITaxBracketDAO;

import java.util.List;

public class TaxCalculatorQuebec implements ITaxCalculator{
    // DAO call
    private final ITaxBracketDAO daoTax;

    // dependency injection
    public TaxCalculatorQuebec(ITaxBracketDAO dao){this.daoTax =dao;}


    @Override
    public double calculateTax(String taxAuthority, double income) {
        TaxAuthority authority = this.daoTax.getTaxAuthorityByLabel(taxAuthority);
        double taxFreeThreshold = authority.getTaxFreeThreshold();
        if (taxFreeThreshold >= income){
            return 0.0;
        }
        List<TaxBracket> taxBracketList = this.daoTax.getTaxBracketsByAuthorityId(authority.getId());
        double taxOwed = 0.0;
        double maxIncomeInBracket = 0.0;
        double incomeInBracket = 0.0;
        for (TaxBracket item : taxBracketList){
            if (income > item.getMinIncome()) {
                //find maxIncomeInBracket
                if (item.getMaxIncome() != 0.0){
                    if (income < item.getMaxIncome()){
                        maxIncomeInBracket = income;
                    }else {
                        maxIncomeInBracket = item.getMaxIncome();
                    }
                }else {
                    maxIncomeInBracket = income;
                }
                incomeInBracket = maxIncomeInBracket - item.getMinIncome();
                taxOwed += incomeInBracket * (item.getTaxRate()/100);
            }// end if
        }
        return taxOwed;
    }

    /*public double calculateTaxGPT(String taxAuthority, double income) {
        TaxAuthority authority = this.daoTax.getTaxAuthorityByLabel(taxAuthority);
        double taxFreeThreshold = authority.getTaxFreeThreshold();
        if (taxFreeThreshold >= income) {
            return 0.0;
        }

        List<TaxBracket> taxBracketList = this.daoTax.getTaxBracketsByAuthorityId(authority.getId());
        double taxOwed = 0.0;

        for (TaxBracket item : taxBracketList) {
            if (income > item.getMinIncome()) {
                double maxIncomeInBracket = (item.getMaxIncome() != 0.0) ? Math.min(income, item.getMaxIncome()) : income;
                double incomeInBracket = maxIncomeInBracket - item.getMinIncome();
                taxOwed += incomeInBracket * (item.getTaxRate() / 100);
            }
        }
        return taxOwed;
    }*/
}

