package org.ova_api;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner initApp(){
		return args -> {
			//todo

			System.out.println("Creó que funcionó");
			//Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        	//String entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        	//System.out.println ("Entrada recibida por teclado es: \"" + entradaTeclado +"\"");
		};
	}
}
