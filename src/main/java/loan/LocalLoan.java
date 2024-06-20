package loan;

import java.util.ArrayList;

public class LocalLoan extends Loan {
    private Double inflationRate;


    public LocalLoan(String customer, Double value, Integer installments, Double instalmentRate, Double inflationRate) {
        super(customer, value, installments, instalmentRate);
        this.inflationRate = inflationRate;
    }

    public Double valueInstallment(Integer numberInstallment) {
        var actualInstallment = super.getInstallment(numberInstallment);
        if(actualInstallment.getLate()){
            return (actualInstallment.getValue() * (actualInstallment.getDays()* (actualInstallment.getValue() * instalmentRate )) );
        }
        return (actualInstallment.getValue());

    }

    @Override
    public Double getTotalLoan() {
        Double total = 0D;
        for (int i = 0; i < installmentArrayList.size();i++){
            total += valueInstallment(i);
        }
        return total;

    }

}
