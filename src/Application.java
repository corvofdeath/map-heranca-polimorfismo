import entities.Escala;
import entities.Filme;
import entities.Funcionario;
import funcoes.Funcao;
import funcoes.ListaFuncoes;
import services.EscalaService;
import services.FilmeService;
import services.FuncionarioService;

public class Application {

    public static void main (String[] args) {

        FuncionarioService funcionarioService = new FuncionarioService();
        FilmeService filmeService = new FilmeService();
        EscalaService escalaService = new EscalaService();

        GloboFilmes globoFilmes = new GloboFilmes(filmeService, funcionarioService, escalaService);

        Filme filme1 = globoFilmes.createFilme("Era Uma Vez No Espaço", "2003");

        Funcionario funcionario1 = globoFilmes.createFuncionario("André");
        Funcionario funcionario2 = globoFilmes.createFuncionario("Julia");
        Funcionario funcionario3 = globoFilmes.createFuncionario("Alice");
        Funcionario funcionario4 = globoFilmes.createFuncionario("Claudio");
        Funcionario funcionario5 = globoFilmes.createFuncionario("Jose");

        Escala escala1 = globoFilmes.createEscala(funcionario1, filme1, ListaFuncoes.DIRETOR, ListaFuncoes.PRODUTOR);
        Escala escala2 = globoFilmes.createEscala(funcionario2, filme1, ListaFuncoes.CINEGRAFISTA);
        Escala escala3 = globoFilmes.createEscala(funcionario3, filme1, ListaFuncoes.ELENCO, ListaFuncoes.PRODUTOR);
        Escala escala4 = globoFilmes.createEscala(funcionario4, filme1, ListaFuncoes.ROTEIRISTA, ListaFuncoes.ATOR);
        Escala escala5 = globoFilmes.createEscala(funcionario5, filme1, ListaFuncoes.TRILHASONORA);

        Filme filme2 = globoFilmes.createFilme("2002 - Outra Odisseia no Espaco", "2020");
        Escala escala6 = globoFilmes.createEscala(funcionario1, filme2, ListaFuncoes.ROTEIRISTA, ListaFuncoes.ATOR);
        Escala escala7 = globoFilmes.createEscala(funcionario2, filme2, ListaFuncoes.DIRETOR);
        Escala escala8 = globoFilmes.createEscala(funcionario3, filme2, ListaFuncoes.ATOR);
        Escala escala9 = globoFilmes.createEscala(funcionario4, filme2, ListaFuncoes.ROTEIRISTA, ListaFuncoes.ATOR, ListaFuncoes.ELENCO);
        Escala escala10 = globoFilmes.createEscala(funcionario5, filme2, ListaFuncoes.CINEGRAFISTA);

        System.out.println(globoFilmes.listAllFilmesComEscalas());

        System.out.println(globoFilmes.listFilmografiaByFuncionarioAndFuncao(funcionario1.getNome(), ListaFuncoes.DIRETOR));
        System.out.println(globoFilmes.listFilmografiaByFuncionarioAndFuncao(funcionario1.getNome(), ListaFuncoes.TRILHASONORA));
        System.out.println(globoFilmes.listFilmografiaByFuncionarioAndFuncao(funcionario4.getNome(), ListaFuncoes.ATOR));
    }
}
