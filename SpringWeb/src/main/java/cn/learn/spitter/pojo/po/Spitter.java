package cn.learn.spitter.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spitter {

  private Integer id;
  private String firstName;
  private String lastName;
  private String username;
  private String password;
}
