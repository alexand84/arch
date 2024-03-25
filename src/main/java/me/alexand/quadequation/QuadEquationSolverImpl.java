package me.alexand.quadequation;

public class QuadEquationSolverImpl implements QuadEquationSolver {

    @Override
    public double[] solve(double a, double b, double c) {
        double d = Math.sqrt(b) - 4 * a * c;
        if (d < 0) {
            return new double[]{};
        }

        throw new UnsupportedOperationException();
    }

}
