import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.util.ArrayList;
     
public class HelloWorld{
 
    private static int n;
    private static int[] as;
    
     public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        int a = Integer.parseInt(tokens[2]);
        
        
        long cN = 0;
        long cM = 0;
        
        int mN = (int)((double)n / (double)a);
        int mM = (int)((double)m / (double)a);
        //System.out.println("mN:" + mN + " mM:" + mM);
        n -= mN * a;
        cN += mN;
        m -= mM * a;
        cM += mM;
        
        while (n > 0){
            cN++;
            n -= a;
        }
        while( m > 0){
            cM++;
            m -= a;
        }
        long result = cN * cM;
        System.out.println(result);
    }
}