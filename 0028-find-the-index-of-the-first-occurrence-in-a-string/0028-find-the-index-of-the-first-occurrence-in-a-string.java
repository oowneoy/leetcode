class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 1 && needle.length() == 1 && haystack.equals(needle)) {
            return 0;
        }

        int length = needle.length();
        for (int i = length; i <= haystack.length(); i++) {
            if (haystack.substring(i - length, i).equals(needle)) {
                return i - length;
            }

        }
        return -1;
    }
}