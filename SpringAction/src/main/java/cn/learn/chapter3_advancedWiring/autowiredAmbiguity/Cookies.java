package cn.learn.chapter3_advancedWiring.autowiredAmbiguity;

import cn.learn.chapter3_advancedWiring.autowiredAmbiguity.MyAnnotatioin.Cold;
import cn.learn.chapter3_advancedWiring.autowiredAmbiguity.MyAnnotatioin.Fruity;
import org.springframework.stereotype.Component;

@Component
@Cold
@Fruity
public class Cookies implements Dessert{
}
