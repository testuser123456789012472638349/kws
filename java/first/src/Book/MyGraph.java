package Book;

public class MyGraph {
    private double a, b, c, d;

    public MyGraph(double aa, double bb, double cc, double dd) {
        a = aa;
        b = bb;
        c = cc;
        d = dd;
    }
    public double f(double xx) {
        double x = xx;
        double y = a * x * x * x + b * x * x + c * x + d;
        return y;
    }
}
