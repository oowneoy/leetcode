import java.math.BigInteger;

class Solution {
    public int uniquePaths(int m, int n) {
        BigInteger result = BigInteger.ONE;
        int moveCount = m + n - 2;
        for (int i = 0; i < m - 1; i++) {
            result = result.multiply(BigInteger.valueOf(moveCount - i)).divide(BigInteger.valueOf(i + 1));
        }

        return result.intValue();
    }
}