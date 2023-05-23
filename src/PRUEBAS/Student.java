/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRUEBAS;

/**
 *
 * @author Johan Ordoñez
 */
import java.util.Scanner;

class Student {
    String document;
    String name;
    String email;
    String gender;

    public Student(String document, String name, String email, String gender) {
        this.document = document;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}

class Node {
    Student student;
    Node left;
    Node right;

    public Node(Student student) {
        this.student = student;
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(Student student) {
        Node newNode = new Node(student);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                if (student.name.compareTo(current.student.name) < 0) {
                    if (current.left == null) {
                        current.left = newNode;
                        break;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = newNode;
                        break;
                    }
                    current = current.right;
                }
            }
        }
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println("Name: " + node.student.name);
            System.out.println("Document: " + node.student.document);
            System.out.println("Email: " + node.student.email);
            System.out.println("Gender: " + node.student.gender);
            System.out.println();
            inorderTraversal(node.right);
        }
    }
}


