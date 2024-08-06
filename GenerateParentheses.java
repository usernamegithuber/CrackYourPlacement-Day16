package CrackYourPlacementDay16;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    // Helper function to perform the backtracking
    private void solve(int open, int close, String op, List<String> res) {
        // If no more parentheses left to add, add the current combination to the result
        if (open == 0 && close == 0) {
            res.add(op);
            return;
        }

        // If there are open parentheses left, add one and recurse
        if (open > 0) {
            solve(open - 1, close, op + "(", res);
        }

        // If there are more close parentheses left than open, add one and recurse
        if (close > open) {
            solve(open, close - 1, op + ")", res);
        }
    }

    // Main function to generate the parentheses
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(n, n, "", res);
        return res;
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        int n = 3; // Example input
        List<String> result = gp.generateParenthesis(n);
        System.out.println(result);
    }
}
