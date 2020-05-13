import java.io.*;
import java.util.*;

public class Problem3 {

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
           return Long.parseLong(next());
        }

        double nextDouble() {
          return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
               e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        FastReader inputText = new FastReader();
        int size = inputText.nextInt();
        long result = 1;
        int currentNumber = 0;
        int tempHoldingValue = 0;

        //inputs the values
        int[] inputNumbers = new int[size];
        for(int i = 0; i < size; i++){
            inputNumbers[i] = inputText.nextInt();
        }

        while(currentNumber < size){
            if(currentNumber == 0){
                maxPq.add(inputNumbers[currentNumber]);
            }
            else if(currentNumber == 1 && inputNumbers[currentNumber] >= maxPq.peek()){
                minPq.add(inputNumbers[currentNumber]);
            }
            else if(currentNumber == 1 && inputNumbers[currentNumber] < maxPq.peek()){
                maxPq.add(inputNumbers[currentNumber]);
                minPq.add(maxPq.poll());
            }
            else if(currentNumber % 2 == 0 && inputNumbers[currentNumber] > minPq.peek()){
                minPq.add(inputNumbers[currentNumber]);
                maxPq.add(minPq.poll());
            }
            else if(currentNumber % 2 == 0){
                maxPq.add(inputNumbers[currentNumber]);
            }
            else if(inputNumbers[currentNumber] < maxPq.peek()){
                maxPq.add(inputNumbers[currentNumber]);
                minPq.add(maxPq.poll());
            }
            else if(inputNumbers[currentNumber] > maxPq.peek()){
                minPq.add(inputNumbers[currentNumber]);
            }

            tempHoldingValue = maxPq.peek();
            result = result * tempHoldingValue;
            result = result % 1000000007;
            currentNumber++;
        }

        System.out.println(result);

    }
}
