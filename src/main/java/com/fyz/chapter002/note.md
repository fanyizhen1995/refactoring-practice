## Chapter 002 重构原则

1. 重构不改变软件可观察行为

1. 两顶帽子：添加新功能、重构

    - 添加新功能：添加新功能，添加测试，通过测试
    
    - 重构：不添加功能，不添加测试，改变结构，通过测试
    
    - 两顶帽子轮流戴，不能混在一起。
    
 1. 改进的重要方向是消除重复代码
 
 1. 何时重构？
 
    - 三次法则
    
    - 添加功能时重构
    
    - 修补错误时重构
    
    - 复审代码时重构
    
 1. 重构 -> 添加间接层
    
    - 找出一个缺乏间接层利益之处，加入一个间接层
    
 1. 修改已发布接口？
    
    - 旧接口调用新接口，不要复制函数实现，旧接口标记为deprecated
    
    - 尽量少发布接口
    
 1. 难以通过重构完成的设计改动
 
    - 先寻找简单的重构方法
    
 1. 何时不该重构？
 
    - 重写，现有代码不能正常运作
    
    - deadline快到了，避免重构