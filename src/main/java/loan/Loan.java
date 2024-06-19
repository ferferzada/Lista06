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

    protected ArrayList<Installment> installmentArrayList;

    public Loan(String customer, Double value, Integer installments, Double instalmentRate) {
        this.customer = customer;
        this.value = value;
        this.installments = installments;
        for(int i= 0; i < installments;i++){
            installmentArrayList.add(new Installment(value));
        }
        this.instalmentRate = instalmentRate;
    }

    public abstract Double getTotalLoan();



    public Installment getInstallment(Integer installment){
        return installmentArrayList.get(installment);
    }


    public abstract Double getTotalLoan(boolean delayed, Integer days);

    public void setInstallmentsLate(Integer numberInstallment){
        installmentArrayList.get(numberInstallment).setLate(true);
    }
}
