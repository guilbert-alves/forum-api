package br.com.alura.forum.dto;

import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.TopicoRepository;
import org.checkerframework.checker.units.qual.Length;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;

public class AtualizacaoTopicoForm {

    @NotNull @NotEmpty
    private String titulo;

    @NotNull @NotEmpty
    private String mensagem;

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

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getById(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);

        return topico;
    }
}
