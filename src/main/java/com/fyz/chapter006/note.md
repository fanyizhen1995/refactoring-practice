
## Chapter 006 重新组织函数

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [Chapter 006 重新组织函数](#chapter-006-%E9%87%8D%E6%96%B0%E7%BB%84%E7%BB%87%E5%87%BD%E6%95%B0)
  - [Extract Method](#extract-method)
    - [做法](#%E5%81%9A%E6%B3%95)
  - [Inline Method](#inline-method)
    - [做法](#%E5%81%9A%E6%B3%95-1)
  - [Inline Temp](#inline-temp)
    - [做法](#%E5%81%9A%E6%B3%95-2)
  - [Replace temp with Query](#replace-temp-with-query)
    - [做法](#%E5%81%9A%E6%B3%95-3)
  - [Introduce Explaining Variable](#introduce-explaining-variable)
    - [做法](#%E5%81%9A%E6%B3%95-4)
  - [Split Temporary Variable](#split-temporary-variable)
    - [做法](#%E5%81%9A%E6%B3%95-5)
  - [Remove Assignments to Parameters](#remove-assignments-to-parameters)
    - [做法](#%E5%81%9A%E6%B3%95-6)
  - [Replace Method with Method object](#replace-method-with-method-object)
    - [做法](#%E5%81%9A%E6%B3%95-7)
  - [Substitute Algorithm](#substitute-algorithm)
    - [做法](#%E5%81%9A%E6%B3%95-8)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->


### Extract Method

- 过长函数、需要注释的代码，放进独立函数中

#### 做法

1. 创造一个新函数，根据这个函数的意图来命名（做什么）

1. 提炼出来的代码从原函数复制到新建的目标函数

1. 检查源代码，看是否有作用域限于源函数的变量（局部变量和源函数参数）

1. 看是否有代码段里的临时变量，有就在目标函数里声明为临时变量

1. 看是否有任何局部代码被它改变，如果有，看是否能提取为一个查询，并将结果赋值给相关变量

1. 需要读取的局部变量，当作参数传给目标函数

1. 处理完所有局部变量后编译

1. 源函数中，将被提炼代码段替换为对目标函数的调用

1. 编译测试


- 要点

    1. 局部变量
    
### Inline Method

内联两个函数

- 该函数内部代码和函数名一样清晰，消除这个函数

- 组织不合理的一群函数，内联到一个大函数，重新组织

#### 做法

1. 检查函数确定不具备多态性

1. 找出这个函数所有的被调用点

1. 替换成函数本体

1. 编译测试

1. 删除函数定义


### Inline Temp

- 只赋值了一次的临时变量，将其替换为对它赋值的表达式本身

#### 做法

1. 检查赋值语句，确保等号右边无副作用

1. 将临时变量声明为final，编译测试是否真的只赋值了一次

1. 找到临时变量的所有引用点，进行替换

1. 每次修改完，编译测试

1. 修改完所有引用点，删除变量

1. 编译测试

### Replace temp with Query

表达式提炼到一个独立函数中，将这个变量的所有临时引用替换为对新韩淑的调用，此后新韩淑可被其他函数使用。

#### 做法

1. 找出只被赋值一次的临时变量

1. 声明为final

1. 编译

1. 对临时变量的赋值提炼到一个独立函数

    - 首先将函数声明为private便于日后有需求再放开

1. 编译测试

1. 临时变量使用 Inline Temp

### Introduce Explaining Variable

- 将复杂表达式的结果放进一个临时变量，以此变量名称来解释表达式用途

#### 做法

1. 声明一个 final 临时变量，将待分解复杂表达式的一部分的结果赋值给他

1. 将表达式中运算结果这一部分替换为临时变量

1. 编译测试

1. 重复替换

### Split Temporary Variable

某一临时变量被赋值超过一个，每个变量应只承担一个责任

- 针对每次赋值，创造一个独立、对应的临时变量

- 不要分解循环变量和结果收集变量

#### 做法

1. 待分解临时变量的声明及其第一次被赋值处，修改名称

1. 新临时变量声明为 final

1. 该临时变量的第二次赋值动作为界，修改此前对该临时变量的所有引用为新的临时变量

1. 编译测试

1. 重复上述过程

### Remove Assignments to Parameters

- 代码对一个参数赋值时，以一个临时变量替代参数的位置。

#### 做法

1. 建立一个临时变量，将待处理参数值赋给它

1. 替换原引用

1. 修改原赋值语句

1. 编译测试

### Replace Method with Method object

- 大型函数，无法采用 Exteact Method。

- 将函数放进单独对象中，局部变量就成为了对象内字段

#### 做法

1. 建立一个新类，根据待处理函数用途来命名

1. 声明一个final字段保存原对象，针对源函数每个临时变量和参数，建一个对应字段保存

1. 新类中建立一个构造函数，接受源对象和原函数的所有参数为参数

1. 新类中建立一个 compute() 函数

1. 原函数代码复制到 compute() 函数中

1. 编译

1. 将旧函数的函数本体替换成：创建上述新类的一个新对象，而后调用其中的 compute() 函数

### Substitute Algorithm

- 将函数本体替换为另一个算法

#### 做法

1. 准备好另一个算法，让他通过编译

1. 针对现有测试执行新算法，若结果相同，重构结束

1. 若不同，以原来的为准

