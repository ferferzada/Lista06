package loan;

import java.util.ArrayList;

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

    protected ArrayList<Installment> installmentArrayList = new ArrayList<>(); ;

    public Loan(String customer, Double value, Integer installments, Double instalmentRate) {
        this.customer = customer;
        this.value = value;
        this.installments = installments;
        for(int i= 0; i < installments;i++){
            Installment installmentNew = new Installment(value);
            installmentArrayList.add(installmentNew);
        }
        this.instalmentRate = instalmentRate;
    }




    public Installment getInstallment(Integer installment){
        return installmentArrayList.get(installment-1);
    }


    public abstract Double getTotalLoan();

    public void setInstallmentsLate(Integer numberInstallment, Boolean late, int days){
        if (numberInstallment > 0 && numberInstallment <= installmentArrayList.size()) {
            Installment actualInstallment = installmentArrayList.get(numberInstallment - 1);
            actualInstallment.setLate(true);
            actualInstallment.setDays(days);
        } else {
            throw new IllegalArgumentException("Invalid installment number: " + numberInstallment);
        }
    }
}
