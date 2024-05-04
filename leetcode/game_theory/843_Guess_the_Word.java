/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
// https://leetcode.com/problems/guess-the-word/

// 아래 문제는 정답을 통과할 수도 있고 통과하지 못할 수도 있음
// 랜덤하게 뽑은 단어와 매칭되는 숫자가 같은 단어를 새로운 후보군으로 만들어서 기존 배열을 줄여나감
// 그렇게 기존 배열을 좁히다 보면, 어쩌면 운이 좋게 10번 이내에 원하는 단어를 찾을 수도 있음 <- 운이 나쁘면 못 찾음^_^
class Solution {
    public void findSecretWord(String[] words, Master master) {
        Random random = new Random();
        for (int i = 0, matches = 0; i < 10 && matches != 6; i++) {
            String guess = words[random.nextInt(words.length)];
            matches = master.guess(guess);
            List<String> candidates = new ArrayList<>();

            for (String word: words) {
                if (matches == getMatches(guess, word)) {
                    candidates.add(word);
                }
            }
            words = candidates.toArray(new String[0]);
        }
    }

    private int getMatches(String word1, String word2) {
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}