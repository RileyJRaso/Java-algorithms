import java.io.*;
import java.util.*;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Problem7 {
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

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        FastReader inputText = new FastReader();
        int amountOfApplications = inputText.nextInt();
        int amountReviewing = inputText.nextInt();
        int amountOfPrints = amountOfApplications - amountReviewing + 1;
        int[] Applications = new int[amountOfApplications];
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int BestApplication;
        int SecondApplication;
        int Sum;

        for(int i = 0; i < amountOfApplications; i++){
            Applications[i] = inputText.nextInt();
        }

        TreeSet<Integer> searchTree = new TreeSet<Integer>();
        int FirstCelling = (10 ^ 8) + 1;

        for(int i = 0; i < amountReviewing; i++){
            searchTree.add(Applications[i]);
        }



        for(int i = 0; i < amountOfPrints; i++){
            BestApplication = searchTree.pollLast();
            SecondApplication = searchTree.pollLast();
            searchTree.add(BestApplication);
            searchTree.add(SecondApplication);

            Sum = BestApplication + SecondApplication;
            out.write(String.valueOf(Sum) + " ");

            searchTree.remove(Applications[i]);
            if(i < amountOfPrints - 1){
            searchTree.add(Applications[amountReviewing + i]);
            }
        }
    out.flush();
    }
}
