import java.io.*;
import java.util.*;
import java.util.HashMap;

public class Problem6 {
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
        FastReader inputText = new FastReader();
        int size = inputText.nextInt();
        String[] names = new String[size];
        for(int i = 0; i < size; i++){
            names[i] = inputText.next();
        }
        String[] uniqueNames = new String[size];
        String currentName = " ";
        String popularName = " ";
        int oldValue = 0;
        int j = 0;
        int max = -1;

        HashMap<String, Integer> hash = new HashMap<>((size/2));

        for(int i = 0; i < size; i++){
            if(hash.containsKey(names[i])){
                oldValue = hash.get(names[i]);
                hash.replace(names[i],oldValue,oldValue + 1);
            }
            else{
                hash.put(names[i],1);
                uniqueNames[j] = names[i];
                j++;
            }
        }

        for(int i = 0; i < j;i++){
            currentName = uniqueNames[i];
            if(hash.get(currentName) > max){
                popularName = currentName;
                max = hash.get(currentName);
            }
            if(hash.get(currentName) == max){
                if(popularName.compareTo(currentName) > 0){
                    popularName = currentName;
                }
            }
        }

        System.out.println(popularName + " " + max);
    }
}
