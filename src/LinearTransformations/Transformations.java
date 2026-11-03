package LinearTransformations;

import Matriz.Matrix;
import Matriz.Operations;
import Matriz.Vector;
import Matriz.Vector2D;
import Matriz.Vector3D;

public class Transformations {

    // ==================== TRANSLACAO ====================
 /*
      Translação 2D em coordenadas homogêneas.
        | 1  0  dx |       x' = x + dx
        | 0  1  dy |       y' = y + dy
        | 0  0  1  |
*/
    public Vector2D translate2D(Vector2D vector, double dx, double dy) {
        // Vetor em coordenadas homogêneas: [x, y, 1]
        Vector homogeneous = vector.toHomogeneous();
        // Matriz de translação 3x3 (dx e dy ficam na última coluna)
        float[] translationElements = {
            1f, 0f, (float) dx,
            0f, 1f, (float) dy,
            0f, 0f, 1f
        };

        Matrix translationMatrix = new Matrix(3, 3, translationElements);
        // Multiplica a matriz pelo vetor e volta para 2D
        Vector result = Operations.multiply(translationMatrix, homogeneous);
        return Vector2D.fromHomogeneous(result);
    }
 /*
      Translação 3D em coordenadas homogêneas.
        | 1  0  0  dx |       x' = x + dx
        | 0  1  0  dy |       y' = y + dy
        | 0  0  1  dz |       z' = z + dz
        | 0  0  0  1  |
*/
    public Vector3D translate3D(Vector3D vector, double dx, double dy, double dz) {
        // Vetor em coordenadas homogêneas: [x, y, z, 1]
        Vector homogeneous = vector.toHomogeneous();
        // Matriz de translação 4x4 (dx, dy e dz ficam na última coluna)
        float[] translationElements = {
            1f, 0f, 0f, (float) dx,
            0f, 1f, 0f, (float) dy,
            0f, 0f, 1f, (float) dz,
            0f, 0f, 0f, 1f
        };
        Matrix translationMatrix = new Matrix(4, 4, translationElements);
        // Multiplica a matriz pelo vetor e volta para 3D
        Vector result = Operations.multiply(translationMatrix, homogeneous);
        return Vector3D.fromHomogeneous(result);
    }

    // ==================== ROTACAO ====================
    // Ângulos em GRAUS (converter para radianos internamente se necessário)

    public Vector2D rotation2D(Vector2D vector, double angle) {
        double rad = Math.toRadians(angle);
        float cos = (float) Math.cos(rad);
        float sin = (float) Math.sin(rad);

        Vector homogeneous = vector.toHomogeneous();

        float[] rotationElements = {
            cos, -sin, 0f,
            sin,  cos, 0f,
            0f,   0f,  1f
        };
        Matrix rotationMatrix = new Matrix(3, 3, rotationElements);

        Vector result = Operations.multiply(rotationMatrix, homogeneous);
        return Vector2D.fromHomogeneous(result);
    }

    public Vector3D rotation3DX(Vector3D vector, double angle) {
        double rad = Math.toRadians(angle);
        float cos = (float) Math.cos(rad);
        float sin = (float) Math.sin(rad);

        Vector homogeneous = vector.toHomogeneous();

        float[] rotationElements = {
            1f, 0f,   0f,  0f,
            0f, cos, -sin, 0f,
            0f, sin,  cos, 0f,
            0f, 0f,   0f,  1f
        };
        Matrix rotationMatrix = new Matrix(4, 4, rotationElements);

        Vector result = Operations.multiply(rotationMatrix, homogeneous);
        return Vector3D.fromHomogeneous(result);
    }

    public Vector3D rotation3DY(Vector3D vector, double angle) {
        double rad = Math.toRadians(angle);
        float cos = (float) Math.cos(rad);
        float sin = (float) Math.sin(rad);

        Vector homogeneous = vector.toHomogeneous();

        float[] rotationElements = {
             cos, 0f, sin, 0f,
             0f,  1f, 0f,  0f,
            -sin, 0f, cos, 0f,
             0f,  0f, 0f,  1f
        };
        Matrix rotationMatrix = new Matrix(4, 4, rotationElements);

        Vector result = Operations.multiply(rotationMatrix, homogeneous);
        return Vector3D.fromHomogeneous(result);
    }

