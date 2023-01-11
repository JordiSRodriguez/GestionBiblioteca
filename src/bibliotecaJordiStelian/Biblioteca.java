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

    public static void menu() {
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
        System.out.println(menu);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcion = 0;

        do {
            menu();
            opcion = sc2.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce el ID del autor/a");
                    int id = sc2.nextInt();
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
                    String isbn = sc.nextLine();
                    System.out.println("Introduce el título del libro");
                    String titulo = sc.nextLine();
                    System.out.println("Introduce el numero de ejemplares del libro");
                    int numEjemplares = sc2.nextInt();
                    System.out.println("Introduce el numero de autoras/es del libro");
                    int numAutorias = sc2.nextInt();
                    Libro libro = new Libro(isbn, titulo, numEjemplares, numAutorias);
                    for (int i = 1; i <= numAutorias; i++) {
                        System.out.println("Introduce el ID del autor/a " + i);
                        int id = sc2.nextInt();
                        for (Autoria autoria : autorias) {
                            if (autoria.getId() == id) {
                                libro.anadirAutor(autoria);
                            }
                        }
                    }

                    libro.setEjemplares(numEjemplares);
                    setLibro(libro);
                }
                case 4 -> getLibros();
                case 5 ->{
                    System.out.println("Introduce el ISBN del libro");
                    String isbn = sc.nextLine();
                    for (Libro libro : libros) {
                        if (libro.getIsbn().equals(isbn)) {
                            if (libro.getEjemplares() > 0) {
                                libro.prestar();
                                System.out.println("El libro " + libro.getTitulo() + " ha sido prestado");
                                System.out.println("Quedan " + libro.getEjemplares() + " ejemplares disponibles");
                            } else {
                                System.out.println("No quedan ejemplares disponibles");
                            }
                        }
                    }
                }

                case 6 -> {
                    System.out.println("Introduce el ISBN del libro");
                    String isbn = sc.nextLine();
                    for (Libro libro : libros) {
                        if (libro.getIsbn().equals(isbn)) {
                            if (libro.getPrestados() > 0) {
                                libro.devolver();
                                System.out.println("El libro " + libro.getTitulo() + " ha sido devuelto");
                                System.out.println("Quedan " + libro.getEjemplares() + " ejemplares disponibles");
                            } else {
                                System.out.println("No quedan ejemplares prestados");
                            }
                        }
                    }
                }

                case 7 -> {
                    System.out.println("Introduce el ISSN de la revista");
                    String issn = sc.nextLine();
                    System.out.println("Introduce el título de la revista");
                    String titulo = sc.nextLine();
                    System.out.println("Introduce el numero de prestamos de la revista");
                    int numPrestamos = sc2.nextInt();
                    System.out.println("Introduce el numero de autoras/es de la revista");
                    int numAutorias = sc2.nextInt();
                    Revista revista = new Revista(issn, titulo, numPrestamos, numAutorias);
                    for (int i = 1; i <= numAutorias; i++) {
                        System.out.println("Introduce el ID del autor/a " + i);
                        int id = sc2.nextInt();
                        for (Autoria autoria : autorias) {
                            if (autoria.getId() == id) {
                                revista.anadirAutor(autoria);
                            }
                        }
                    }
                    setRevista(revista);
                }
                case 8 -> getRevistas();
                case 9 -> {
                    int issn;
                    do {
                        System.out.println("Introduce el ISSN de la revista");
                        issn = sc2.nextInt();
                        for (Revista revista : revistas) {
                            if (revista.getIssn().equals(issn)) {
                                revista.prestar();
                                System.out.println("Revista prestada");
                            } else {
                                System.out.println("La revista no existe");
                            }
                        }
                    } while (!revistas.contains(issn));
                }
            }
        } while (opcion != 0);
    }
}
