// https://leetcode.com/problems/group-anagrams/description/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for (String str: strs) {
            String sorted = str.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
            m.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> answer = new ArrayList<>();
        for (String key: m.keySet()) {
            answer.add(m.get(key));
        }

        return answer;
    }
}