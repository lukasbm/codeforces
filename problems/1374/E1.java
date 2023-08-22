import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.util.ArrayList;
    
public class E1{
 
    private static int[] as;
    
     public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
        
        int[][] books = new int[n][3];

        for(int f = 0; f < n; f++){
            as = new int[3];
            tokens = scan.nextLine().split(" ");
            for(int i = 0; i < n; i++){
                as[i] = Integer.parseInt(tokens[i]);
            }
            books[f] = as;
        }

        int[] bestboth = new int[k];
        int[] bestalice = new int[k];
        int[] bestbob = new int[k];


        for (int i = 0; i < n; i++){
            int t = books[i][0];
            int a = books[i][1];
            int b = books[i][2];
        }
    }
}