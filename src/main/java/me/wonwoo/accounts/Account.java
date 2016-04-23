package me.wonwoo.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * Created by wonwoo on 2016. 4. 24..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("account")
public class Account {

  @Id
  private String id;

  @Indexed
  private String name;

  @Indexed
  private String email;

  public Account(String name, String email){
    this.name = name;
    this.email = email;
  }
}