    public Vector3D rotation3DZ(Vector3D vector, double angle) {
        double rad = Math.toRadians(angle);
        float cos = (float) Math.cos(rad);
        float sin = (float) Math.sin(rad);

        Vector homogeneous = vector.toHomogeneous();

        float[] rotationElements = {
            cos, -sin, 0f, 0f,
            sin,  cos, 0f, 0f,
            0f,   0f,  1f, 0f,
            0f,   0f,  0f, 1f
        };
        Matrix rotationMatrix = new Matrix(4, 4, rotationElements);

        Vector result = Operations.multiply(rotationMatrix, homogeneous);
        return Vector3D.fromHomogeneous(result);
    }

    // ==================== REFLEXAO ====================

    public Vector2D reflection2DX(Vector2D vector) {
        Vector homogeneous = vector.toHomogeneous();

        float[] elements = {
                1f,  0f, 0f,
                0f, -1f, 0f,
                0f,  0f, 1f
        };
        Matrix reflectionMatrix = new Matrix(3, 3, elements);

        Vector result = Operations.multiply(reflectionMatrix, homogeneous);
        return Vector2D.fromHomogeneous(result);
    }

    public Vector2D reflection2DY(Vector2D vector) {
        Vector homogeneous = vector.toHomogeneous();

        float[] elements = {
                -1f, 0f, 0f,
                0f, 1f, 0f,
                0f, 0f, 1f
        };
        Matrix reflectionMatrix = new Matrix(3, 3, elements);

        Vector result = Operations.multiply(reflectionMatrix, homogeneous);
        return Vector2D.fromHomogeneous(result);
    }

    public Vector3D reflection3DX(Vector3D vector) {
        Vector homogeneous = vector.toHomogeneous();

        float[] elements = {
                -1f, 0f, 0f, 0f,
                0f, 1f, 0f, 0f,
                0f, 0f, 1f, 0f,
                0f, 0f, 0f, 1f
        };
        Matrix reflectionMatrix = new Matrix(4, 4, elements);

        Vector result = Operations.multiply(reflectionMatrix, homogeneous);
        return Vector3D.fromHomogeneous(result);
    }

    public Vector3D reflection3DY(Vector3D vector) {
        Vector homogeneous = vector.toHomogeneous();

        float[] elements = {
                1f,  0f, 0f, 0f,
                0f, -1f, 0f, 0f,
                0f,  0f, 1f, 0f,
                0f,  0f, 0f, 1f
        };
        Matrix reflectionMatrix = new Matrix(4, 4, elements);

        Vector result = Operations.multiply(reflectionMatrix, homogeneous);
        return Vector3D.fromHomogeneous(result);
    }

    public Vector3D reflection3DZ(Vector3D vector) {
        Vector homogeneous = vector.toHomogeneous();

        float[] elements = {
                1f, 0f,  0f, 0f,
                0f, 1f,  0f, 0f,
                0f, 0f, -1f, 0f,
                0f, 0f,  0f, 1f
        };
        Matrix reflectionMatrix = new Matrix(4, 4, elements);

        Vector result = Operations.multiply(reflectionMatrix, homogeneous);
        return Vector3D.fromHomogeneous(result);
    }
    // ==================== PROJECAO ====================

    public Vector2D projection2DX(Vector2D vector) {
        // Projeção no eixo X (y = 0)
    	 Vector homogeneous = vector.toHomogeneous();
        Vector result = Operations.multiply(getProjection2DXMatrix(), homogeneous);
        return Vector2D.fromHomogeneous(result);
    }

