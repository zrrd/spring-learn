package cn.learn.chapter2_DIBean.xmlConfig;

import cn.learn.chapter2_DIBean.autowired.CompactDisc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CDPlayer {

  private CompactDisc cd;
}
