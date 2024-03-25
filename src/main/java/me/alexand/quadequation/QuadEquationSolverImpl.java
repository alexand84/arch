package me.alexand.quadequation;

public class QuadEquationSolverImpl implements QuadEquationSolver {

    @Override
    public double[] solve(double a, double b, double c) {
        double d = b * b - 4 * a * c;

        if (d < 0) {
            return new double[]{};
        } else if (d > 0) {
            double[] roots = new double[2];
            double sqrt = Math.sqrt(d);
            roots[0] = (-b - sqrt) / 2 * a;
            roots[1] = (-b + sqrt) / 2 * a;
            return roots;
        }

        throw new UnsupportedOperationException();
    }

}