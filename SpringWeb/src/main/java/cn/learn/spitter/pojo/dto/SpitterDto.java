package cn.learn.spitter.pojo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SpitterDto {
    private Integer id;

    /**
     * 加了{}后引用的是配置文件里面的错误信息
     * */

    @NotNull
    @Size(min = 2,max = 30 ,message = "{firstName.size}")
    private String firstName;

    @NotNull
    @Size(min = 2,max = 30,message = "{lastName.size}")
    private String lastName;

    @NotNull
    @Size(min = 5,max = 16,message = "{username.size}")
    private String username;

    @NotNull
    @Size(min = 5,max = 25,message = "{password.size}")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
