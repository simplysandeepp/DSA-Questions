import java.util.Stack;
import java.util.Arrays;

class Solution {
    public String simplifyPath(String s) {
        Stack<String> stack = new Stack<>();
        String[] components = s.split("/");
        
        for (String component : components) {
            if (component.equals(".") || component.isEmpty()) {
                continue;
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }
        
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder ans = new StringBuilder();
        for (String dir : stack) {
            ans.append("/").append(dir);
        }
        
        return ans.toString();
    }
}