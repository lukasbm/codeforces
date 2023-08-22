import java.util.*;
import java.lang.Math;
import java.util.ArrayList;
     
public class HelloWorld{
    
     public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int t =  Integer.parseInt(scan.nextLine());
        
        for(int f = 0; f < t; f++){
            String[] tokens = scan.nextLine().split(" ");
            int n = Integer.parseInt(tokens[0]); //string length
            int a = Integer.parseInt(tokens[1]); //substring länge
            int b = Integer.parseInt(tokens[2]); //distinct letters per substring, 1 <= b <= min(26,a)

            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            String usealph = alphabet.substring(0, b);
            StringBuilder str = new StringBuilder(n);
            for(int i = 0, g = 0; i < n; i++, g = (g+1)% usealph.length() ){
                str.append(usealph.charAt(g));
            }

            System.out.println(str.toString());       
            
        }
    }
}