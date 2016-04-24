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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

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
      new Account("wonwoo","kevin@goo.com"),
      new Account("wonwoo","test1@test.com"),
      new Account("kevin","kevin@test.com")
    ).forEach(accountRepository::save);
	}

	@PreDestroy
	public void destroy(){
		accountRepository.deleteAll();
	}

	@GetMapping("/name/{name}")
	public List<Account> findByname(@PathVariable String name){
		return accountRepository.findByname(name);
	}

	@GetMapping("/email")
	public Account findByemail(@RequestParam String email){
		return accountRepository.findByemail(email);
	}
}
