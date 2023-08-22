

    import java.util.Scanner;
    import java.util.Arrays;
    
import java.lang.Math;  
     
    public class HelloWorld{
     
         public static void main(String []args){
            Scanner scan = new Scanner(System.in);
            int t =  Integer.parseInt(scan.nextLine());
            
            for(int i = 0; i < t; i++){
                int n = Integer.parseInt(scan.nextLine()); // n >= 2, n GERADE
                int[] a = new int[n];
                int sumL = 0;
                int sumR = 0;
                for(int f = 0; f < n; f++){
                    if(f < n/2) {
                        a[f] = 2*f +2;
                        sumL += 2*f+2;
                    } else {
                        a[f] = 2*(f-n/2)+1;
                        sumR += 2*(f-n/2)+1;
                    }
                }
                
                if( (sumL - sumR) % 2 == 1) {
                    System.out.println("NO");
                    continue;
                } 
                
            //    for(int as : a) System.out.print(as + " ");
            //    System.out.println("");
              //  System.out.println(sumL + " " + sumR);
                //nachkorrigieren
                int f = n - 1;
                    int fh = (n/2) - 1;
                while(sumL != sumR && fh >= 0){
                    
                    if(sumL < sumR){
                        a[fh] += 2;
                        sumL += 2;
                    } else {
                        a[f] += 2;
                        sumR += 2;   
                    }
                    f--;
                    fh--;
                
                }
                
                
                System.out.println("YES  ");
                for(int as : a) System.out.print(as + " ");
                System.out.println("");
                
                
            }
            
        }
    }