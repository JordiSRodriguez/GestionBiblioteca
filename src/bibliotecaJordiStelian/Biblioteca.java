package bibliotecaJordiStelian;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private static ArrayList<Autoria> autorias;
    private static ArrayList<Libro> libros;
    private static ArrayList<Revista> revistas;
    public static Scanner sc = new Scanner(System.in);
    public static Scanner sc2 = new Scanner(System.in);

    public Biblioteca() {
        autorias = new ArrayList<>();
        libros = new ArrayList<>();
        revistas = new ArrayList<>();
    }

    /**
     * Recibe el return del toString de la clase Autoria y lo imprime por pantalla
     */
    public static void getAutorias() {
        for (Autoria autoria : autorias) {
            System.out.println(autoria);
        }
    }

    public static void setAutoria(Autoria autoria) {
        autorias.add(autoria);
    }
    /**
     * Recibe el return del toString de la clase Libro y lo imprime por pantalla
     */
    public static void getLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public static void setLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Recibe el return del toString de la clase Revista y lo imprime por pantalla
     */
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

    /**
     * Al ser llamada esta funcion imprime las opciones del menu
     */
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

        Biblioteca biblioteca = new Biblioteca();
        int opcion = 0;

        do {
            menu();
            opcion = sc2.nextInt();
            switch (opcion) {
                case 1 -> crearAutor();
                case 2 -> getAutorias();
                case 3 -> crearLibro();
                case 4 -> getLibros();
                case 5 -> prestarLibro();
                case 6 -> devolverLibro();
                case 7 -> crearRevista();
                case 8 -> getRevistas();
                case 9 -> prestarRevista();
                case 10 -> devolverRevista();
            }
        } while (opcion != 0);
    }

    /**
     * Crea un autor y lo añade a la lista de autorias, para ello pide al usuario el nombre y los dos apellidos
     */
    public static void crearAutor(){
        System.out.println("Introduce el ID del autor/a");
        int id = sc2.nextInt();
        System.out.println("Introduce el nombre del autor/a");
        String nombre = sc.nextLine();
        System.out.println("Introduce los apellidos del autor/a");
        String apellidos = sc.nextLine();
        Autoria autoria = new Autoria(id, nombre, apellidos);
        setAutoria(autoria);
    }

    /**
     * Crea un libro y lo añade a la lista de libros, para ello pide al usuario el titulo, el isbn y el numero de autores
     * Despues pide al usuario el id del autor y lo busca en la lista de autorias, si lo encuentra lo añade a la lista de autores del libro
     */
    public static void crearLibro(){
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

    /**
     * Le pide al usuario el isbn del libro que quiere prestar y lo busca en la lista de libros, si lo encuentra le pide al usuario el numero de ejemplar
     * que quiere prestar y lo busca en la lista de ejemplares del libro, si lo encuentra y esta disponible lo presta
     */
    public static void prestarLibro(){
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
    /**
     * Le pide al usuario el isbn del libro que quiere devolver y lo busca en la lista de libros, si lo encuentra le pide al usuario el numero de ejemplar
     * que quiere devolver y lo busca en la lista de ejemplares del libro, si lo encuentra y esta prestado lo devuelve
     */
    public static void devolverLibro(){
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

    /**
     * Crea una revista y la añade a la lista de revistas, para ello pide al usuario el titulo, el isbn y el numero de autores
     * Despues pide al usuario el id del autor y lo busca en la lista de autorias, si lo encuentra lo añade a la lista de autores de la revista
     */
    public static void crearRevista(){
        System.out.println("Introduce el ISSN de la revista");
        String issn = sc.nextLine();
        System.out.println("Introduce el título de la revista");
        String titulo = sc.nextLine();
        System.out.println("Introduce el numero de autoras/es de la revista");
        int numAutorias = sc2.nextInt();
        Revista revista = new Revista(issn, titulo, numAutorias);
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
    /**
     * Le pide al usuario el issn de la revista que quiere prestar y lo busca en la lista de revistas, si lo encuentra le pide al usuario el numero de ejemplar
     * que quiere prestar y lo busca en la lista de ejemplares de la revista, si lo encuentra y esta disponible lo presta
     */
    public static void prestarRevista(){
        System.out.println("Introduce el ISSN de la revista");
        String issn = sc.nextLine();
        for (Revista revista : revistas) {
            if (revista.getIssn().equals(issn)) {
                revista.prestar();
                System.out.println("La revista " + revista.getTitulo() + " ha sido prestada");
            }
        }
    }
    /**
     * Le pide al usuario el issn de la revista que quiere devolver y lo busca en la lista de revistas, si lo encuentra le pide al usuario el numero de ejemplar
     * que quiere devolver y lo busca en la lista de ejemplares de la revista, si lo encuentra y esta prestado lo devuelve
     */
    public static void devolverRevista(){
        System.out.println("Introduce el ISSN de la revista");
        String issn = sc.nextLine();
        for (Revista revista : revistas) {
            if (revista.getIssn().equals(issn)) {
                if (revista.getPrestados() > 0) {
                    revista.devolver();
                    System.out.println("La revista " + revista.getTitulo() + " ha sido devuelta");
                } else {
                    System.out.println("No quedan revistas prestadas");
                }
            }
        }
    }
}
