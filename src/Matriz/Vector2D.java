package Matriz;

public interface Vector2D {

    double getX();

    double getY();

    // (x, y) -> [x, y, 1]
    Vector toHomogeneous();

    // Cria um vetor 2D a partir de x e y
    static Vector2D of(double x, double y) {
        return new Vector(2, new float[]{(float) x, (float) y});
    }

    // [x, y, w] -> (x/w, y/w)
    static Vector2D fromHomogeneous(Vector v) {
        if (v.getDim() != 3) {
            throw new IllegalArgumentException(
                "Um vetor homogêneo 2D precisa ter dimensão 3, mas tem " + v.getDim() + ".");
        }
        float w = v.get(2);
        if (w == 0f) {
            throw new IllegalArgumentException(
                "Coordenada homogênea w = 0 (ponto no infinito): não dá para converter para 2D.");
        }
        return of(v.get(0) / w, v.get(1) / w);
    }
}
