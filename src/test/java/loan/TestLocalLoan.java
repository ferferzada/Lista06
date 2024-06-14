package loan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class TestLocalLoan {

    @Test
    @DisplayName("MARSELÃO SENDO VENDIDO COM IMPOSTO CERTO")
    public void getCorrectValueLoan(){
        LocalLoan Local =  new LocalLoan(
                "Ruan",30D,3,0.05D,0.13D
        );

    }

}