    public Vector2D projection2DY(Vector2D vector) {
        // Projeção no eixo Y (x = 0)
    	Vector homogeneous = vector.toHomogeneous();
        Vector result = Operations.multiply(getProjection2DYMatrix(), homogeneous);
        return Vector2D.fromHomogeneous(result);
    }

    public Vector3D projection3DX(Vector3D vector) {
        // Projeção no plano YZ (x = 0)
    	Vector homogeneous = vector.toHomogeneous();
        Vector result = Operations.multiply(getProjection3DXMatrix(), homogeneous);
        return Vector3D.fromHomogeneous(result);
    }

    public Vector3D projection3DY(Vector3D vector) {
        // Projeção no plano XZ (y = 0)
    	Vector homogeneous = vector.toHomogeneous();
        Vector result = Operations.multiply(getProjection3DYMatrix(), homogeneous);
        return Vector3D.fromHomogeneous(result);
    }

    public Vector3D projection3DZ(Vector3D vector) {
        // Projeção no plano XY (z = 0)
    	Vector homogeneous = vector.toHomogeneous();
        Vector result = Operations.multiply(getProjection3DZMatrix(), homogeneous);
        return Vector3D.fromHomogeneous(result);
    }
    
 // ==================== MATRIZES DE PROJEÇÃO 2D ====================

    public Matrix getProjection2DXMatrix() {
        // Matriz 3x3 para projeção 2D no eixo X (y = 0) em coordenadas homogéneas
        float[] elements = {
            1f, 0f, 0f,
            0f, 0f, 0f,
            0f, 0f, 1f
        };
        return new Matrix(3, 3, elements);
    }

    public Matrix getProjection2DYMatrix() {
        // Matriz 3x3 para projeção 2D no eixo Y (x = 0)
        float[] elements = {
            0f, 0f, 0f,
            0f, 1f, 0f,
            0f, 0f, 1f
        };
        return new Matrix(3, 3, elements);
    }
    
 // ==================== MATRIZES DE PROJEÇÃO 3D ====================

    public Matrix getProjection3DXMatrix() {
        // Matriz 4x4 para projeção 3D no plano YZ (x = 0)
        float[] elements = {
            0f, 0f, 0f, 0f,
            0f, 1f, 0f, 0f,
            0f, 0f, 1f, 0f,
            0f, 0f, 0f, 1f
        };
        return new Matrix(4, 4, elements);
    }

    public Matrix getProjection3DYMatrix() {
        // Matriz 4x4 para projeção 3D no plano XZ (y = 0)
        float[] elements = {
            1f, 0f, 0f, 0f,
            0f, 0f, 0f, 0f,
            0f, 0f, 1f, 0f,
            0f, 0f, 0f, 1f
        };
        return new Matrix(4, 4, elements);
    }

    public Matrix getProjection3DZMatrix() {
        // Matriz 4x4 para projeção 3D no plano XY (z = 0)
        float[] elements = {
            1f, 0f, 0f, 0f,
            0f, 1f, 0f, 0f,
            0f, 0f, 0f, 0f,
            0f, 0f, 0f, 1f
        };
        return new Matrix(4, 4, elements);
    }

    // ==================== CISALHAMENTO ====================
    // Implementado (apenas 2D)

    /*
      Cisalhamento 2D em coordenadas homogêneas.
        | 1  kx  0 |       x' = x + kx * y
        | ky  1  0 |       y' = ky * x + y
        | 0   0  1 |
    */
    public Vector2D shearing(Vector2D vector, double kx, double ky) {
        // 1. Vetor em coordenadas homogêneas: [x, y, 1]
        Vector homogeneous = vector.toHomogeneous();

        // 2. Matriz de cisalhamento 3x3
        float[] shearElements = {
            1f,         (float) kx, 0f,
            (float) ky, 1f,         0f,
            0f,         0f,         1f
        };
        Matrix shearMatrix = new Matrix(3, 3, shearElements);

        // 3. Multiplica a matriz pelo vetor e volta para 2D
        Vector result = Operations.multiply(shearMatrix, homogeneous);
        return Vector2D.fromHomogeneous(result);
    }
}
