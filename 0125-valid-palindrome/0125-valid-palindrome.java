class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.trim().toLowerCase().toCharArray();
        if(chars.length == 0) return true;
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : chars) {
            if (Character.isLetterOrDigit(character)) {
                stringBuilder.append(character);
            }
        }

        int length = stringBuilder.length();
        int mid = length / 2;
        String target;
        if (length % 2 == 0) {
            target = stringBuilder.substring(0, mid);
        } else {
            target = stringBuilder.substring(0, mid + 1);
        }

        String value = new StringBuilder(stringBuilder.substring(mid, length)).reverse().toString();
        return target.equals(value);
    }
}