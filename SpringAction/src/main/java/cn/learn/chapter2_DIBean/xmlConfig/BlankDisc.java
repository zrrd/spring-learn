package cn.learn.chapter2_DIBean.xmlConfig;

import cn.learn.chapter2_DIBean.autowired.CompactDisc;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * .
 *
 * @author shaoyijiong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlankDisc implements CompactDisc {

  private String title;
  private String artist;
  private List<String> tracks;


  public BlankDisc(String title, String artist) {
    this.title = title;
    this.artist = artist;
  }

  @Override
  public void play() {
    System.out.println(title + artist);
  }
}
