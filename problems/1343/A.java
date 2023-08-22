

    import java.util.Scanner;
    import java.util.Arrays;
    
import java.lang.Math;  
     
    public class HelloWorld{
     
         public static void main(String []args){
            Scanner scan = new Scanner(System.in);
            int t =  Integer.parseInt(scan.nextLine());
            
            
            for(int i = 0; i < t; i++){
                int n = Integer.parseInt(scan.nextLine());
                //int k = 2;
                int mult = 2;
                int sum = 1;
                do{
                    sum += mult;
                    mult *= 2;
                }while(n % sum != 0);
                
               // System.out.print(sum + "  ");
                
                int x = n / sum;
                
                System.out.println(x);
            }
            
        }
    }