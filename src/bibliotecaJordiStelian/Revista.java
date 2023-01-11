package bibliotecaJordiStelian;

import java.util.Arrays;

public class Revista {
    private String issn;
    private String titulo;
    private String[] autoria;
    private int prestados;

    public Revista(String issn, String titulo, int prestados, int autores) {
        this.issn = issn;
        this.titulo = titulo;
        this.prestados = prestados;
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
        aux += "Revista:" +
                "\nISSN=" + issn +
                "\nTitulo=" + titulo +
                "\nAutoria=\n";
        for (int i = 0; i < autoria.length; i++) {
                aux += autoria[i];
        }
        aux += "\nPrestados=" + prestados;
        return aux;
    }
    public int prestar(){
        prestados++;
        return prestados;
    }

    public int devolver(){
        prestados--;
        return prestados;
    }
}
