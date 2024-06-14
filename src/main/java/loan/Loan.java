package loan;

public abstract class Loan {

    protected String customer;

    protected final Double value;

    protected Integer installments;

    protected final Double instalmentRate;

    public String getCustomer() {
        return customer;
    }

    public Double getValue() {
        return value;
    }

    public Integer getInstallments() {
        return installments;
    }

    public Double getInstalmentRate() {
        return instalmentRate;
    }

    public Loan(String customer, Double value, Integer installments, Double instalmentRate) {
        this.customer = customer;
        this.value = value;
        this.installments = installments;
        this.instalmentRate = instalmentRate;
    }

    public abstract Double getTotalLoan();


    public Double valueInstallment(boolean delayed, Integer days){
        if(delayed){
            return value * (days *(value * instalmentRate));
        }
        return valueInstallment();
    }
    public Double valueInstallment(){
        return value;
    }


    public abstract Double getTotalLoan(boolean delayed, Integer days);
}
