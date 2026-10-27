package Matriz;

/*
	Classe utilitária contendo as operações matemáticas sobre Matrizes e Vetores.
*/
public class Operations {

    /*
      Realiza a transposição de uma matriz (inverte linhas por colunas).
    */
    public static Matrix transpose(Matrix matrix) {
        float[] resultElements = new float[matrix.getRows() * matrix.getCols()];
        // A matriz transposta troca a quantidade de linhas pelas de colunas
        Matrix result = new Matrix(matrix.getCols(), matrix.getRows(), resultElements);

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                // O elemento na posição (i, j) vai para a posição (j, i) na transposta
                result.set(j, i, matrix.get(i, j));
            }
        }
        return result;
    }

    /*
      Realiza a transposição de um vetor (retorna uma cópia do vetor original).
    */
    public static Vector transpose(Vector vector) {
        float[] resultElements = new float[vector.getDim()];
        for (int i = 0; i < vector.getDim(); i++) {
            resultElements[i] = vector.get(i);
        }
        return new Vector(vector.getDim(), resultElements);
    }

    /*
      Realiza a soma de duas matrizes (elemento a elemento).
    */
    public static Matrix add(Matrix a, Matrix b) {
        // Validação de dimensões compatíveis para a soma
        if (a.getRows() != b.getRows() || a.getCols() != b.getCols()) {
            throw new IllegalArgumentException("Matrizes precisam ter a mesma dimensão para a soma.");
        }

        float[] resultElements = new float[a.getRows() * a.getCols()];
        Matrix result = new Matrix(a.getRows(), a.getCols(), resultElements);

        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getCols(); j++) {
                result.set(i, j, a.get(i, j) + b.get(i, j));
            }
        }
        return result;
    }

    /*
      Realiza a soma de dois vetores (elemento a elemento).
    */
    public static Vector add(Vector a, Vector b) {
        // Validação de dimensão compatível para a soma
        if (a.getDim() != b.getDim()) {
            throw new IllegalArgumentException("Vetores precisam ter a mesma dimensão para a soma.");
        }

        float[] resultElements = new float[a.getDim()];
        for (int i = 0; i < a.getDim(); i++) {
            resultElements[i] = a.get(i) + b.get(i);
        }
        return new Vector(a.getDim(), resultElements);
    }


    /*
      Multiplica uma matriz (m x n) por um vetor coluna de dimensão n.
      O resultado é um vetor de dimensão m.
    */
    public static Vector multiply(Matrix matrix, Vector vector) {
        // Validação: colunas da matriz precisam ser iguais à dimensão do vetor
        if (matrix.getCols() != vector.getDim()) {
            throw new IllegalArgumentException(
                "O número de colunas da matriz deve ser igual à dimensão do vetor.");
        }

        float[] resultElements = new float[matrix.getRows()];
        for (int i = 0; i < matrix.getRows(); i++) {
            float sum = 0;
            for (int j = 0; j < matrix.getCols(); j++) {
                sum += matrix.get(i, j) * vector.get(j);
            }
            resultElements[i] = sum;
        }
        return new Vector(matrix.getRows(), resultElements);
    }
}
