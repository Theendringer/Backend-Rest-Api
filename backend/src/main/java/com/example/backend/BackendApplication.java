package com.example.backend;




import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackendApplication {


 public static void main(String[] args) {
  SpringApplication.run(BackendApplication.class, args);
 }


 /*
objeto gerenciado pelo Spring que adiciona informações à documentação
  */
 @Bean
 public OpenAPI customOpenAPI() {
  return new OpenAPI()
          .info(new Info()
                  .title("Servidor KDS")
                  .version("1.0.0")
                  .contact(new Contact().email("salesinano@souunisales").name("Grupo KDS"))
                  .description("Teste api rest kds")
          );


 }
}

