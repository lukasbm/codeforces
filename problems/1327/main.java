

    import java.util.Scanner;
    import java.util.Arrays;
     
    public class HelloWorld{
     
         public static void main(String []args){
            Scanner scan = new Scanner(System.in);
            int c =  Integer.parseInt(scan.nextLine());
            
            for(int i = 0; i < c; i++){
                String[] tokens = scan.nextLine().split(" ");
                int n = Integer.parseInt(tokens[0]);
                int k = Integer.parseInt(tokens[1]);
                
                if(k * k > n){ //1+3+5+... k mal ist zu groß
                    System.out.println("NO");
                    continue;
                }
                if(n % 2 == 0 && k % 2 == 1){ //n gerade, k ungerade
                    System.out.println("NO");
                    continue;
                }
                if(n % 2 == 1 && k % 2 == 0){ //n ungerade, k gerade
                    System.out.println("NO");
                    continue;
                }
                if( (n - k*k) % 2 == 1){ //wenn der rest ungerade ist
                    System.out.println("NO");
                    continue;
                }
                System.out.println("YES");
            }
        }
    }