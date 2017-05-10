package pack;

class PackageDemo 
{
	public static void main(String[] args) 
	{
		packa.DemoA d=new packa.DemoA();
	d.show();
	}
}
/*
E:>javac -d e:\myclass DemoA.java
E:>javac -d e:\myclass PackageDemo.java
错误提示：类DemoA找不到
错误原因：类名写错
因为类名的全称：包名.类名

E:>javac e:\myclass PackageDemo.java

错误2提示：packa软件包不存在
错误原因：在DemoA的目录下没有packa的包，它和DemoA不在同一级的目录下
需要设置class path 告诉jvm去哪里找指定的packa包

set classpath=e:\myclass
E:>javac e:\myclass PackageDemo.java
错误提示3：packaDemo.java在pack中不是公共的，无法从外部软件包中对其访问
DemoA的权限不够大， 改为public,再重新编译DemoA.java文件
E:>javac -d e:\myclass DemoA.java
E:>javac e:\myclass PackageDemo.java

4错误提示：show()在packa.DemoA中不是公共的，无法从外部软件包中对其进行访问
有了包，范围变大， 一个包中的类要被访问，必须要有足够大的权限，所以被访问的类要被public修饰
类共有后，被访问的成员也要被公有
E:>javac -d e:\myclass DemoA.java
E:>javac e:\myclass PackageDemo.java
E:>java pack.PackageDemo

*/
