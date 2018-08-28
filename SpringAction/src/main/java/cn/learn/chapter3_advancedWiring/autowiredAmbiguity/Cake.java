package cn.learn.chapter3_advancedWiring.autowiredAmbiguity;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Primary首选bean
 *
 * @author shaoyijiong
 */
@Primary
@Component

public class Cake implements Dessert {

}
