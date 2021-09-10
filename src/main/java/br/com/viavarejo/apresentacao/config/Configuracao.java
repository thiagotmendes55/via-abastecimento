package br.com.viavarejo.apresentacao.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.viavarejo.apresentacao.domain.Filial;
import br.com.viavarejo.apresentacao.repositories.FilialRepository;

@Profile("dev")
@Configuration
public class Configuracao implements CommandLineRunner {

	@Autowired
	private FilialRepository filialRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		filialRepo.deleteAll();
		Filial f1 = new Filial(21, 1200, "D", "33041260094711", "Jundiai", "Rua", 100, "Centro", "Jundiai", "SP", "10120562", 21, 1200, "D");
		Filial f2 = new Filial(21, 1088, "D", "33041260094712", "Ribeirao Preto", "Rua", 100, "Centro", "Ribeirao Preto", "SP", "12120562", 21, 1200, "D");
		Filial f3 = new Filial(21, 1500, "D", "33041260094713", "São Bernardo do Campo", "Rua", 100, "Centro", "São Bernardo do Campo", "SP", "10120162", 21, 1200, "D");
		Filial f4 = new Filial(21, 1760, "D", "33041260094714", "Contagem", "Rua", 100, "Centro", "Contagem", "MG", "10120202", 21, 1200, "D");
		Filial f5 = new Filial(21, 1475, "D", "33041260094711", "São José dos Pinhais", "Rua", 100, "Centro", "São José dos Pinhais", "PR", "11120562", 21, 1200, "D");
		filialRepo.saveAll(Arrays.asList(f1, f2, f3, f4, f5));
		
	}
		
}
