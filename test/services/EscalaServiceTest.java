package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import builders.EscalaBuilder;
import builders.FuncaoBuilder;
import entities.Escala;

public class EscalaServiceTest {
	
	private EscalaService escalaService;

	private Escala escala;
	
    @Before
    public void setUp(){
    	this.escalaService = new EscalaService();
    	this.escala = EscalaBuilder.mockEscala().getEscala();
    }
    
    @Test
    public void getAll() {
    	this.escalaService.save(this.escala);
    	this.escalaService.save(this.escala);
    	
    	assertFalse(this.escalaService.getAll().isEmpty());
    	assertEquals(this.escalaService.getAll().size(),2);
    }
    
    @Test
    public void getById() {
    	this.escalaService.save(this.escala);
    	assertEquals(this.escalaService.getById(this.escala.getId()), this.escala);
    }
    
    @Test
    public void save() {
    	assertEquals(this.escalaService.save(this.escala), this.escala);
    }
    
    @Test
    public void findByFuncionarioAndFuncao() {
    	assertTrue(this.escalaService.findByFuncionarioAndFuncao(escala.getFuncionario().getNome(), FuncaoBuilder.mockFuncao().getFuncao().getFuncao()).isEmpty());
    }
}
