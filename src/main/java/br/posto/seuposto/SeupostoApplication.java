package br.posto.seuposto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication(scanBasePackages = "br.posto.seuposto")
@EntityScan("br.posto.seuposto.model.entity")
@EnableJpaRepositories("br.posto.seuposto.repository")
// @EnableMongoRepositories("br.dsp.projeto.DAO.mongo")
public class SeupostoApplication implements CommandLineRunner {

	public static void main(String[] args) {
	 	SpringApplicationBuilder builder = new SpringApplicationBuilder(SeupostoApplication.class);
		builder.headless(false).run(args);
	}

	@Override
	public void run(String... args){
		log.info("OK");
	}
}
