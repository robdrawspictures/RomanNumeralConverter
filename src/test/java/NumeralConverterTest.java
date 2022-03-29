import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumeralConverterTest {

    private NumeralConverter numeralConverter;

    @Before
    public void before() {
        numeralConverter = new NumeralConverter();
    }

    @Test
    public void canConvertSubTen(){
        assertEquals("VIII", numeralConverter.lessThanTen(8));
        assertEquals("IV", numeralConverter.lessThanTen(4));
        assertEquals("IX", numeralConverter.lessThanTen(9));
    }

    @Test
    public void canReturnZero(){
        assertEquals("", numeralConverter.lessThanTen(0));
    }

    @Test
    public void canConvertSubFifty(){
        assertEquals("XXVII", numeralConverter.lessThanFifty(27));
        assertEquals("XLIX", numeralConverter.lessThanFifty(49));
        assertEquals("XXXVI", numeralConverter.lessThanFifty(36));
        assertEquals("XX", numeralConverter.lessThanFifty(20));
    }

    @Test
    public void canConvertLessThanHundred(){
        assertEquals("LXIX", numeralConverter.lessThanHundred(69));
        assertEquals("XCVI", numeralConverter.lessThanHundred(96));
        assertEquals("LXXXI", numeralConverter.lessThanHundred(81));
        assertEquals("L", numeralConverter.lessThanHundred(50));
    }

    @Test
    public void canConvertHundreds(){
        assertEquals("CDXX", numeralConverter.convertHuns(420));
        assertEquals("CMLXXV", numeralConverter.convertHuns(975));
        assertEquals("CCCLXIX", numeralConverter.convertHuns(369));
        assertEquals("D", numeralConverter.convertHuns(500));
        assertEquals("CMXCIX", numeralConverter.convertHuns(999));
    }

}
