import java.util.*;

public class PalindromeCheckerApp {

    // Method 1: Two-pointer (String)
    public static boolean checkUsingString(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method 2: Stack
    public static boolean checkUsingStack(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Method 3: Deque
    public static boolean checkUsingDeque(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        // Measure String method
        long start1 = System.nanoTime();
        boolean result1 = checkUsingString(processed);
        long end1 = System.nanoTime();

        // Measure Stack method
        long start2 = System.nanoTime();
        boolean result2 = checkUsingStack(processed);
        long end2 = System.nanoTime();

        // Measure Deque method
        long start3 = System.nanoTime();
        boolean result3 = checkUsingDeque(processed);
        long end3 = System.nanoTime();

        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("String Method: " + result1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Stack Method: " + result2 + " | Time: " + (end2 - start2) + " ns");
        System.out.println("Deque Method: " + result3 + " | Time: " + (end3 - start3) + " ns");

        scanner.close();
    }
}