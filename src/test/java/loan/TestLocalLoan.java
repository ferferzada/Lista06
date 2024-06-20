package loan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class TestLocalLoan {

    @Test
    @DisplayName("Should return correct installment value when not delayed")
    public void installmentValueWhenNotDelayed() {
        var loan = new LocalLoan("John Doe", 1000D, 10, 0.1, 0.05);
        assertEquals(1000D, loan.valueInstallment(false, null));
    }

    @Test
    @DisplayName("Should return correct total loan when not delayed")
    public void totalLoanWhenNotDelayed() {
        var loan = new LocalLoan("John Doe", 1000D, 10, 0.1, 0.05);
        assertEquals(10000D, loan.getTotalLoan());
    }

    @Test
    @DisplayName("Should return correct total loan when delayed")
    public void totalLoanWhenDelayed() {
        var loan = new LocalLoan("John Doe", 1000D, 10, 0.1, 0.05);
        assertEquals(10000D, loan.getTotalLoan());
    }

}
