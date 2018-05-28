public class Palindrome {
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> dlist = new ArrayDeque<>();

        for(char ch : word.toCharArray()) {
            dlist.addLast(ch);
        }

        return dlist;
    }


    public static boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    public static boolean isPalindrome(Deque<Character> dlist) {
        if (dlist.size() == 0 || dlist.size() == 1) {
            return true;
        }

        char first = dlist.removeFirst();
        char last = dlist.removeLast();

        return (first == last) && isPalindrome(dlist);
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word),cc);
    }

    public static boolean isPalindrome(Deque<Character> dlist, CharacterComparator cc) {
        if (dlist.size() == 0 || dlist.size() == 1) {
            return true;
        }

        char first = dlist.removeFirst();
        char last = dlist.removeLast();

        return cc.equalChars(first, last) && isPalindrome(dlist, cc);
    }
}

