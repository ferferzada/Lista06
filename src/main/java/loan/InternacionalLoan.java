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


    @Override
    public Double valueInstallment(boolean delayed, Integer days) {
        var total = super.valueInstallment(delayed, days);
        return total += (value * exchangeRate) + (value * transactionFee);
    }

    @Override
    public Double valueInstallment() {
        return super.valueInstallment() + (value * exchangeRate) + (value * transactionFee);
    }

    @Override
    public Double getTotalLoan() {
        return getInstallments() * valueInstallment();
    }

    @Override
    public Double getTotalLoan(boolean delayed, Integer days) {
        return getInstallments() * valueInstallment(delayed,days);
    }
}
