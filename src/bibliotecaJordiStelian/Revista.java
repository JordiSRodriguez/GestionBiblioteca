package bibliotecaJordiStelian;

public class Revista {
    private String issn;
    private String titulo;
    private String[] autoria;
    private int prestados;

    public Revista(String issn, String titulo, int prestados) {
        this.issn = issn;
        this.titulo = titulo;
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

    public void anadirAutor(Autoria autoria){
        for (int i = 0; i < this.autoria.length; i++) {
            if(this.autoria[i] == null){
                this.autoria[i] = String.valueOf(autoria);
                break;
            }
        }

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
