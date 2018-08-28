package cn.learn.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * .
 *
 * @author syj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String username;
  private String password;
  private String name;
}
