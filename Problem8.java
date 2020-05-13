import java.io.*;
import java.util.*;

public class Problem8 {
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

    static class Cell {
        int xDimension;
        int yDimension;
        public int Value;

        public Cell(int yDimensionGiven, int xDimensionGiven,char Symbol){
            xDimension = xDimensionGiven;
            yDimension = yDimensionGiven;
            if(Symbol == '-'){
                Value = 0;
            }
            if(Symbol == 'S'){
                Value = 1;
            }
            if(Symbol == 'K'){
                Value = 2;
            }
            if(Symbol == 'x'){
                Value = -1;
            }
        }


    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        FastReader inputText = new FastReader();
        int dimension = inputText.nextInt();
        int currentX = 0;
        int nextX = 0;
        int currentY = 0;
        int nextY = 0;
        int xStart = 0;
        int xend = 0;
        int yStart = 0;
        int yend = 0;
        Cell[][] BattleField = new Cell[dimension][dimension];
        int[][] Distance = new int[dimension][dimension];
        boolean[][] Visted = new boolean[dimension][dimension];


        for(int j =0; j < dimension; j++){
            String Line = inputText.next();
            for(int i =0; i < dimension; i++){
                char Symbol = Line.charAt(i);
                BattleField[j][i] = new Cell(j,i,Symbol);
                if(Symbol == 'S'){
                    xStart = i;
                    yStart = j;
                }
                if(Symbol == 'K'){
                    xend = i;
                    yend = j;
                }
                Distance[j][i] = -1;
                Visted[j][i] = false;
            }
        }


        ArrayList[][] AdjList = new ArrayList[dimension][dimension];
        for(int j =0; j < dimension; j++){
            for(int i =0; i < dimension; i++){
                    ArrayList<Cell> innerArray = new ArrayList<>();
                    AdjList[j][i] = innerArray;
                if( (j + 1) < dimension ){
                    AdjList[j][i].add(BattleField[j+1][i]);
                }
                if(j - 1 >= 0){
                    AdjList[j][i].add(BattleField[j-1][i]);
                }
                if(i + 1 < dimension){
                    AdjList[j][i].add(BattleField[j][i+1]);
                }
                if(i - 1 >= 0){
                    AdjList[j][i].add(BattleField[j][i-1]);
                }
            }
        }

        Distance[yStart][xStart] = 0;
        Visted[yStart][xStart] = true;

        Queue<Cell> myQueue = new ArrayDeque<>();

        myQueue.add(BattleField[yStart][xStart]);
            while(!myQueue.isEmpty()){
                Cell Current = myQueue.poll();
                currentX = Current.xDimension;
                currentY = Current.yDimension;
                ArrayList<Cell> innerAdjList = AdjList[currentY][currentX];
                for(int i = 0; i < innerAdjList.size(); i++){
                    Cell next = innerAdjList.get(i);
                    nextX = next.xDimension;
                    nextY = next.yDimension;
                    if(Visted[nextY][nextX] == false && next.Value >= 0){
                        Distance[nextY][nextX] = Distance[currentY][currentX] + 1;
                        Visted[nextY][nextX] = true;
                        myQueue.add(next);
                    }
                }
            }

        if(Distance[yend][xend] == -1){
            System.out.print("IMPOSSIBLE");
        }else{
            System.out.print(Distance[yend][xend]);
        }

        }
    }
