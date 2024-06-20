package loan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    public class TestInternacionalLoan {

        @Test
        @DisplayName("Should return correct installment value when not delayed")
        public void installmentValueWhenNotDelayed() {
            var loan = new InternacionalLoan("John Doe", 1000D, 10, 0.1, 0.05, 0.2);
            assertEquals(1500D, loan.valueInstallment(false, null));
        }

        @Test
        @DisplayName("Should return correct installment value when delayed")
        public void installmentValueWhenDelayed() {
            var loan = new InternacionalLoan("John Doe", 1000D, 10, 0.1, 0.05, 0.2);
            assertNotEquals(1000D, loan.valueInstallment(true, 10));
        }

        @Test
        @DisplayName("Should return correct total loan when not delayed")
        public void totalLoanWhenNotDelayed() {
            var loan = new InternacionalLoan("John Doe", 1000D, 10, 0.1, 0.05, 0.2);
            assertEquals(12500D, loan.getTotalLoan());
        }

        @Test
        @DisplayName("Should return correct total loan when delayed")
        public void totalLoanWhenDelayed() {
            var loan = new InternacionalLoan("John Doe", 1000D, 10, 0.1, 0.05, 0.2);
            assertNotEquals(10000D, loan.getTotalLoan(true, 10));
        }
    }


