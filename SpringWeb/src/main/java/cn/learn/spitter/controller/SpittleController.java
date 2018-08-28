package cn.learn.spitter.controller;


import cn.learn.spitter.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

  @Autowired
  SpittleService spittleService;

  @RequestMapping(method = RequestMethod.GET)
  public String spittles(Model model) {

    // 这里model实际上是一个map，但是这里的addAllAttributes方法没有添加key
    // key会根据对象进行类型推导，因为本例子中，它是一个List<Spittle>
    // key会被推导为 spittleList
    model.addAttribute(spittleService.listSpittles(4, 2));

    //手动指定
    // model.addAllAttributes("spittleList",
    // spittleRepository.findSpittles(Long.MAX_VALUE,20));

    //通过传入Map放到Map的方式 这个就必须有键了
    //Map model
    //model.put("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE,20));

    // 或者不传入model
    // 直接返回数据
    // return spittleRepository.findSpittles(Long.MAX_VALUE,20);
    // 这样做的话 模型的key和第二个一样推导 SpittleList
    // 而试图名根据请求/spittles 试图的名称为 spittle(去掉开头的斜线)

    //总之在这个例子中 上面4种的作用是一样的

    return "spittles";
  }

}
