package 赵钺.animal;

/*
 * 动物抽象类，实现动物接口
 */
public abstract class Animal implements AnimalInterface {
	String animalType;	// 种类
	String name;		// 名称
	float value_get = 100;	// 买入价值
	float value_sell = 80;	// 卖出价值
	boolean canSell = false; // 能否卖出，默认不能卖出
	/*
	 *  成长值，当成长值 >= 50,可以售卖
	 *  初始成长值为 1 
	 *  每次陪它玩，成长值 + 6
	 *  吃东西，成长值 + 8
	 *  喝水，成长值 + 4
	 */
	int growthValue = 0;
	
	public String eat() {		// 吃东西
		System.out.println(this.name  + "吃了点东西，吃的好饱呀！");
		grow(8);	// 增加成长值
		return this.name  + "吃了点东西，吃的好饱呀！（成长值+8）";
	};
	public String drink(){		// 喝水
		System.out.println(this.name + "喝了点水，一点也不可渴了！");
		grow(4);	// 增加成长值
		return this.name + "喝了点水，一点也不可渴了！";
	};
	public String play(){		// 和主人玩
		System.out.println(this.name + "和你玩了一会儿，看起来十分开心！");
		grow(6);	// 增加成长值
		return this.name + "和你玩了一会儿，看起来十分开心！";
	}
	public String wantPlay(){	// 想要玩
		System.out.println(this.name + "看着你，似乎想要你和它玩。");
		return this.name + "看着你，似乎想要你和它玩。";
	}
	/*
	 * grow(Animal animal, int value) 为优化后的代码，更好的利用了继承
	 * grow(int value) 可以不需要了
	 */
	public static String grow(Animal animal, int value){	// 增加成长值
		animal.setGrowthValue(animal.getGrowthValue() + value);
		System.out.println(animal.getName() +"的成长值增加了" + value);
		checkGrow(animal);
		return animal.getName() +"的成长值增加了" + value;
	}
	public String grow(int value){	// 增加成长值
		this.growthValue += value;
		System.out.println(this.name + "的成长值加了" + value);
		return this.name + "的成长值加了" + value;	// 增加成长值
	}
	/*
	 * checkGrow(Animal animal) 为优化后的代码，更好的利用继承
	 * checkGrow() 可以不需要了
	 */
	static int checkGrow(Animal animal){	// 检测成长值
		if (!animal.isCanSell()) {
			if (animal.getGrowthValue() >= 50) {
				animal.setCanSell(true);
				System.out.println("@@@这只动物已经可以卖掉啦！@@@");
				return animal.getGrowthValue();
			}else{
				return animal.getGrowthValue();
			}
		}
		return animal.getGrowthValue();
	}
	public int checkGrow(){	// 每回合检测成长值
		if (!canSell) {	// 不能卖出时检测，可以卖了则不用检测
			if (this.growthValue >= 50) {
				canSell = true; // 此时可以卖出了。
				System.out.println("这只动物已经可以卖掉啦！");
				return this.growthValue;
			}else{
				return this.growthValue;
			}
		}
		return growthValue;
	}
	
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getValue_get() {
		return value_get;
	}
	public void setValue_get(float value_get) {
		this.value_get = value_get;
	}
	public float getValue_sell() {
		return value_sell;
	}
	public void setValue_sell(float value_sell) {
		this.value_sell = value_sell;
	}
	public boolean isCanSell() {
		return canSell;
	}
	public void setCanSell(boolean canSell) {
		this.canSell = canSell;
	}
	public int getGrowthValue() {
		return growthValue;
	}
	public void setGrowthValue(int growthValue) {
		this.growthValue = growthValue;
	}
}
