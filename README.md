# 前言
这已经是帮数媒的同学写的第三份作业了。。。

[第一份：文字小冒险游戏](https://blog.csdn.net/weixin_43734095/article/details/103450742)

[第二份：英汉字典](https://blog.csdn.net/weixin_43734095/article/details/103501029)

# 知识点
老样子，为了帮他们应付作业随便写了点知识点。

1. 利用JavaFx来制作界面，实现了一个牧场游戏的界面，界面优美精良,用到了BorderPane布局。
2. JavaFx的UI组件利用了Button，Label，Image，ImageView，ListView等。
3. JavaFx通过ActionEvent添加了事件，【购买宠物】，【出售宠物】，【喂食宠物】，【宠物喝水】，【宠物喝水】，【陪玩宠物】，【游戏开始】。
4. JavaFx利用Alert类实现了弹框，包括提示类弹框与输入类弹框，利用Result类接收了输入类弹框的结果。
5. 使用了面向对象的方式编程：
（1）构造了AnimalInterface接口，定义了动物类的规范，拥有eat()，drink()，wantPlay()，play（），Grow（），checkGrow（）等公有的抽象方法。
（2）构造了抽象类 Animal 类，实现了AnimalInterface接口，拥有种类（animalType）、名称（name）、买入价值（value_get）、卖出价值（value_sell）、成长值（growthValue）、canSell（能否卖出）属性，拥有吃东西（eat），喝水（drink），和主人玩（play），增加成长值（grow）以及一些get与set的实现了封装性的方法。
（3）定义了Cat类，Dog类，Rabbit类，Tiger类，继承了Animal类，然后具体实现各自的细节，因此程序具有良好的拓展性，想要增加游戏内容只需根据Animal类增添新的动物类即可。
（4）构造了Farmer类，拥有姓名（name）、养的宠物（Animal[] animals）、拥有的宠物数量（animalCount）、拥有金钱（money）属性，拥有和宠物玩（playWithAnimal），买宠物（buyAnimal），卖宠物（sellAnimal），查看状态（showAll）以及一些get与set的实现了封装性的方法。
6. 构造了管理游戏语言描述的类WordManage，在这里用public static final 定义了公有静态常量，游戏中用到时直接调用即可，当要修改游戏内描述时只需要来WordManage类修改即可，十分方便。
7. 利用了Animal类数组存放了Animal的对象，对数组与类着有深刻的理解。
8. 灵活运用了顺序、选择、循环的结构，程序结构清晰，条理明确。
9. 对于程序有良好的注释习惯，程序的可读性十分高。
10. 利用异常处理，对程序数据错误的情况进行了恰当的处理。

# 运行截图
开始运行程序（此时游戏未开始）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222220933814.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)

开始游戏前点击任何功能按键都无效，弹框提示开始游戏。
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019122222095823.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)

点击【游戏开始】，提示输入姓名，创建角色。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222221017849.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)

角色创建成功，初始金钱 200
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222221125675.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)

【购买宠物】，目前可以购买的宠物有【狗】、【猫】、【兔子】、【老虎】、【陆振宇】（最后一个什么鬼，彩蛋~），价格分别为 60，100，150，250，卖出价格则是翻倍，代码有良好的拓展性，所以在定义了规范后增加新的宠物是很简单的。现在，我们买一只猫。
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019122222163092.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)

输入宠物名称【大花】，如果钱足够则购买成功。![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222221655129.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)

钱足够，购买成功。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222221727844.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)

对宠物进行操作需要选中宠物，否则会跳出提示。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222221743255.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)

选中购买的宠物。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222221757941.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222221818211.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222221842218.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222221938848.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)

分别点击【喂食宠物】，【宠物喝水】，【陪玩宠物】，会增加宠物成长值。
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019122222195380.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222221957644.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222222000853.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)

当宠物成长值>=50，则可以出售，赚更多的钱。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222222134306.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)

钱不够则无法购买宠物。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222222154490.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzczNDA5NQ==,size_16,color_FFFFFF,t_70)
