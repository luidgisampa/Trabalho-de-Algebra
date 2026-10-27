package LinearTransformations;

import Matriz.Vector2D;

import java.util.Scanner;

/*
  Menu principal das Transformações Lineares.
  Cada transformação tem o seu próprio método (runTranslation, runRotation, ...),
*/

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Transformations transform = new Transformations();

    public static void main(String[] args) {
        System.out.println("=== Transformações Lineares ===");
        System.out.println("1 - Translação");
        System.out.println("2 - Rotação");
        System.out.println("3 - Reflexão");
        System.out.println("4 - Projeção");
        System.out.println("5 - Cisalhamento");
        System.out.print("Escolha a transformação: ");

        int option = scanner.nextInt();

        switch (option) {
            case 1 -> runTranslation();
            case 2 -> runRotation();
            case 3 -> runReflection();
            case 4 -> runProjection();
            case 5 -> runShearing();
            default -> System.out.println("Opção inválida");
        }

        scanner.close();
    }

    // ==================== TRANSLACAO ====================
    // Pedir dimensões (2D ou 3D), criar vetor, pedir dx/dy/dz, chamar método e imprimir
    private static void runTranslation() {
        System.out.println("Translação ainda não implementada no Main");
    }

    // ==================== ROTACAO ====================
    // Menu de rotação (2D ou 3D + eixo)
    private static void runRotation() {
        System.out.println("Rotação ainda não implementada no Main");
    }

    // ==================== REFLEXAO ====================
    // Menu de reflexão (2D ou 3D + eixo)
    private static void runReflection() {
        System.out.println("Reflexão ainda não implementada no Main");
    }

    // ==================== PROJECAO ====================
    // Menu de projeção (2D ou 3D + eixo)
    private static void runProjection() {
        System.out.println("Projeção ainda não implementada no Main");
    }

    // ==================== CISALHAMENTO ====================
    // Cisalhamento (só 2D)
    private static void runShearing() {
        System.out.println("=== Cisalhamento 2D ===");
        System.out.print("Digite x do vetor: ");
        double x = scanner.nextDouble();
        System.out.print("Digite y do vetor: ");
        double y = scanner.nextDouble();
        System.out.print("Digite kx: ");
        double kx = scanner.nextDouble();
        System.out.print("Digite ky: ");
        double ky = scanner.nextDouble();

        Vector2D vector2D = Vector2D.of(x, y);
        Vector2D result = transform.shearing(vector2D, kx, ky);
        System.out.println("Resultado: " + result);
    }
}
