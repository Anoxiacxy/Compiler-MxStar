>  Peter: 随着129歌会的结束，本年度的所有活动已经暂告一段落了，那么大家的编译器怎么样了呢？

### Get Start

提交你的compiler repo的git链接（public）

Git 仓库：https://github.com/Anoxiacxy/Compiler-MxStar

### g4 Grammar

如果你要使用antlr4，在你的Compiler repo中添加对应的`g4`文件，并给出其路径

1. 给出你定义的语法如何Parse下述两个statement（即只需要给出以statement为root的subtree）：
   1. `a = 1;`
   
      ![截屏2020-12-17 下午11.35.16](/Users/anoxiacxy/Desktop/截屏2020-12-17 下午11.35.16.png)
   
   2. `b = ++++a++ + 1;`
   
		![截屏2020-12-17 下午11.36.08](/Users/anoxiacxy/Desktop/截屏2020-12-17 下午11.36.08.png)
	
2. 在g4中如何区别`a++`/`a--`和`++a`/`--a`；

   在我的 g4 中，`a++/a--` 使用 `succExpression` 节点来表示`++a/--a` 使用 `prefExpression` 节点来表示。

3. 对于以下三种文法，其生成的Antlr代码的`AContext.b()`的返回类型是？
   1. `a: b`

      BContext

   2. `a: b*`

      List\<BContext\>

   3. `a: b C b`

      BContext

### AST Node
1. 描述以下代码的AST节点结构：
``````
if (x == 2){
	while(x != 3){
		x = x + 1;
		break;
	}
	continue;
}
``````
![截屏2020-12-17 下午11.34.04](/Users/anoxiacxy/Desktop/截屏2020-12-17 下午11.34.04.png)

If 节点 ：If + '(' + condition + ')' + statement + （ Else + statement ）？

While 节点 ：While + '(' + condition + ')' + statement 

其中在If 中含有一个 whileStatement 和 continueStatement

在 While 中含有一个 expressionStatement 和 breakStatement

2. 简述 `Statement`和`Expression` 的设计关系

   Expression 是表达式 Statement 基本是程序语句。我们在程序语句中定义了一种名为表达式语句的东西，也就是 expressionStatement，将任意一个表达式添加上分号即可变成一个语句。表达式都是有值的，是用于构成语句的基本单元之一。