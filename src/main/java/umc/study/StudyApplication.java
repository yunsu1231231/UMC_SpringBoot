package umc.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.study.domain.Stores;
import umc.study.service.storeService.StoreQueryService;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class StudyApplication {

	private static final Logger log = LoggerFactory.getLogger(StudyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeQueryService = context.getBean(StoreQueryService.class);

			String name = "요아정";
			Float score = 4.0f;

			log.info("Executing findStoresByNameAndScore with parameters: Name = {}, Score = {}", name, score);

			try {
				List<Stores> stores = storeQueryService.findStoresByNameAndScore(name, score);
				if (stores.isEmpty()) {
					log.info("No stores found for the given parameters.");
				} else {
					stores.forEach(store -> log.info(store.toString()));
				}
			} catch (Exception e) {
				log.error("An error occurred while fetching stores: {}", e.getMessage());
			}
		};
	}
}
