package br.com.alura.forum.dto;

import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.CursoRepository;
import org.checkerframework.checker.units.qual.Length;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class TopicoForm {

    @NotNull @NotEmpty
    private String titulo;
    @NotNull @NotEmpty
    private String mensagem;
    @NotNull @NotEmpty
    private String nomeCurso;

    public TopicoForm() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicoForm that = (TopicoForm) o;
        return Objects.equals(titulo, that.titulo) && Objects.equals(mensagem, that.mensagem) && Objects.equals(nomeCurso, that.nomeCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, mensagem, nomeCurso);
    }

    @Override
    public String toString() {
        return "TopicoForm{" +
                "titulo='" + titulo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", nomeCurso='" + nomeCurso + '\'' +
                '}';
    }


    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
