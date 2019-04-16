import entities.Escala;
import entities.Filme;
import entities.Funcionario;
import funcoes.Funcao;
import funcoes.ListaFuncoes;
import services.EscalaService;
import services.FilmeService;
import services.FuncionarioService;

import java.util.List;

public class GloboFilmes {


    private final FilmeService filmeService;
    private final FuncionarioService funcionarioService;
    private final EscalaService escalaService;

    public GloboFilmes(FilmeService filmeService, FuncionarioService funcionarioService, EscalaService escalaService) {
        this.filmeService = filmeService;
        this.funcionarioService = funcionarioService;
        this.escalaService = escalaService;
    }

    public Filme createFilme(String nome, String ano) {
        Filme filme = new Filme(nome, ano);
        return this.filmeService.save(filme);
    }

    public Funcionario createFuncionario(String nome) {
        Funcionario funcionario = new Funcionario(nome);
        return this.funcionarioService.save(funcionario);
    }

    public Escala createEscala(Funcionario funcionario, Filme filme, ListaFuncoes...funcoes) {

        Escala escala = new Escala(funcionario, filme);
        for (ListaFuncoes funcao : funcoes) {
            escala.addFuncao(new Funcao(funcao.getNome()));
        }

        // set relationships
        funcionario.addEscala(escala);
        filme.addEscala(escala);

        return this.escalaService.save(escala);
    }

    public String listAllFilmesComEscalas() {
        StringBuilder builder = new StringBuilder();

        for (Filme filme : this.filmeService.getAll()) {

            builder.append("\n");
            builder.append("=================== Filme - " + filme.getNome() + " - Ano - " + filme.getAno() + " ===========================");

            for (Escala escala: filme.getEscalas()) {
                builder.append(escala.getListaDeFuncoes());
            }

            builder.append("\n");
        }

        return builder.toString();
    }

    public String listFilmografiaByFuncionarioAndFuncao(String nome, ListaFuncoes funcao) {

        StringBuilder builder = new StringBuilder();

        builder.append("=========== Filmografia do Funcionario: " + nome + " na Função: " + funcao.getNome());

        List<Escala> escalas = this.escalaService.findByFuncionarioAndFuncao(nome, funcao.getNome());

        if (escalas.isEmpty()) {
            builder.append("\n");
            builder.append("Não encontrado filmes para esse funcionario nesta função!");
        }
        else {
            escalas.forEach(escala -> builder.append(escala.getListaDeFuncoes()));
        }

        builder.append("\n");
        return builder.toString();
    }
}
