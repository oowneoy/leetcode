class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x; // 0과 1은 제곱근이 자기 자신
        
        int left = 1, right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}