## Chapter 003 代码的坏味道

### 重复代码

1. 同一个类的两个函数含有相同的表达式

    - Extract Method

1. 两个互为兄弟的子类内含相同表达式

    - Extract Method 将相似部分和差异部分分开构成单独一个函数

    - Template Method 设计模式
    
    - 不同的算法相同的事 - Substitute Algorithme

1. 两个不相干的类出现重复代码

    - Extract Class
    
### 过长函数

1. 每当感觉需要注释来说明点什么的时候 -> 需要说明的写进独立函数 -> 以其用途命名

1. 如何确定该提炼的代码？

    - 寻找注释
    
    - 条件表达式和循环
    
### 过大的类

1. 技巧：先确定客户端如何使用它们，然后为每一种使用方式提炼出一个接口

### 过长参数列

1. 发送请求替代参数

1. 来自相同对象的参数用该对象替代

### 发散式变化

一个类受多种变化影响

针对某一外界变化的所有相应修改，都只应发生在单一类中。

### 霰弹式修改

某种变化，必须在许多不同的类内做出许多小修改

1. 把所有需要修改的代码放进同一类中

### 依恋情结

函数对某个类的兴趣高过对自己所处的类

- 将总是一起变化的东西放在一块儿

### 数据泥团

相同字段，相同参数

- 评判：删除众多数据中的一项看其他数据有没有因而失去意义

### 基本类型偏执

1. 小任务上运用小对象

### switch惊悚现身

1. switch -> 多态

### 平行继承体系

为某个类增加一个子类，必须为另一个类相应增加

1. 让一个继承体系的实例引用另一个继承体系的实例

### 冗赘类

### 夸夸其谈未来性

唯一用途是测试用例

### 令人迷惑的暂时字段

### 过度耦合的消息链

1. 先观察消息链最终得到的对象是用来干什么的

1. 能否把使用该对象的代码提炼到独立函数中

1. 把该函数推入消息链

### 中间人

过度委托

### 狎昵关系

两个类过于亲密

### 异曲同工的类

### 不完美的库类

### 纯稚的数据类

1. 检查是否得到了恰当的封装

2. 将取值调用行为搬移过来

### 被拒绝的遗赠

子类不继承超类

### 过多的注释

1. 提炼函数