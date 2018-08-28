package cn.learn.chapter3_advancedWiring.autowiredAmbiguity;

import cn.learn.chapter3_advancedWiring.autowiredAmbiguity.MyAnnotatioin.Cold;
import cn.learn.chapter3_advancedWiring.autowiredAmbiguity.MyAnnotatioin.Creamy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
/**
 * @Qualifier("ice")
 * */
@Cold
@Creamy
public class IceCream implements Dessert{
}
