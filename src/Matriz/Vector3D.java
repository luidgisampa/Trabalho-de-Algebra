package Matriz;

public interface Vector3D {

    double getX();

    double getY();

    double getZ();

    // (x, y, z) -> [x, y, z, 1]
    Vector toHomogeneous();

    // Cria um vetor 3D a partir de x, y e z
    static Vector3D of(double x, double y, double z) {
        return new Vector(3, new float[]{(float) x, (float) y, (float) z});
    }

    // [x, y, z, w] -> (x/w, y/w, z/w)
    static Vector3D fromHomogeneous(Vector v) {
        if (v.getDim() != 4) {
            throw new IllegalArgumentException(
                "Um vetor homogêneo 3D precisa ter dimensão 4, mas tem " + v.getDim() + ".");
        }
        float w = v.get(3);
        if (w == 0f) {
            throw new IllegalArgumentException(
                "Coordenada homogênea w = 0 (ponto no infinito): não dá para converter para 3D.");
        }
        return of(v.get(0) / w, v.get(1) / w, v.get(2) / w);
    }
}
