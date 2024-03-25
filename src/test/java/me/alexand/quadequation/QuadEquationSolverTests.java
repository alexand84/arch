package me.alexand.quadequation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QuadEquationSolverTests {

    private final QuadEquationSolver solver = new QuadEquationSolverImpl();

    @Test
    void shouldNotHaveRoots() {
        double a = 1.0, b = 0, c = 1.0;
        double[] roots = solver.solve(a, b, c);
        assertThat(roots).isEmpty();
    }

    @Test
    void shouldHaveTwoRoots() {
        double a = 1.0, b = 0, c = -1.0;
        double[] roots = solver.solve(a, b, c);
        assertThat(roots).hasSize(2)
                .contains(1.0, -1.0);
    }

    @Test
    void shouldHaveOneRoot() {
        double a = 1, b = 1.0000001, c = 0.25;
        double[] roots = solver.solve(a, b, c);
        assertThat(roots).hasSize(1)
                .contains(-0.50000005);
    }

    @Test
    void shouldFailDueToAEqZero() {
        assertThatThrownBy(() -> solver.solve(0, 1.0, 1.0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> solver.solve(1e-7, 1.0, 1.0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldFailDueToArgumentsNotNumbers() {
        assertThatThrownBy(() -> solver.solve(Double.NaN, 1.0, 1.0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> solver.solve(Double.POSITIVE_INFINITY, 1.0, 1.0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> solver.solve(Double.NEGATIVE_INFINITY, 1.0, 1.0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> solver.solve(1.0, Double.NaN, 1.0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> solver.solve(1.0, Double.POSITIVE_INFINITY, 1.0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> solver.solve(1.0, Double.NEGATIVE_INFINITY, 1.0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> solver.solve(1.0, 1.0, Double.NaN))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> solver.solve(1.0, 1.0, Double.POSITIVE_INFINITY))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> solver.solve(1.0, 1.0, Double.NEGATIVE_INFINITY))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
