import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Problem4 {

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
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        FastReader inputText = new FastReader();
        Random rand = new Random();
        String inputEquation = inputText.nextLine();
        String[] equationElements = inputEquation.split("[+=]");
        int indexOfElements = 0;
        int indexOfStrings = 0;
        int exponent = 0;
        BigInteger Two = new BigInteger("2");
        BigInteger Zero = new BigInteger("0");
        BigInteger leftHandSide = new BigInteger("0");
        BigInteger rightHandSide = new BigInteger(equationElements[equationElements.length - 1]);
        BigInteger max = rightHandSide;
        BigInteger min = new BigInteger("0");
        BigInteger maxPlusMin = max.add(min);
        BigInteger valueOfX = maxPlusMin.divide(Two);
        BigInteger CurrentvalueOfX = valueOfX;

        while(leftHandSide != rightHandSide){
            indexOfElements = 0;
            while(indexOfElements < equationElements.length){
                String currentElement = equationElements[indexOfElements];
                if(currentElement.indexOf('x') == 0 && currentElement.length() == 1){
                    CurrentvalueOfX = valueOfX;
                    leftHandSide = leftHandSide.add(CurrentvalueOfX);
                }
                if(currentElement.indexOf('x') < 0 && indexOfElements < (equationElements.length - 1)){
                    BigInteger constantValue = new BigInteger(currentElement);
                    leftHandSide = leftHandSide.add(constantValue);
                }
                if(currentElement.indexOf('x') == 0 &&currentElement.length() > 1){
                    exponent = currentElement.charAt(2) - '0';
                    CurrentvalueOfX = valueOfX.pow(exponent);
                    leftHandSide = leftHandSide.add(CurrentvalueOfX);
                }
                indexOfElements++;
            }
            if(leftHandSide.compareTo(rightHandSide) == 0){
               System.out.println(valueOfX);
                break;
            }else{
                if(leftHandSide.compareTo(rightHandSide) > 0){
                    max = valueOfX;
                }
                if(leftHandSide.compareTo(rightHandSide) < 0){
                    min = valueOfX;
                }
                maxPlusMin = max.add(min);
                valueOfX = maxPlusMin.divide(Two);
                leftHandSide = Zero;
            }
        }

    }
}
