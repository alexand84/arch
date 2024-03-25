package me.alexand.quadequation;

public class QuadEquationSolverImpl implements QuadEquationSolver {

    private final double eps;

    public QuadEquationSolverImpl() {
        this(1e-5);
    }

    public QuadEquationSolverImpl(double eps) {
        this.eps = eps;
    }

    @Override
    public double[] solve(double a, double b, double c) {
        checkArgs(a, b, c);
        double d = b * b - 4 * a * c;

        if (d < 0) {
            return new double[]{};
        } else if (d > 0) {
            double sqrt = Math.sqrt(d);
            return new double[]{(-b - sqrt) / 2 * a, (-b + sqrt) / 2 * a};
        }

        return new double[]{-b / 2 * a};
    }

    private void checkArgs(double a, double b, double c) {
        if (isNotNum(a)) {
            throw new IllegalArgumentException("a is not number");
        }
        if (isNotNum(b)) {
            throw new IllegalArgumentException("b is not number");
        }
        if (isNotNum(c)) {
            throw new IllegalArgumentException("c is not number");
        }
        if (Math.abs(a) < eps) {
            throw new IllegalArgumentException("a is zero");
        }
    }

    private boolean isNotNum(double num) {
        return Double.isNaN(num) || Double.isInfinite(num);
    }

}
