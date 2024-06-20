package loan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLocalLoan {
    @Test
    @DisplayName("Should return correct total loan when no installments are late")
    public void totalLoanWithNoLateInstallments() {
        var loan = new LocalLoan("Carlos", 10000D, 1, 0.05, 0.05);
        assertEquals(10000D, loan.getTotalLoan());
    }

    @Test
    @DisplayName("Should return correct total loan when some installments are late")
    public void totalLoanWithSomeLateInstallments() {
        var loan = new LocalLoan("Carlos", 10000D, 1, 0.05, 0.05);
        loan.setInstallmentsLate(1, true, 10);
        assertNotEquals(1000D, loan.getTotalLoan());
    }

    @Test
    @DisplayName("Should return correct installment when requested by index")
    public void getInstallmentByIndex() {
        var loan = new LocalLoan("John Doe", 1000D, 10, 0.1, 0.05);
        assertNotNull(loan.getInstallment(1));
    }


    @Test
    @DisplayName("Should correctly set installment as late")
    public void setInstallmentAsLate() {
        var loan = new LocalLoan("John Doe", 1000D, 10, 0.1, 0.05);
        loan.setInstallmentsLate(1, true, 10);
        assertTrue(loan.getInstallment(1).getLate());
    }

    @Test
    @DisplayName("Should correctly set number of days for late installment")
    public void setDaysForLateInstallment() {
        var loan = new LocalLoan("John Doe", 1000D, 10, 0.1, 0.05);
        loan.setInstallmentsLate(1, true, 10);
        assertEquals(10, loan.getInstallment(1).getDays());
    }
    


}
