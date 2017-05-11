package entity;

public class EnumTest1{
	public static void main(String[] args) {
		//case1：不重写toString方法，打印Red
		//case2:重新toString方法 打印Color.Red
		System.out.println(Color1.Red);
		//Color1.Purple
		System.out.println(Color1.Purple);
		//魅力紫
		System.out.println(Color1.Purple.getDesc());
		
		System.out.println(Color1.Green);
		//valueOf和toString方法对应
		Color1 c1 = Color1.valueOf("Green");
		System.out.println(c1.name());//Green
		System.out.println(c1.Blue);//Color.Blue warn!!!
		//返回枚举值在枚举类种的顺序 从0开始
		System.out.println(c1.ordinal());
		System.out.println("*********");
		//遍历所有的枚举值
		for(Color1 c:Color1.values()){
			System.out.println(c.toString());
		}
	}
	public enum Color1 {
		 //1不带任何参数
		 Red,
		 Blue,
		 Green{
			 //可以为每一个枚举值定义方法
			 public String toString(){
				 //System.out.println("我是绿色");
				 return "我是绿色";
			 }
		 },
		 Purple("魅力紫");
		 //构造函数只能是private,客户代码不能new一个枚举值的实例出来
		 //有几个枚举值，这个空构造方法就要调用几次
		 private Color1(){
			 System.out.println("Color1空构造函数");
		 }
		 //增加描述信息
		 private String desc;
		 //可以像普通类一样定义变量和方法
		 public static String t;
		 private Color1(String desc){
			 System.out.println("Color带有描述的构造函数");
			 this.desc=desc;
		 }
		 
		 public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		//覆写了toString方法
		 public String toString(){
			 switch(this){
			 case Red:return "Color.Red";
			 case Blue:return "Color.Blue";
			 case Green:return "Color.Green";
			 case Purple:return "Color.Purple";
			 default:return "unknown color";
			 }
		 }
		}
	
}

