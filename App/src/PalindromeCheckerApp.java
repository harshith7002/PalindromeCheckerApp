import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Given string
        String word = "madam";

        // Create a stack
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        // Pop characters and build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        // Check palindrome condition
        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}