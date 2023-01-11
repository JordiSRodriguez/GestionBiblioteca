package bibliotecaJordiStelian;

import java.util.Arrays;

public class Libro {
    private String isbn;
    private String titulo;
    private String[] autoria;
    private int ejemplares;
    private int prestados;

    public Libro(){

    }
    public Libro(String isbn, String titulo, int ejemplares, int autores) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ejemplares = ejemplares;
        this.autoria = new String[autores];

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getAutoria() {
        return autoria;
    }

    public void setAutoria(String[] autoria) {
        this.autoria = autoria;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public int getPrestados() {
        return prestados;
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }


    public void anadirAutor(Autoria autoria){
       for (int i = 0; i < this.autoria.length; i++) {
           if(this.autoria[i] == null){
               this.autoria[i] = String.valueOf(autoria);
               break;
           }
       }
    }


    public String toString(){
        String aux = "";
        aux+= "Libro:" +
                "\nISBN=" + isbn + "" +
                "\nTitulo=" + titulo +
                "\nAutoria=\n";
        for (int i = 0; i < autoria.length; i++) {
            aux += autoria[i];
        }
        aux += "\nEjemplares=" + ejemplares +
                "\nPrestados=" + prestados;
        return aux;
    }

    public int prestar(){
        if(ejemplares >= prestados){
            prestados++;
            ejemplares--;
            return ejemplares;
        }else{
            return -1;
        }
    }


    public int devolver(){
        if (prestados > 0){
            prestados--;
            ejemplares++;
            return ejemplares - prestados;
        }else{
            return -1;
        }
    }


}
