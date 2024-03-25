package me.alexand.quadequation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuadEquationSolverTests {

    private final QuadEquationSolver solver = new QuadEquationSolverImpl();

    @Test
    void shouldNotHaveRoots() {
        double a = 1.0, b = 0, c = 1.0;
        double[] roots = solver.solve(a, b, c);
        assertThat(roots).isEmpty();
    }

}
