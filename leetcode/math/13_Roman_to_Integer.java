// https://leetcode.com/problems/roman-to-integer
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>(){{
            put('I', 1); put('V', 5); put('X', 10); put('L', 50); put('C', 100); put('D', 500); put('M', 1000);
        }};

        int answer = 0;
        int last = 1000;
        
        for (int i = 0; i < s.length(); i++) {
            int v = m.get(s.charAt(i));
            if (v > last) answer = answer - last * 2;
            answer += v;
            last = v;
        }
        return answer;
    }
}