package base.crud.backend.models;

import javax.persistence.*;

@Entity
public class Midia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String titulo;
    String tipo;
    String nota;
    String descrição;
    @ManyToOne
    Usuario usuario;

    public Midia() {
    }

    public Midia(String titulo, String tipo, String nota, String descrição, Usuario usuario) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.nota = nota;
        this.descrição = descrição;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Midia midia = (Midia) o;

        return id.equals(midia.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
