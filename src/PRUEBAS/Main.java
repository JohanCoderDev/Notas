/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRUEBAS;

import java.util.Scanner;

/**
 *
 * @author Johan Ordoñez
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        // Agregar estudiantes
        while (true) {
            System.out.print("Ingrese el número de documento del estudiante (o presione Enter para finalizar): ");
            String document = scanner.nextLine();
            if (document.isEmpty()) {
                break;
            }
            System.out.print("Ingrese el nombre del estudiante: ");
            String name = scanner.nextLine();
            System.out.print("Ingrese el correo electrónico del estudiante: ");
            String email = scanner.nextLine();
            System.out.print("Ingrese el género del estudiante: ");
            String gender = scanner.nextLine();

            Student student = new Student(document, name, email, gender);
            bst.insert(student);
        }

        // Mostrar estudiantes ordenados alfabéticamente
        System.out.println("\nEstudiantes ordenados alfabéticamente:");
        bst.inorderTraversal(bst.root);
    }
}

