import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.util.ArrayList;
     
public class HelloWorld{
 
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int t =  Integer.parseInt(scan.nextLine());
        for(int f = 0; f < t; f++){
            String in = scan.nextLine();
            if (in.matches("R\\d+C\\d+") ) {
                Scanner sc1 = new Scanner(in.substring(1)).useDelimiter("C");
                int R = sc1.nextInt();
                int C = sc1.nextInt();
          //      System.out.println("R:" + R + "  C:" + C);
                
                String Cstring = Integer.toString(26, 26); //0-9 + a-p
                System.out.println("cstring: " + Cstring);
                StringBuilder str = new StringBuilder(Cstring.length());
                for(int i = 0; i < Cstring.length(); i++) {
                    char c = Cstring.charAt(i);
                    if (c >= '0' && c <= '9') {
                        str.append ( (char)(c + 17) );
                    } else if (c >= 'a' && c <= 'p'){
                        str.append ( (char)(c - 23) );
                    }
                }
                
                System.out.println(str.toString() + " " +  R);
                
            } else if(in.matches("[A-Z]+\\d+")) {
                String col = new StringBuilder(in).reverse().toString().replaceAll("[^A-Z]", "");
                
                int row = Integer.parseInt(in.replaceAll("\\D",""));
                int colint = 0;
                for(int i = 0; i < col.length(); i++) {
                    colint += pow(26, i) * ((int)col.charAt(i) - 64); 
                }
                //System.out.println("col: " + col + "  colint: "  + colint + "  row: " + row);
                System.out.println("R" + row + "C" + colint);
            }else{
                System.out.println("fail");
            }
        }
        
    }
    
    private static int pow(int base, int power){
        int erg = 1;
        while (power > 0) {
            power--;
            erg *= base;
        }
        return erg;
    }
    
}