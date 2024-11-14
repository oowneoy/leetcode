import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger aDecimalValue = getDecimalValueFromBinaryString(a);
        BigInteger bDecimalValue = getDecimalValueFromBinaryString(b);

        BigInteger cDecimalValue = aDecimalValue.add(bDecimalValue);
        if(BigInteger.ZERO.equals(cDecimalValue)) return "0";
        Stack<BigInteger> stack = new Stack<>();
        while (!BigInteger.ZERO.equals(cDecimalValue.divide(BigInteger.TWO))) {
            stack.push(cDecimalValue.mod(BigInteger.TWO));
            cDecimalValue = cDecimalValue.divide(BigInteger.TWO);
        }
        if(BigInteger.ONE.equals(cDecimalValue)) {
            stack.push(BigInteger.ONE);
        }

        String result = String.valueOf(stack.pop());
        while(!stack.isEmpty()) {
            result = result.concat(String.valueOf(stack.pop()));
        }
        return result;
    }

    private BigInteger getDecimalValueFromBinaryString(String binaryString) {
        char[] charArray = binaryString.toCharArray();
        BigInteger value = charArray[charArray.length - 1] == '0' ? BigInteger.ZERO : BigInteger.ONE;
        for(int i = charArray.length - 2; i >= 0; i--) {
            if (charArray[i] == '1') {
                value = value.add(BigInteger.TWO.pow(charArray.length - 1 - i));
            }
        }
        return value;
    }
}