package me.wonwoo;

import me.wonwoo.accounts.Account;
import me.wonwoo.accounts.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import java.util.Arrays;

@SpringBootApplication
@RestController
public class SpringBootRedisDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisDataApplication.class, args);
	}

	@Autowired
	private AccountRepository accountRepository;

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> Arrays.asList(
      new Account("wonwoo","test@test.com"),
      new Account("kevin","kevin@test.com")
    ).forEach(accountRepository::save);
	}

	@PreDestroy
	public void destroy(){
		accountRepository.deleteAll();
	}

	@GetMapping("/{name}")
	public Account getAccont(@PathVariable String name){
		return accountRepository.findByname(name);
	}
}
