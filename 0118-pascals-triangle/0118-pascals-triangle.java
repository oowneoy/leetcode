class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] memo = new int[numRows][numRows];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int x = i - 1;
                int y = j - 1;
                if (x >= 0 && y >= 0 && j <= result.get(x).size() - 1) {
                    list.add(result.get(x).get(y) + result.get(x).get(j));
                } else {
                    list.add(1);
                }
            }
            result.add(list);
        }

        return result;
    }
}