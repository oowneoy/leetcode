class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] peek = stack.peek();
                answer[peek[0]] = i - peek[0];
                stack.pop();
            }
            stack.push(new int[]{i, temperatures[i]});
        }

        return answer;
    }
}