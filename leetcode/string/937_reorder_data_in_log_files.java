// https://leetcode.com/problems/reorder-data-in-log-files/description/
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String[] parts = log.split(" ", 2);
            if (Character.isDigit(parts[1].charAt(0))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        // letter logs sorting
        letterLogs.sort((log1, log2) -> {
            String[] parts1 = log1.split(" ", 2);
            String[] parts2 = log2.split(" ", 2);

            String content1 = parts1[1];
            String content2 = parts2[1];
            int contentCompare = content1.compareTo(content2);
            if (contentCompare != 0) {
                return contentCompare;
            } else {
                return parts1[0].compareTo(parts2[0]);
            }
        });

        // merge 
        List<String> result = new ArrayList<>(letterLogs);
        result.addAll(digitLogs);

        return result.toArray(new String[0]);
    }
}