public class Main {
    public static int fibonacii(int n){
        if(n<2) return 1;
        else if (n>=2) return (fibonacii(n-1))+ fibonacii(n-2);
        else return -1;
    }

    public static int factorial(int n){
        if(n==1) return 1;
        else if(n>1) return n * factorial(n-1);
        else return -1;
    }

    public static void main(String[] args) {
        System.out.print(factorial(10));

    }
}