class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (!isLetter(l)) {
                left++;
            } else if (!isLetter(r)) {
                right--;
            } else if (toLowerCase(l) == (toLowerCase(r))) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isLetter(char c) {
        return Character.isLetterOrDigit(c);
    }

    private char toLowerCase(char c) {
       return Character.toLowerCase(c);
    }
}