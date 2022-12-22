package bibliotecaJordiStelian;

public class Libro {
    private String isbn;
    private String titulo;
    private String[] autoria;
    private int ejemplares;
    private int prestados;

    public Libro(String isbn, String titulo, String[] autoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autoria = autoria;
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
        this.ejemplares += ejemplares;
    }

    public int getPrestados() {
        return prestados;
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }

    public String toString(){
        return "Libro:" +
                "\nISBN=" + isbn + "" +
                "\nTitulo=" + titulo +
                "\nAutoria=" + autoria +
                "\nEjemplares=" + ejemplares +
                "\nPrestados=" + prestados;
    }
    public int prestar(){
        if (ejemplares > prestados){
            prestados++;
            return ejemplares - prestados;
        }else{
            return -1;
        }
    }

    public int devolver(){
        if (prestados > 0){
            prestados--;
            return ejemplares - prestados;
        }else{
            return -1;
        }
    }


}
