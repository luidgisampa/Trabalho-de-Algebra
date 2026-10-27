package LinearTransformations;

import Matriz.Matrix;
import Matriz.Operations;
import Matriz.Vector;
import Matriz.Vector2D;
import Matriz.Vector3D;

public class Transformations {

    // ==================== TRANSLACAO ====================
    // TODO: Colega responsável pela Translação

    public Vector2D translate2D(Vector2D vector, double dx, double dy) {
        // 1. Converter vector.toHomogeneous()
        // 2. Aplicar matriz de translação 3x3
        // 3. Retornar Vector2D.fromHomogeneous(resultado)
        return null; // remover quando implementar
    }

    public Vector3D translate3D(Vector3D vector, double dx, double dy, double dz) {
        // 1. Converter vector.toHomogeneous()
        // 2. Aplicar matriz de translação 4x4
        // 3. Retornar Vector3D.fromHomogeneous(resultado)
        return null;
    }

    // ==================== ROTACAO ====================
    // Ângulos em GRAUS (converter para radianos internamente se necessário)

    public Vector2D rotation2D(Vector2D vector, double angle) {
        // angle em graus
        return null;
    }

    public Vector3D rotation3DX(Vector3D vector, double angle) {
        // Rotação em torno do eixo X
        return null;
    }

    public Vector3D rotation3DY(Vector3D vector, double angle) {
        // Rotação em torno do eixo Y
        return null;
    }

    public Vector3D rotation3DZ(Vector3D vector, double angle) {
        // Rotação em torno do eixo Z
        return null;
    }

    // ==================== REFLEXAO ====================

    public Vector2D reflection2DX(Vector2D vector) {
        // Reflexão em relação ao eixo X (y = -y)
        return null;
    }

    public Vector2D reflection2DY(Vector2D vector) {
        // Reflexão em relação ao eixo Y (x = -x)
        return null;
    }

    public Vector3D reflection3DX(Vector3D vector) {
        // Reflexão em relação ao plano YZ (x = -x)
        return null;
    }

    public Vector3D reflection3DY(Vector3D vector) {
        // Reflexão em relação ao plano XZ (y = -y)
        return null;
    }

    public Vector3D reflection3DZ(Vector3D vector) {
        // Reflexão em relação ao plano XY (z = -z)
        return null;
    }

    // ==================== PROJECAO ====================

    public Vector2D projection2DX(Vector2D vector) {
        // Projeção no eixo X (y = 0)
        return null;
    }

    public Vector2D projection2DY(Vector2D vector) {
        // Projeção no eixo Y (x = 0)
        return null;
    }

    public Vector3D projection3DX(Vector3D vector) {
        // Projeção no plano YZ (x = 0)
        return null;
    }

    public Vector3D projection3DY(Vector3D vector) {
        // Projeção no plano XZ (y = 0)
        return null;
    }

    public Vector3D projection3DZ(Vector3D vector) {
        // Projeção no plano XY (z = 0)
        return null;
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
