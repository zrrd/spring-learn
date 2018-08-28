package cn.learn.spitter.pojo.po;

import java.util.Date;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * .
 * @author shaoyijong
 */
@Data
@Component
public class Spittle {

  private Long id;
  /**
   * 消息.
   */
  private String message;
  /**
   * 时间戳.
   */
  private Date time;
  /**
   * 经纬度.
   */
  private Double latitude;
  private Double longitude;


  public Spittle(String message, Date time) {
    this(message, time, null, null);
  }

  public Spittle(String message, Date time, Double longitude, Double latitude) {
    this.id = null;
    this.message = message;
    this.time = time;
    this.longitude = longitude;
    this.latitude = latitude;
  }
}
