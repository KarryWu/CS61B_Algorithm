import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        boolean driver;

        driver = Palindrome.isPalindrome("");
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome(" ");
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome("abaa");
        assertEquals(false, driver);

        driver = Palindrome.isPalindrome("aba");
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome("abba");
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome("abc");
        assertEquals(false, driver);
    }

    @Test
    public void testnewIsPalindrome() {
        boolean driver;

        driver = Palindrome.isPalindrome("", new OffByOne());
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome(" ",new OffByOne());
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome("abccb",new OffByOne());
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome("axyyb",new OffByOne());
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome("axyxa",new OffByOne());
        assertEquals(false, driver);

        driver = Palindrome.isPalindrome("addddcccb",new OffByOne());
        assertEquals(true, driver);
    }

    @Test
    public void testnewIsPalindromeN() {
        boolean driver;

        driver = Palindrome.isPalindrome("", new OffByN(5));
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome(" ",new OffByN(5));
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome("abcgf",new OffByN(5));
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome("axysf",new OffByN(5));
        assertEquals(true, driver);

        driver = Palindrome.isPalindrome("axyxa",new OffByN(5));
        assertEquals(false, driver);

        driver = Palindrome.isPalindrome("addddiiif",new OffByN(5));
        assertEquals(true, driver);
    }
}
