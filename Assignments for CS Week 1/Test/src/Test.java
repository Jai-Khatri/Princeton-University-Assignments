public class Test {
    public static void Q4(int n)
    {
        if (n <= 0) return;
        System.out.println(n);
        Q4(n-2);
        Q4(n-3);
        System.out.println(n);
    }
}
