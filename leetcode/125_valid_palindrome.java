import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isDigit(c)) {
                sb.append(c);
            }
        }

        String original = sb.toString();
        String reversed = sb.reverse().toString();

        return original.equals(reversed);
    }
}