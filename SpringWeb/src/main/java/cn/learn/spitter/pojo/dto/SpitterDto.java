package cn.learn.spitter.pojo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @author syj
 */
@Data
public class SpitterDto {

  private Integer id;

  /**
   * 加了{}后引用的是配置文件里面的错误信息
   */

  @NotNull
  @Size(min = 2, max = 30, message = "{firstName.size}")
  private String firstName;

  @NotNull
  @Size(min = 2, max = 30, message = "{lastName.size}")
  private String lastName;

  @NotNull
  @Size(min = 5, max = 16, message = "{username.size}")
  private String username;

  @NotNull
  @Size(min = 5, max = 25, message = "{password.size}")
  private String password;
}
