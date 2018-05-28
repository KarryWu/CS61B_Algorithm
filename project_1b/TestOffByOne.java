import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void Test(){
        boolean driver;
        driver = offByOne.equalChars('a','b');
        assertEquals(true, driver);

        driver = offByOne.equalChars('a','c');
        assertEquals(false, driver);

        driver = offByOne.equalChars('x','w');
        assertEquals(true, driver);

        driver = offByOne.equalChars('w','k');
        assertEquals(false, driver);
    }
}
