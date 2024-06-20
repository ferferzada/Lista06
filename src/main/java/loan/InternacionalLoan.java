package loan;

public class InternacionalLoan  extends Loan{

    private Double exchangeRate;
    private Double transactionFee;

    public InternacionalLoan(String customer,
                             Double value,
                             Integer installments,
                             Double instalmentRate,
                             Double exchangeRate,
                             Double transactionFee) {
        super(customer, value, installments, instalmentRate);
        this.exchangeRate = exchangeRate;
        this.transactionFee = transactionFee;
    }

    public Double valueInstallment(Integer Installment) {
        Installment actualInstallment =  installmentArrayList.get(Installment -1);
        var total = actualInstallment.getValue();
        if(actualInstallment.getLate()){
            total +=  (actualInstallment.getValue() * (actualInstallment.getDays()* (actualInstallment.getValue() * instalmentRate )) );

        }
        return total += (actualInstallment.getValue() * exchangeRate) + (actualInstallment.getValue() * transactionFee);
    }



    @Override
    public Double getTotalLoan() {
        var total = 0D;
        for (int i = 0; i < installmentArrayList.size() -1; i++) {
            total += valueInstallment(i);
        }
        return total;
    }

}
