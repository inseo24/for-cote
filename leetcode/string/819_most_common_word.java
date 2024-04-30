import java.util.*;

// https://leetcode.com/problems/most-common-word/description/
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> freq = new HashMap<>();
        String[] p = paragraph.split(" ");

        for (int i = 0; i < p.length; i++) {
            String replacedStr = p[i].replaceAll("[!?',;.]", " ");
            p[i] = replacedStr;
        }

        String joined = String.join(" ", p);
        
        for (String word: joined.split(" ")) {
            StringBuilder sb = new StringBuilder();
            for (char c: word.toCharArray()) {
                if (Character.isLetter(c)) {
                    sb.append(Character.toLowerCase(c));
                }
            }
            String s = sb.toString();
            if (s.length() > 0) {
                freq.put(s, freq.getOrDefault(s, 0) + 1);
            }
        }

        String answer = "";
        int max = 0;
        List<String> ban = Arrays.asList(banned);
        for (String key: freq.keySet()) {
            if (!ban.contains(key) && max < freq.get(key)) {
                answer = key;
                max = freq.get(key);
            }
        }

        return answer;
    }
}