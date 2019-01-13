刘欣  码农翻身
# 从零开始造Spring(3.2.18)

## 单元测试

**白盒测试**: 开发人员知道程序的代码逻辑[单元测试是白盒测试]

**黑盒测试**: 只知道接口,输入输出,不知道内部结构

**测试框架**: JUnit

![Screenshot_2018-11-27-16-29-28-118_com.google.and](images/Screenshot_2018-11-27-16-29-28-118_com.google.and.png)

![Screenshot_2018-11-27-16-29-09-472_com.google.and](images/Screenshot_2018-11-27-16-29-09-472_com.google.and.png)

![Screenshot_2018-11-27-16-28-53-636_com.google.and](images/Screenshot_2018-11-27-16-28-53-636_com.google.and.png)

`````java
／／对Calculator类的evalute(String string)方法进行测试
／／测试用例的名字一般在测试类后面加Test作为测试类名
`````

````java
public class CalculatorTest{
    @Test
    public void testEvaluate1(){
        Calculator cal = new Calculator();
        int result = cal.evalute("10+20-5");
        Assert.assertEquals(25, result);//期待值:25 ,实际值:result
    }
    
    @Test
    public void testEvaluate2(){
        Calculator cal = new Calculator();
        int result = cal.evalute("(20-1)*5+6/3");
        Assert.assertEquals(52, result);
    }
}
````

>  如果有很多测试用例,总不能一个个手动运行吧, 这就需要一个一次运行N个测试代码的套件: **Suite**

![Screenshot_2018-11-27-16-30-31-646_com.google.and](images/Screenshot_2018-11-27-16-30-31-646_com.google.and.png)



JUnit**断言**

![Screenshot_2018-11-27-16-36-41-882_com.google.and](images/Screenshot_2018-11-27-16-36-41-882_com.google.and.png)



对自己编写的**Exception**进行测试

![Screenshot_2018-11-27-16-37-14-406_com.google.and](images/Screenshot_2018-11-27-16-37-14-406_com.google.and.png)



@Before和@After

setUp()和tearDown()方法名称随便起, 这个名字是JUnit3内部的起名

![Screenshot_2018-11-27-16-38-36-022_com.google.and](images/Screenshot_2018-11-27-16-38-36-022_com.google.and.png)



@BeforeClass和@AfterClass

方法只执行一次

![Screenshot_2018-11-27-16-40-01-417_com.google.and](images/Screenshot_2018-11-27-16-40-01-417_com.google.and.png)



### 单元测试的作用

1. 验证代码
2. 设计代码时考虑可测试性
3. 单元测试是一种精确的文档

> 单元测试是一个团队行为,要互相验证



### 单元测试的原则

1. 测试代码就是代码的一部分,修改代码也要修改测试用例
2. 测试结果不能影响其他测试用例
3. 单元测试不能依赖时间和环境变化(测试在任何人机器都可以执行)
4. 保证测试的简单和可读
5. 面向接口测试
6. 测试要迅速执行(使用Mock对象对数据库和网络的依赖解耦)
7. 自动化测试用例



### Mock对象

![Screenshot_2018-11-27-16-52-04-477_com.google.and](images/Screenshot_2018-11-27-16-52-04-477_com.google.and.png)

![Screenshot_2018-11-28-13-05-49-231_com.google.and](images/Screenshot_2018-11-28-13-05-49-231_com.google.and.png)

![Screenshot_2018-11-28-13-06-29-529_com.google.and](images/Screenshot_2018-11-28-13-06-29-529_com.google.and.png)

##### easy mock

![Screenshot_2018-11-28-13-07-07-427_com.google.and](images/Screenshot_2018-11-28-13-07-07-427_com.google.and.png)

重构遗留代码

![Screenshot_2018-11-28-13-08-45-647_com.google.and](images/Screenshot_2018-11-28-13-08-45-647_com.google.and.png)

![Screenshot_2018-11-28-13-10-21-009_com.google.and](images/Screenshot_2018-11-28-13-10-21-009_com.google.and.png)

![Screenshot_2018-11-28-13-10-36-648_com.google.and](images/Screenshot_2018-11-28-13-10-36-648_com.google.and.png)

![Screenshot_2018-11-28-13-13-40-691_com.google.and](images/Screenshot_2018-11-28-13-13-40-691_com.google.and.png)

![Screenshot_2018-11-28-13-13-06-851_com.google.and](images/Screenshot_2018-11-28-13-13-06-851_com.google.and.png)

![Screenshot_2018-11-28-13-14-31-430_com.google.and](images/Screenshot_2018-11-28-13-14-31-430_com.google.and.png)

![Screenshot_2018-11-28-13-15-15-094_com.google.and](images/Screenshot_2018-11-28-13-15-15-094_com.google.and.png)

![Screenshot_2018-11-28-13-17-27-066_com.google.and](images/Screenshot_2018-11-28-13-17-27-066_com.google.and.png)

**单元测试运行间隔**

 - 一分钟运行一次自己的测试代码
 - 十分钟运行一次别人的测试用例
 - 一小时运行一次项目的测试用例

**使用code coverage(代码覆盖范围)工具**检查测试用例的对代码的覆盖范围

绿色被测试覆盖的代码, 红色未被覆盖

![Screenshot_2018-11-28-13-22-12-351_com.google.and](images/Screenshot_2018-11-28-13-22-12-351_com.google.and.png)




## TDD(Test-Driven Development:测试驱动开发)

![Screenshot_2018-11-28-13-22-59-434_com.google.and](images/Screenshot_2018-11-28-13-22-59-434_com.google.and.png)

### IoC : 控制反转(DI:依赖注入)

![Screenshot_2018-11-28-13-23-30-178_com.google.and](images/Screenshot_2018-11-28-13-23-30-178_com.google.and.png)

![Screenshot_2018-11-28-13-25-10-883_com.google.and](images/Screenshot_2018-11-28-13-25-10-883_com.google.and.png)

### AOP: 切面编程(Spring AOP 是运行时生成(CGLib和JDK)代理类, Aspect J 是编译期生成代理类) 

代码业务之间是正交的, 像 X轴和 Y轴

![Screenshot_2018-11-28-13-26-09-566_com.google.and](images/Screenshot_2018-11-28-13-26-09-566_com.google.and.png)

![Screenshot_2018-11-28-13-27-36-756_com.google.and](images/Screenshot_2018-11-28-13-27-36-756_com.google.and.png)

![Screenshot_2018-11-28-13-28-49-289_com.google.and](images/Screenshot_2018-11-28-13-28-49-289_com.google.and.png)

### 先写测试, 在写代码

![Screenshot_2018-11-29-20-54-32-286_com.google.and](images/Screenshot_2018-11-29-20-54-32-286_com.google.and.png)

![Screenshot_2018-11-29-20-54-54-434_com.google.and](images/Screenshot_2018-11-29-20-54-54-434_com.google.and.png)

![Screenshot_2018-11-29-20-55-09-953_com.google.and](images/Screenshot_2018-11-29-20-55-09-953_com.google.and.png)

