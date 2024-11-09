import java.util.Arrays;

public class Matrix {
    double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public void printMatrix() {
        System.out.println("============================================");
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                System.out.print(matrix[y][x] + " ");
            }
            System.out.println(" | " + matrix[y][matrix.length]);
        }
        System.out.println("============================================");
    }

    public int getWorkerLine(int y, int x) {
        int i = 0;
        while (true) {
            if (matrix[0][x] != 0 && y != i) {
                return i;
            } else i++;
        }
    }

    private double[] getAnswersFromStairs() {
        double x = 0, y = 0, z;
        z = matrix[2][3] / matrix[2][2];
        System.out.println("y = " + matrix[1][3] + " - " + matrix[1][2] * z);
        y = (matrix[1][3] - matrix[1][2] * z);
        x = (matrix[0][3] - matrix[0][2] * z - matrix[0][1] * y);


        return new double[]{x, y, z};
    }

    public void resolve3x3Matrix() {
        solveForOne(0, 0, 1);
        printMatrix();
        solveForZero(1, 0, 0);
        printMatrix();
        solveForOne(1, 1, 0);
        printMatrix();
        solveForZero(2, 0, 0);
        printMatrix();
        solveForZero(2, 1, 1);
        printMatrix();
        System.out.println(Arrays.toString(getAnswersFromStairs()));
    }

    public void solveForOne(int y, int x, int workerLine) {
        System.out.println("(1 - " + matrix[y][x] + ") / -" + matrix[y][x]);
        double factor = (1 - matrix[y][x]) / -matrix[workerLine][x];
        for (int number = 0; number <= matrix.length; number++) {
            matrix[y][number] -= matrix[workerLine][number] * factor;
        }
    }

    private void solveForZero(int y, int x, int workerLine) {
        // find common factor between the number currently worked on and another number in the matrix
        System.out.println(matrix[y][x] + " / " + matrix[workerLine][x]);
        double factor = matrix[y][x] / matrix[workerLine][x];
        // subtract every number of the line being worked on by the working line
        for (int number = 0; number <= matrix.length; number++) {
            matrix[y][number] -= matrix[workerLine][number] * factor;
        }
    }

    public boolean isResolved() {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (!lineIsResolved(y)) return false;
            }
        }
        return true;
    }

    public boolean lineIsResolved(int line) {
        for (int x = 0; x < matrix[0].length; x++) {
            if ((x == line && matrix[x][line] != 1) || (x != line && matrix[x][line] != 0)) return false;
        }
        return true;
    }
}
