package bibliotecaJordiStelian;

public class Revista {
    private String issn;
    private String titulo;
    private String[] autoria;
    private int prestados;

    public Revista(String issn, String titulo, String[] autoria, int prestados) {
        this.issn = issn;
        this.titulo = titulo;
        this.autoria = autoria;
        this.prestados = prestados;
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

    public String toString(){
        return "Revista:" +
                "\nISSN=" + issn +
                "\nTitulo=" + titulo +
                "\nAutoria=" + autoria +
                "\nPrestados=" + prestados;
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
