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

// 걍 냅다 쓰는 코드가 성능은 가장 잘 나왔다는,, 
class Solution {
    public static int romanToInt(String s) {
        int res = 0;
        char[] let = s.toCharArray();
        for(int i = 0; i < let.length; i++) { //IV
            switch (let[i]) {
                case 'I':
                    if (i + 1 < let.length) {
                        if (let[i + 1] == 'V') {
                            res += 4;
                            i++;
                            break;
                        } else if (let[i + 1] == 'X') {
                            res += 9;
                            i++;
                            break;
                        }
                        res++;
                        break;
                    }
                    res++;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    if (i + 1 < let.length) {
                        if (let[i + 1] == 'L') {
                            res += 40;
                            i++;
                            break;
                        } else if (let[i + 1] == 'C') {
                            res += 90;
                            i++;
                            break;
                        }
                        res += 10;
                        break;
                    }
                    res += 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    if (i + 1 < let.length) {
                        if (let[i + 1] == 'D') {
                            res += 400;
                            i++;
                            break;
                        } else if (let[i + 1] == 'M') {
                            res += 900;
                            i++;
                            break;
                        }
                        res += 100;
                        break;
                    }
                    res += 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }

        return res;
    }
}