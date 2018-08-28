package cn.learn.chapter4_AOP.xmlAOP;

public class CountNum {

  private Integer total = 0;

  public void addNum(int num) {
  }

  public void count(int num) {
    System.out.println(num);
    total = total + num;
  }

  public Integer getTotal() {
    return total;
  }
}
