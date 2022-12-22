package bibliotecaJordiStelian;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private static ArrayList<Autoria> autorias;
    private static ArrayList<Libro> libros;
    private static ArrayList<Revista> revistas;

    public Biblioteca() {
        autorias = new ArrayList<>();
        libros = new ArrayList<>();
        revistas = new ArrayList<>();
    }

    public static void getAutorias() {
        for (Autoria autoria : autorias) {
            System.out.println(autoria);
        }
    }

    public static void setAutoria(Autoria autoria) {
        autorias.add(autoria);
    }

    public static void getLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public static void setLibro(Libro libro) {
        libros.add(libro);
    }

    public static void getRevistas() {
        for (Revista revista : revistas) {
            System.out.println(revista);
        }
    }

    public static void setRevista(Revista revista) {
        revistas.add(revista);
    }

    public String toString() {
        return "Biblioteca:" +
                "\nAutorias=" + autorias +
                "\nLibros=" + libros +
                "\nRevistas=" + revistas;
    }

    public static String menu() {
        String menu = "1. Crear Autor/a\n" +
                "2. Ver autoras/es\n" +
                "3. Crear Libro\n" +
                "4. Mostrar libros\n" +
                "5. Prestar libro\n" +
                "6. Devolver libro\n" +
                "7. Crear revista\n" +
                "8. Mostrar revistas\n" +
                "9. Prestar revista\n" +
                "10. Devolver revista\n" +
                "0. Salir";
        return menu;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcion = 0;
        do {
            menu();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce el ID del autor/a");
                    int id = sc.nextInt();
                    System.out.println("Introduce el nombre del autor/a");
                    String nombre = sc.nextLine();
                    System.out.println("Introduce los apellidos del autor/a");
                    String apellidos = sc.nextLine();
                    Autoria autoria = new Autoria(id, nombre, apellidos);
                    setAutoria(autoria);
                }
                case 2 -> getAutorias();
                case 3 -> {
                    System.out.println("Introduce el ISBN del libro");
                    int isbn = sc.nextInt();
                    System.out.println("Introduce el título del libro");
                    String titulo = sc.nextLine();
                    System.out.println("Introduce el numero de ejemplares del libro");
                    int numEjemplares = sc.nextInt();
                    System.out.println("Introduce el numero de autoras/es del libro");
                    int numAutorias = sc.nextInt();
                    Libro libro = new Libro(isbn, titulo, numEjemplares);
                    for (int i = 1; i <= numAutorias; i++) {
                        System.out.println("Introduce el ID del autor/a " + i);
                        int id = sc.nextInt();
                        for (Autoria autoria : autorias) {
                            if (autoria.getId() == id) {
                                libro.setAutoria(autoria);
                            }
                        }
                    }

                    libro.setEjemplares(numEjemplares);
                    setLibro(libro);
                }
                case 4 -> getLibros();
                case 5 -> {
                    int isbn;
                    do {
                        System.out.println("Introduce el ISBN del libro");
                        isbn = sc.nextInt();
                        for (Libro libro : libros) {
                            if (libro.getIsbn().equals(isbn)) {
                                if (libro.getEjemplares() > 0) {
                                    libro.prestar();
                                    System.out.println("Numero de ejemplares disponibles: " + libro.getEjemplares());
                                } else {
                                    System.out.println("No hay ejemplares disponibles");
                                }
                            }
                        }
                    } while (!libros.contains(isbn));
                }
                case 6 -> {
                    int isbn;
                    do {
                        System.out.println("Introduce el ISBN del libro");
                        isbn = sc.nextInt();
                        for (Libro libro : libros) {
                            if (libro.getIsbn().equals(isbn)) {
                                if (libro.getPrestados() == 0) {
                                    System.out.println("No hay ejemplares prestados");
                                } else {
                                    libro.devolver();
                                    System.out.println("Numero de ejemplares disponibles: " + libro.getEjemplares());
                                }
                            }
                        }
                    } while (!libros.contains(isbn));
                }
            }
        } while (opcion != 0);

    }
}
