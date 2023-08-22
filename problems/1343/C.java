import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.util.ArrayList;
     
public class HelloWorld{
 
     public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int t =  Integer.parseInt(scan.nextLine());
        
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(scan.nextLine());
            String[] tokens = scan.nextLine().split(" ");
            int[] a = new int[tokens.length];
            for(int f = 0; f < a.length; f++){
                a[f] = Integer.parseInt(tokens[f]);
            }
            
            
            
            long sum = 0;
            int f = 0;
            while(f < a.length) { // in gruppen trennen
                if(a[f] > 0){ //positive gruppe
                    int max = a[f];
                    do {
                        f++;
                        if(f >= n) break;
                        if(a[f] < 0) break;
                        if (a[f] > max) max = a[f];
                    }while (a[f] > 0);
           //         System.out.print("    ADD: " + max);
                    sum += max;
                }else if (a[f] < 0) { //negative gruppe
                    int min = a[f];
                    do {
                        f++;
                        if(f >= n) break;
                        if(a[f] > 0) break;
                        if (a[f] > min) min = a[f];
                    }while(a[f] < 0);
             //       System.out.print("    ADD:" + min);
                    sum += min;
                }
                
            }
            
            System.out.println(sum);
            
        }
        
    }
}