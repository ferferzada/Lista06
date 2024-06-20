package loan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TesteIntercionalLoan {
    @Test
    @DisplayName("Should return correct total loan when no installments are late")
    public void totalLoanWithNoLateInstallmentsInternational() {
        var loan = new InternacionalLoan("John Doe", 1000D, 10, 0.1, 0.05, 0.2);
        assertEquals(12500D, loan.getTotalLoan());
    }

    @Test
    @DisplayName("Should return correct total loan when some installments are late")
    public void totalLoanWithSomeLateInstallmentsInternational() {
        var loan = new InternacionalLoan("John Doe", 1000D, 10, 0.1, 0.05, 0.2);
        loan.setInstallmentsLate(1, true, 10);
        assertNotEquals(1000D, loan.getTotalLoan());
    }

    @Test
    @DisplayName("Should return correct installment value when requested by index")
    public void valueInstallmentByIndex() {
        var loan = new InternacionalLoan("John Doe", 1000D, 10, 0.1, 0.05, 0.2);
        assertNotNull(loan.valueInstallment(1));
    }

    @Test
    @DisplayName("Should throw exception when requested installment index is out of bounds")
    public void valueInstallmentByOutOfBoundsIndex() {
        var loan = new InternacionalLoan("John Doe", 1000D, 10, 0.1, 0.05, 0.2);
        assertThrows(IndexOutOfBoundsException.class, () -> loan.valueInstallment(11));
    }

    @Test
    @DisplayName("Should correctly set installment as late")
    public void setInstallmentAsLateInternational() {
        var loan = new InternacionalLoan("John Doe", 1000D, 10, 0.1, 0.05, 0.2);
        loan.setInstallmentsLate(1, true, 10);
        assertTrue(loan.getInstallment(1).getLate());
    }

    @Test
    @DisplayName("Should correctly set number of days for late installment")
    public void setDaysForLateInstallmentInternational() {
        var loan = new InternacionalLoan("John Doe", 1000D, 10, 0.1, 0.05, 0.2);
        loan.setInstallmentsLate(1, true, 10);
        assertEquals(10, loan.getInstallment(1).getDays());
    }
}