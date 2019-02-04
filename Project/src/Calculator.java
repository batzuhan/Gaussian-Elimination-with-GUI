public class Calculator {
    static final double EPS = 0.00000001;

    static double[][] augmenter(double[][] matrix) {
        double[][] augmented = new double[matrix.length][matrix.length * 2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                augmented[i][j] = matrix[i][j];
            augmented[i][i + matrix.length] = 1;
        }
        solve(augmented);
        double[][] inv = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                inv[i][j] = augmented[i][j + matrix.length];
        return inv;
    }

    static void solve(double[][] augmentedMatrix) {
        int rows = augmentedMatrix.length, cols = augmentedMatrix[0].length, lead = 0;
        for (int r = 0; r < rows; r++) {
            if (lead >= cols) break;
            int i = r;
            while (Math.abs(augmentedMatrix[i][lead]) < EPS) {
                if (++i == rows) {
                    i = r;
                    if (++lead == cols) return;
                }
            }
            double[] temp = augmentedMatrix[r];
            augmentedMatrix[r] = augmentedMatrix[i];
            augmentedMatrix[i] = temp;
            double lv = augmentedMatrix[r][lead];
            for (int j = 0; j < cols; j++) augmentedMatrix[r][j] /= lv;
            for (i = 0; i < rows; i++) {
                if (i != r) {
                    lv = augmentedMatrix[i][lead];
                    for (int j = 0; j < cols; j++) augmentedMatrix[i][j] -= lv * augmentedMatrix[r][j];
                }
            }
            lead++;
        }
    }
}
