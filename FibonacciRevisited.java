import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 
 */
public class FibonacciRevisited {


    /**
     * Generate fibonacci number.
     * Recursive call.
     * Simple code but very ineficient.
     * Try it with n = 50
     * 
     * Time: O(2^n) - Space: O(n)
     */
    static int fib0(int n) {

        // **** base case ****
        if (n <= 2)
            return 1;

        // **** recursion ****
        return fib0(n - 2) + fib0(n - 1);
    }


    /**
     * Generate fibonacci number.
     * Entry call.
     */
    static int fib(int n) {

        // **** sanity check(s) ****
        if (n <= 2)
            return 1;

        // **** initialization ****
        int[] callCounter   = new int[] {0};
        int[] memo          = new int[n];
        memo[0] = memo[1]   = 1;

        // **** start recursion ****
        fib(n, memo, callCounter);

        // ???? ????
        // System.out.println("fib <<< callCounter: " + callCounter[0]);
        // System.out.println("fib <<< memo: " + Arrays.toString(memo));

        // **** return answer ****
        return memo[n - 1];
    }


    /**
     * Generate fibonacci number.
     * Recursive call with memoization.
     * 
    * Time: O(n) - Space: O(n)
     */
    static int fib(int n, int[] memo, int[] callCounter) {

        // ???? ????
        callCounter[0] += 1;

        // **** base case(s) ****
        if (n <= 1)
            return 1;

        // **** generate this value (if needed) ****
        if (memo[n - 1] == 0)
            memo[n - 1] = fib(n - 1, memo, callCounter);

        // **** generate this value (if needed) ****
        if (memo[n - 2] == 0)
            memo[n - 2] = fib(n - 2, memo, callCounter);

        // **** return result  ****
        return memo[n - 1] + memo[n - 2];
    }


    /**
     * Test scaffold
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read n ****
        int n = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< n: " + n);

        // **** generate and display Fibonacci number(s) ****
        for (int i = 1; i <= n; i++)
            System.out.println("main <<< i: " + i + " fib0: " + fib0(i));

        // ???? ????
        System.out.println();

        // **** generate and display Fibonacci number(s) ****
        for (int i = 1; i <= n; i++)
            System.out.println("main <<< i: " + i + " fib: " + fib(i));
    }
}