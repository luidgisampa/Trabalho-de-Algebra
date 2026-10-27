package Matriz;

/*
  Classe que representa um Vetor unidimensional.
*/
public class Vector implements Vector2D, Vector3D {
    private final int dim;
    private final float[] elements;

    /*
      Construtor da classe Vector.
		dim Dimensão (tamanho) do vetor.
		elements Array de elementos do vetor.
    */
    
    public Vector(int dim, float[] elements) {
        // Valida se a quantidade de elementos fornecida corresponde à dimensão
        if (elements.length != dim) {
            throw new IllegalArgumentException("O tamanho do array não bate com a dimensão informada.");
        }
        this.dim = dim;
        // Clona o array para garantir o encapsulamento (evita alterações externas diretas)
        this.elements = elements.clone();
    }

    // Retorna a dimensão do vetor
    public int getDim() {
        return dim;
    }

    // Obtém o elemento no índice especificado
    public float get(int index) {
        validateIndex(index);
        return elements[index];
    }

    // Altera o elemento no índice especificado
    public void set(int index, float value) {
        validateIndex(index);
        elements[index] = value;
    }

    // Verifica se o índice fornecido está dentro dos limites válidos do array
    private void validateIndex(int index) {
        if (index < 0 || index >= dim) {
            throw new IndexOutOfBoundsException("Índice " + index + " fora dos limites do vetor.");
        }
    }

    // Exibe o vetor formatado na tela
    public void display() {
        System.out.print("[ ");
        for (int i = 0; i < dim; i++) {
            System.out.printf("%.2f ", elements[i]);
        }
        System.out.println("]");
    }

    // ==================== NOVO (trabalho de Transformações Lineares) ====================
    // Coordenada x (índice 0)
    @Override
    public double getX() {
        return get(0);
    }

    // Coordenada y (índice 1)
    @Override
    public double getY() {
        return get(1);
    }

    // Coordenada z (índice 2): só existe em vetores de dimensão 3 ou mais
    @Override
    public double getZ() {
        return get(2);
    }

    /*
      Converte para coordenadas homogêneas: copia os elementos e acrescenta 1 no final.
      2D: (x, y) -> [x, y, 1]     3D: (x, y, z) -> [x, y, z, 1]
    */
    @Override
    public Vector toHomogeneous() {
        // Só faz sentido para vetores 2D ou 3D
        if (dim != 2 && dim != 3) {
            throw new IllegalArgumentException(
                "Só vetores de dimensão 2 ou 3 podem virar coordenadas homogêneas (dimensão atual: " + dim + ").");
        }
        float[] result = new float[dim + 1];
        System.arraycopy(elements, 0, result, 0, dim);
        result[dim] = 1f;
        return new Vector(dim + 1, result);
    }

    // Texto no formato (x, y, ...) com 2 casas decimais
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < dim; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(String.format("%.2f", elements[i]));
        }
        return sb.append(")").toString();
    }
}
