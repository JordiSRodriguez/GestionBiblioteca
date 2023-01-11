package bibliotecaJordiStelian;

import java.util.Arrays;

public class Revista {
    private String issn;
    private String titulo;
    private String[] autoria;
    private int prestados;

    public Revista(String issn, String titulo, int autores) {
        this.issn = issn;
        this.titulo = titulo;
        this.autoria = new String[autores];
    }
    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
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

    public int getPrestados() {
        return prestados;
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }

    /**
     *Añade un autor a la lista de autores de la revista
     * @param autoria
     */
    public void anadirAutor(Autoria autoria){
        for (int i = 0; i < this.autoria.length; i++) {
            if(this.autoria[i] == null){
                this.autoria[i] = String.valueOf(autoria);
                break;
            }
        }

    }

    /**
     * Devuelve todos los datos de la revista
     * @return
     */
    public String toString(){
        String aux = "";
        aux += "Revista:" +
                "\nISSN=" + issn +
                "\nTitulo=" + titulo + "\n";
        for (int i = 0; i < autoria.length; i++) {
                aux += autoria[i];
        }
        aux += "\nPrestados=" + prestados;
        return aux;
    }
    /**
     * Devuelve el número que sirve de contador para saber si el la revista se ha prestado o no
     * cada vez que se presta el numero de prestados aumenta en 1
     * @return
     */
    public int prestar(){
        prestados++;
        return prestados;
    }

    /**
     * Devuelve el número que sirve de contador para saber si el la revista se ha devuelto o no
     * cada vez que se devuelve el numero de prestados disminuye en 1
     * @return
     */
    public int devolver(){
        if (prestados > 0){
            prestados--;
        }
        return prestados;
    }
}
