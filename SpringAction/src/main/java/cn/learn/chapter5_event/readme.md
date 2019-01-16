1. CookListener 事件监听器  用于保存观察者 监听到事件进行后续处理
2. CookEvent    烧菜事件 
3. OrderDishesPublisher  点菜  用于发布烧菜事件(new CookEvent(Dish))
   发布后 CookListener 就能监听到该事件
   
   
使用场景  举例

用户注册后   
1. 需要赠送新手礼包  
2. 发送确认邮件  
3. 索引用户数据  
这些与用户注册都不是强依赖关系  放到用户注册模块导致耦合  
引入事件监听机制来解耦合
