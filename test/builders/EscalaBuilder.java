package builders;

import java.util.ArrayList;
import java.util.Collection;

import entities.Escala;
import entities.Filme;
import entities.Funcionario;

public class EscalaBuilder {
	
	private Escala escala;
	private Collection<Escala> collectionEscala;
	
	public static EscalaBuilder mockEscala() {
		Filme filme = FilmeBuilder.mockFilme().getFilme();
		Funcionario funcionario = FuncionarioBuilder.mockFuncionario().getFuncionario();
		EscalaBuilder builder = new EscalaBuilder();
		builder.escala = new Escala(funcionario, filme);
		
		return builder;
	}
	
	public static EscalaBuilder mockCollectionEscala() {
		EscalaBuilder builder = new EscalaBuilder();
		builder.collectionEscala = new ArrayList<Escala>();
		
		for(int i=0; i<10; i++) {
			Escala escala = new Escala(FuncionarioBuilder.mockFuncionario().getFuncionario(), FilmeBuilder.mockFilme().getFilme());
			
			builder.collectionEscala.add(escala);
		}
		
		return builder;
	}
	
	public Escala getEscala() {
		return this.escala;
	}

}
