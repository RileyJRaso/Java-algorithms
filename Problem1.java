import java.io.*;
import java.util.*;
import java.lang.*;

public class Problem1 {

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

    public static void main(String[] args) {
        FastReader inputText = new FastReader();
        int size = inputText.nextInt();
        int limit = inputText.nextInt();
        int count = 0;


        int[] guestList = new int[size];
        for(int i = 0; i < size; i++){
            guestList[i] = inputText.nextInt();
        }

        Arrays.sort(guestList);

        for(int i = 0; i< size; i++){
            int currentGuest = guestList[i];
            int j = i + 1;
            while(j < size && Math.abs(currentGuest - guestList[j]) <= limit){
                count++;
                j = j + 1;
            }
            j = i;
            while(j >= 0 && Math.abs(currentGuest - guestList[j]) <= limit){
                count++;
                j = j - 1;
            }
        }

        System.out.println(count);

    }
}
