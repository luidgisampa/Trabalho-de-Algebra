package LinearTransformations;

import Matriz.Vector2D;
import Matriz.Vector3D;

import java.util.Scanner;

/*
  Menu principal das Transformações Lineares.
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
    // Menu de tranlacao
    private static void runTranslation() {
        //cabecalho 
        System.out.println("=== Translação ===");
        System.out.println("1 - 2D");
        System.out.println("2 - 3D");
        System.out.print("Escolha a dimensão: ");
        int dimension = scanner.nextInt();

        if (dimension == 1) {
            //vetor 2d
            System.out.print("Digite x do vetor: ");
            double x = scanner.nextDouble();
            System.out.print("Digite y do vetor: ");
            double y = scanner.nextDouble();
            System.out.print("Digite dx: ");
            double dx = scanner.nextDouble();
            System.out.print("Digite dy: ");
            double dy = scanner.nextDouble();

            Vector2D result = transform.translate2D(Vector2D.of(x, y), dx, dy);
            System.out.println("Resultado: " + result);

        } else if (dimension == 2) {
            //vetor 3d
            System.out.print("Digite x do vetor: ");
            double x = scanner.nextDouble();
            System.out.print("Digite y do vetor: ");
            double y = scanner.nextDouble();
            System.out.print("Digite z do vetor: ");
            double z = scanner.nextDouble();
            System.out.print("Digite dx: ");
            double dx = scanner.nextDouble();
            System.out.print("Digite dy: ");
            double dy = scanner.nextDouble();
            System.out.print("Digite dz: ");
            double dz = scanner.nextDouble();

            Vector3D result = transform.translate3D(Vector3D.of(x, y, z), dx, dy, dz);
            System.out.println("Resultado: " + result);

        } else {
            System.out.println("Opção inválida");
        }
    }

    // ==================== ROTACAO ====================
    // Menu de rotação 
    private static void runRotation() { 
        System.out.println("=== Rotação ===");
        System.out.println("1 - 2D");
        System.out.println("2 - 3D");
        System.out.print("Escolha a dimensão: ");
        int dimension = scanner.nextInt();

        if (dimension == 1) {
            //como o vetor gira em torno da origem e preciso apenas do x, y e do ângulo
            System.out.print("Digite x do vetor: ");
            double x = scanner.nextDouble();
            System.out.print("Digite y do vetor: ");
            double y = scanner.nextDouble();
            System.out.print("Digite o ângulo (em graus): ");
            double angle = scanner.nextDouble();

            Vector2D result = transform.rotation2D(Vector2D.of(x, y), angle);
            System.out.println("Resultado: " + result);

        } else if (dimension == 2) {
            //antes de tudo e escolhido o eixo de rotacão
            System.out.println("1 - Eixo X");
            System.out.println("2 - Eixo Y");
            System.out.println("3 - Eixo Z");
            System.out.print("Escolha o eixo: ");
            //esse axis sera ultilizado mais tarde no switch case
            int axis = scanner.nextInt();
            // leitores das 3 coordenadas do vetor
            System.out.print("Digite x do vetor: ");
            double x = scanner.nextDouble();
            System.out.print("Digite y do vetor: ");
            double y = scanner.nextDouble();
            System.out.print("Digite z do vetor: ");
            double z = scanner.nextDouble();
            System.out.print("Digite o ângulo (em graus): ");
            double angle = scanner.nextDouble();

            Vector3D vector3D = Vector3D.of(x, y, z);
            Vector3D result;
            switch (axis) {
                //o switch case que determina qual metodo ele deve chamar de acordo com o a rotacão escolhida
                case 1 -> result = transform.rotation3DX(vector3D, angle);
                case 2 -> result = transform.rotation3DY(vector3D, angle);
                case 3 -> result = transform.rotation3DZ(vector3D, angle);
                default -> {
                    System.out.println("Eixo inválido");
                    return;
                }
            }
            System.out.println("Resultado: " + result);

        } else {
            System.out.println("Opção inválida");
        }
    }

    // ==================== REFLEXAO ====================
    // Menu de reflexão 
    private static void runReflection() {
        System.out.println("=== Reflexão ===");
        System.out.println("1 - 2D");
        System.out.println("2 - 3D");
        System.out.print("Escolha a dimensão: ");
        int dimension = scanner.nextInt();

        if (dimension == 1) {
            //por ser em um plano 2d ultliza apenas X Y e o eixo de rotacao que no caso reflexão em relação ao eixo X (y vira -y) ou ao eixo Y (x vira -x)
            System.out.println("1 - Eixo X");
            System.out.println("2 - Eixo Y");
            System.out.print("Escolha o eixo: ");
            //esse axis sera ultilizado mais tarde no switch case
            int axis = scanner.nextInt();
            //leitores das coordenadas
            System.out.print("Digite x do vetor: ");
            double x = scanner.nextDouble();
            System.out.print("Digite y do vetor: ");
            double y = scanner.nextDouble();

            Vector2D vector2D = Vector2D.of(x, y);
            Vector2D result;
            switch (axis) {
                //o switch case que determina qual metodo ultilizar 
                case 1 -> result = transform.reflection2DX(vector2D);
                case 2 -> result = transform.reflection2DY(vector2D);
                default -> {
                    System.out.println("Eixo inválido");
                    return;
                }
            }
            System.out.println("Resultado: " + result);

        } else if (dimension == 2) {
            //por ser em um plano 3d ele pede o X Y Z e o eixo de rotacaox
            // (X inverte o x e espelha no plano YZ, e assim por diante)
            
            System.out.println("1 - X (plano YZ)");
            System.out.println("2 - Y (plano XZ)");
            System.out.println("3 - Z (plano XY)");
            System.out.print("Escolha o eixo: ");
            int axis = scanner.nextInt();
            //esse axis sera ultilizado mais tarde no switch case

            //leitores das coordenadas 
            System.out.print("Digite x do vetor: ");
            double x = scanner.nextDouble();
            System.out.print("Digite y do vetor: ");
            double y = scanner.nextDouble();
            System.out.print("Digite z do vetor: ");
            double z = scanner.nextDouble();

            Vector3D vector3D = Vector3D.of(x, y, z);
            Vector3D result;
            switch (axis) {
                //switch case que determina qual metodo ultlizar 
                case 1 -> result = transform.reflection3DX(vector3D);
                case 2 -> result = transform.reflection3DY(vector3D);
                case 3 -> result = transform.reflection3DZ(vector3D);
                default -> {
                    System.out.println("Eixo inválido");
                    return;
                }
            }
            System.out.println("Resultado: " + result);

        } else {
            System.out.println("Opção inválida");
        }
    }

    // ==================== PROJECAO ====================
    // Menu de projeção 
    private static void runProjection() {
        System.out.println("=== Projeção ===");
        System.out.println("1 - 2D");
        System.out.println("2 - 3D");
        System.out.print("Escolha a dimensão: ");
        int dimension = scanner.nextInt();

        if (dimension == 1) {
            //a projeção por ser 2d precisa somente do X e Y. No caso sobre o eixo X (zera o y) ou sobre o eixo Y (zera o x)
            System.out.println("1 - Eixo X");
            System.out.println("2 - Eixo Y");
            System.out.print("Escolha o eixo: ");
            int axis = scanner.nextInt();
            //esse axis sera ultilizado mais tarde no switch case

            //leitores das coordenadas 
            System.out.print("Digite x do vetor: ");
            double x = scanner.nextDouble();
            System.out.print("Digite y do vetor: ");
            double y = scanner.nextDouble();

            Vector2D vector2D = Vector2D.of(x, y);
            Vector2D result;
            switch (axis) {
                //switch case que determina qual metodo ultlizar 
                case 1 -> result = transform.projection2DX(vector2D);
                case 2 -> result = transform.projection2DY(vector2D);
                default -> {
                    System.out.println("Eixo inválido");
                    return;
                }
            }
            System.out.println("Resultado: " + result);

        } else if (dimension == 2) {
            //por ser em um plano 3d pede X Y e Z 
            //projeção sobre um plano (YZ zera o x, XZ zera o y, XY zera o z)
            
            System.out.println("1 - X (plano YZ)");
            System.out.println("2 - Y (plano XZ)");
            System.out.println("3 - Z (plano XY)");
            System.out.print("Escolha o eixo: ");
            int axis = scanner.nextInt();
            //esse axis sera ultilizado mais tarde no switch case

            //leitores das coordenadas 
            System.out.print("Digite x do vetor: ");
            double x = scanner.nextDouble();
            System.out.print("Digite y do vetor: ");
            double y = scanner.nextDouble();
            System.out.print("Digite z do vetor: ");
            double z = scanner.nextDouble();

            Vector3D vector3D = Vector3D.of(x, y, z);
            Vector3D result;
            switch (axis) {
                //switch case que determina qual metodo ultlizar
                case 1 -> result = transform.projection3DX(vector3D);
                case 2 -> result = transform.projection3DY(vector3D);
                case 3 -> result = transform.projection3DZ(vector3D);
                default -> {
                    System.out.println("Eixo inválido");
                    return;
                }
            }
            System.out.println("Resultado: " + result);

        } else {
            System.out.println("Opção inválida");
        }
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
