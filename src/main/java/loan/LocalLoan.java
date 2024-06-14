package loan;

public class LocalLoan extends Loan {
    private Double inflationRate;

    public LocalLoan(String customer, Double value, Integer installments, Double instalmentRate, Double inflationRate) {
        super(customer, value, installments, instalmentRate);
        this.inflationRate = inflationRate;
    }

    public Double valueInstallment(boolean delayed, Integer days) {
        if (delayed) {
            return super.valueInstallment(delayed, days) + (value * instalmentRate);
        }
        return super.valueInstallment();
    }

    public Double valueInstallment() {
        return super.valueInstallment();
    }

    @Override
    public Double getTotalLoan() {
        return getTotalLoan(false, null);
    }

    @Override
    public Double getTotalLoan(boolean delayed, Integer days) {
        return getInstallments() * valueInstallment(delayed, days);

    }
}
