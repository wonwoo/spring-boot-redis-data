package me.wonwoo.accounts;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by wonwoo on 2016. 4. 24..
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, String> {

  List<Account> findByname(String name);

  Account findByemail(String email);
}
