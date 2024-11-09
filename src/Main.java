public class Main {
    public static void main(String[] args) {
        double[][] resolved = new double[][]{{1, -3, 4, 4}, {2, -5, 6, 1}, {-3, 3, 4, 1}};
        Matrix matrix = new Matrix(resolved);
        matrix.printMatrix();
        matrix.resolve3x3Matrix();
    }
}
