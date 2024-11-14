class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }

        int count = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                count++;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }

        if(count == length) {
            digits = new int[length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}