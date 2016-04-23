package me.wonwoo.accounts;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wonwoo on 2016. 4. 24..
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, String> {

  Account findByname(String name);
}
