import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.util.ArrayList;
     
public class HelloWorld{
 
    private static int n;
    private static int[] as;
    
     public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int t =  Integer.parseInt(scan.nextLine());
        
        for(int f = 0; f < t; f++){
            n = Integer.parseInt(scan.nextLine());
            as = new int[n];
            String[] tokens = scan.nextLine().split(" ");
            for(int i = 0; i < n; i++){
                as[i] = Integer.parseInt(tokens[i]);
            }
        }
    }
}