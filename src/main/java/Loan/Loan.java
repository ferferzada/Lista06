package Loan;

public abstract class Loan {

    protected String customer;

    protected  Double value;

    protected Integer installments;

    protected Double interestRate;

    public abstract Double getTotalLoan();
}
