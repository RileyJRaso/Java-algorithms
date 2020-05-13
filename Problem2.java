import java.io.*;
import java.util.*;
import java.lang.*;

public class Problem2 {


    public static void main(String[] args) {
        Scanner inputText = new Scanner(System.in);
        long Answer = 0;
        //inputs array size
        int Size = inputText.nextInt();
        int [] ArrayA = new int[Size];
        int [] ArrayB = new int[Size];
        for(int i = 0; i < Size; i++){
            ArrayA[i] = inputText.nextInt();
        }
        for(int i = 0; i < Size; i++){
            ArrayB[i] = inputText.nextInt();
        }
        Answer = recursiveProduct(ArrayA,ArrayB,Size);
        //outputs results
        System.out.println(Answer);
    }

     private static Long recursiveProduct(int[] ArrayA,int[] ArrayB,int Size){

        long SUM = 0;
        if(Size % 2 == 1){
            for(int i = 0; i < Size; i++){
            SUM = SUM + (ArrayA[i] * ArrayB[i]);
            }
        }
        else{
            int[] ArrayA_bot = new int[Size/2];
            for(int i = 0; i < Size/2; i++){
                ArrayA_bot[i] = ArrayA[i];
            }
            int[] ArrayA_top = new int[Size/2];
            for(int i = 0; i < Size/2; i++){
                ArrayA_top[i] = ArrayA[i + Size/2];
            }
            int[] ArrayB_bot = new int[Size/2];
            for(int i = 0; i < Size/2; i++){
                ArrayB_bot[i] = ArrayB[i];
            }
            int[] ArrayB_top = new int[Size/2];
            for(int i = 0; i < Size/2; i++){
                ArrayB_top[i] = ArrayB[i + Size/2];
            }
            SUM = recursiveProduct(ArrayA_bot, ArrayA_top, (Size/2)) + recursiveProduct(ArrayB_bot, ArrayB_top, (Size/2)) + recursiveProduct(ArrayA_top, ArrayB_bot, (Size/2)) + recursiveProduct(ArrayB_top, ArrayA_bot, (Size/2));
        }

        return SUM;
    }
}
