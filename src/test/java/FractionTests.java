import com.realdolmen.Fraction;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assume.assumeTrue;


@RunWith(Theories.class)
public class FractionTests {

    @Theory
    public void multyplyingNegativeFractionWithPositiveFractionReturnsNegativeFraction(Fraction a, Fraction b) {
        assumeTrue(a.getTeller() < 0);


    }
}
