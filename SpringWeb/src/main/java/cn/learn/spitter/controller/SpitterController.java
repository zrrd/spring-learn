package cn.learn.spitter.controller;


import cn.learn.spitter.pojo.dto.SpitterDto;
import cn.learn.spitter.pojo.po.Spitter;
import cn.learn.spitter.service.SpitterService;
import java.io.File;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * .
 * @author shaoyijong
 */

@Controller
@RequestMapping("/spitter")
public class SpitterController {

  @Autowired
  SpitterService spitterService;


  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String showRegistrationForm() {
    return "registerForm";
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String processRegisteration(@Valid SpitterDto spitterDto, Errors errors) {
    /**
     * 校验表单SpitterDto  errors是否校验成功
     * */
    if (errors.hasErrors()) {
      return "registerForm";
    }
    Spitter spitter = new Spitter();
    BeanUtils.copyProperties(spitterDto, spitter);
    spitterService.saveSpitter(spitter);
    return "redirect:/spitter/" + spitter.getUsername();
  }

  /**
   * 通过路径接受参数
   */
  @RequestMapping(value = "/{username}", method = RequestMethod.GET)
  public String userHome(@PathVariable("username") String username, Model model) {
    model.addAttribute(spitterService.getSpitterByUsername(username));
    return "/userhome";
  }

  /**
   * 下面是web试图渲染的内容
   * */

  /**
   * 为了让Spring标签绑定一个模型对象，需要在模型中有一个对象，key和commandName对应.
   */
  @RequestMapping(value = "/register2", method = RequestMethod.GET)
  public String showRegistrationForm2(Model model) {
    SpitterDto spitter = new SpitterDto();
    spitter.setFirstName("f");
    model.addAttribute(spitter);
    return "registerForm2";
  }

  @RequestMapping(value = "/register2", method = RequestMethod.POST)
  public String processRegisteration2(@Valid SpitterDto spitterDto, Errors errors) {
    if (errors.hasErrors()) {
      //验证失败 返回registerForm2 表单内的数据保持不变
      return "registerForm2";
    }
    Spitter spitter = new Spitter();
    BeanUtils.copyProperties(spitterDto, spitter);
    spitterService.saveSpitter(spitter);
    return "redirect:/spitter/" + spitter.getUsername();
  }

  @RequestMapping(value = "/springJsp", method = RequestMethod.GET)
  public String springJsp() {
    return "/springJsp";
  }


  @RequestMapping(value = "/uploadImage", method = RequestMethod.GET)
  public String upload() {
    return "/uploadImage";
  }

  /**
   * 通过字节流拿到 只能获得东西，其它信息拿不到.
   */
  @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
  public String upload(@RequestPart("profilePicture") byte[] profilePicture) {

/*         接受到文件后会存到MultipartConfigElement所定义目录下
         名字为upload_0ca564de_4c0a_4827_b87f_a24dc6a73f29_00000000.tmp*/

    return null;
  }

  /**
   * 通过MultipartFile来接受上传的文件，能拿到更多的信息
   */
  @RequestMapping(value = "/uploadImage2", method = RequestMethod.POST)
  public String upload(@RequestParam("profilePicture") MultipartFile file) {
    if (!file.isEmpty()) {
      /*获得原始文件名*/
      String fileName = file.getOriginalFilename();
      /*重命名文件*/
      String newFileName = System.currentTimeMillis() + String.valueOf(fileName);
      try {
        /*将上传的文件写入文件系统中去*/
        file.transferTo(new File("E:\\tmp\\images\\" + newFileName));
        System.out.println("图片保存成功");
      } catch (IOException e) {
        System.out.println("文件保存异常");
        e.printStackTrace();
      }
    }
    return null;
  }

  /**
   * 错误测试
   */
  @RequestMapping(value = "errorTest", method = RequestMethod.GET)
  public String errorTest() {
    throw new RuntimeException("aaa");
  }

  /**
   * 将这个类的所有Exception由这个方法处理
   */
  @ExceptionHandler(Exception.class)
  public String exceptionHandler() {
    return "error/myerror";
  }

  /**
   * 给重定向请求添加参数
   */
  @RequestMapping(value = "/register3", method = RequestMethod.POST)
  public String processRegisteration3(@Valid SpitterDto spitterDto, Errors errors, Model model) {
    if (errors.hasErrors()) {
      return "registerForm2";
    }
    Spitter spitter = new Spitter();
    BeanUtils.copyProperties(spitterDto, spitter);
    spitterService.saveSpitter(spitter);

    //在model中添加参数 {username}占位符，model中的属性自动放入
    model.addAttribute("username", spitter.getUsername());
    //没有站位符，自动添加参数 /spitter/tom?firstName=thefirstName
    model.addAttribute("firstName", spitter.getFirstName());
    return "redirect:/spitter/{username}";
  }

  /**
   * 给重定向请求添加参数2
   */
  @RequestMapping(value = "/register3", method = RequestMethod.POST)
  public String processRegisteration3(@Valid SpitterDto spitterDto, Errors errors,
      RedirectAttributes model) {
    if (errors.hasErrors()) {
      return "registerForm2";
    }
    Spitter spitter = new Spitter();
    BeanUtils.copyProperties(spitterDto, spitter);
    spitterService.saveSpitter(spitter);
    //在model中添加参数 {username}占位符，model中的属性自动放入
    model.addAttribute("username", spitter.getUsername());

    //重定向执行之前 将所有的flash属性放入会话中session 在重定向后存在会话的flash属性会被取出放入model
    model.addFlashAttribute(spitter);
    return "redirect:/spitter/{username}";
  }

}
