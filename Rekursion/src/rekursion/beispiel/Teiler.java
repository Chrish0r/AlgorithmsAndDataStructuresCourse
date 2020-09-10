package rekursion.beispiel;

import java.util.Random;

public class Teiler {

    public static int ggT(int a, int b){
        while(b != 0){
            if(a > b){
                a = a - b;
            }else{
                b = b - a;
            }
        }
        return a;
    }

    public static int r_ggT(int a, int b){
        if(a == b){
            return a;
        }else{
            if(a > b){
                return (r_ggT(a-b,b));
            }else{
                return (r_ggT(b-a,a));
            }
        }
    }

    public static int kgV(int a, int b){
        int kgV = ((a*b)/ggT(a,b));
        return kgV;
    }

    public static void main (String[] args){

        Random r = new Random();

        System.out.printf("%d\n", ggT(40,30));
        System.out.printf("%d\n", r_ggT(3430,2320));
        System.out.printf("%d\n", kgV(20,30));

        int[] a = {30,31,32,33,34,35,36,37,38,39,40};
        int[] b = {30,31,32,33,34,35,36,37,38,39,40};

        System.out.println("------------------------------------------------------------------");

        for(int i = 0; i < a.length; i++){
            System.out.printf("%d\n", ggT(a[r.nextInt(11)],b[r.nextInt(11)]));
        }

        System.out.println("------------------------------------------------------------------");

        for(int i = 0; i < a.length; i++){
            System.out.printf("%d\n", kgV(a[r.nextInt(11)],b[r.nextInt(11)]));
        }

        System.out.println("------------------------------------------------------------------");

        for(int i = 0; i < a.length; i++){
            System.out.printf("%d\n", a[r.nextInt(11)]*b[r.nextInt(11)]);
        }
    }

}
