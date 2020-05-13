import java.io.*;
import java.util.*;

public class Problem5 {

    /*This class is taken from geeksforgeeks.org*/
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


    private static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        public int key(int Digit){
            if (Digit == 1){
                return first;
            }
            else{
                return second;
            }
        }
    }

    public static Pair[] inputGenerator(int n){ /* be careful to not modify this function */
        long last = 5000011;
        long mult1 = 5000087;
        long mult2 = 5000167;

        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
            last = (last * mult1 + mult2)%n;
            int x = (int)last;
            last = (last * mult2 + i + mult1)%n;
            int y = (int)last;
            arr[i] = new Pair(x, y);
        }
        return arr;
    }

    static void usefulCountingSort(Pair[] A, int k, int Digit){
        ArrayList< ArrayList<Pair> > C = new ArrayList<>();

        for(int i = 0; i < k; i++)
            C.add(new ArrayList<>());

        for(int i = 0; i < A.length; i++){
            int key;
            if (Digit == 1){
                key = (A[i].key(Digit) + 2 * i) % k;
            }
            else{
                key = (A[i].key(Digit) + i) % k;
            }
            C.get(key).add(A[i]); //takes O(1) time
        }

        int index = 0;
        for(int i = 0; i < k; i++)
            for(int j = 0; j < C.get(i).size(); j++)
                A[index++] = C.get(i).get(j);
    }

    public static void main(String[] args) {
        FastReader inputText = new FastReader();
        int amountOfPairs = inputText.nextInt();
        Pair[] inputArray = inputGenerator(amountOfPairs);
        int multiples = inputText.nextInt();
        int i = 0;
        usefulCountingSort(inputArray,amountOfPairs,2);
        usefulCountingSort(inputArray,amountOfPairs,1);
        while(i < inputArray.length){
            if(i % multiples == 0){
                System.out.print("(" + inputArray[i].first + "," + inputArray[i].second + ")" + "\n");
            }
            i++;
        }
    }



}
