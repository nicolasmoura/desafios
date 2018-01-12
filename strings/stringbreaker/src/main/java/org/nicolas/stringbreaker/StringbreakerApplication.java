package org.nicolas.stringbreaker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StringbreakerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StringbreakerApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {

    }
}
