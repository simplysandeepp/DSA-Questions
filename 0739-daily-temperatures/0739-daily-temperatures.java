import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n]; 
        Stack<int[]> stack = new Stack<>();
 
        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i];
            

            while (!stack.isEmpty() && stack.peek()[0] < currentTemp) {
                int[] prevDay = stack.pop();
                int prevTemp = prevDay[0];
                int prevIndex = prevDay[1];

                answer[prevIndex] = i - prevIndex;
            }
        
            stack.push(new int[]{currentTemp, i});
        }
        
        return answer;
    }
}