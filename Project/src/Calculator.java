public class Calculator {

    static double[][] augmenter(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            return null;

        double[][] augmented = new double[matrix.length][matrix.length * 2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                augmented[i][j] = matrix[i][j];
            augmented[i][i + matrix.length] = 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix.length*2; j++)
              System.out.print(augmented[i][j]);
        }
        return augmented;
    }


}
