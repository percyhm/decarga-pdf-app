package bbva.com.descarga_pdf_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"bbva.com.controller"})
public class DescargaPdfBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DescargaPdfBackendApplication.class, args);
	}

}
