package 赵钺.animal;

import 赵钺.util.WordManage;
/*
 * 动物类的子类，狗类
 */
public class Dog extends Animal {
	private String animalType = "狗";
	private String name = "小狗";
	private float value_get = 60; 	// 买入价格
	private float value_sell = 120; // 卖出价格
	private int growthValue = 0;	// 默认成长值为0
	private boolean canSell = false;// 能否出售

	public Dog() {};
	public Dog(String name){
		this.name = name;
	}
	public Dog(String animalType, String name, float value_get, float value_sell) {
		super();
		this.animalType = animalType;
		this.name = name;
		this.value_get = value_get;
		this.value_sell = value_sell;
	}

	public String eat() {	// 狗狗吃东西
		System.out.println(this.name  + WordManage.eatDescribe + WordManage.dogWord);
		grow(this, 8);	// 增加成长值
//		checkGrow(this);
		return this.name  + WordManage.eatDescribe + WordManage.dogWord;
	}

	public String drink() {	// 狗狗喝水
		System.out.println(this.name + WordManage.drinkDescribe + WordManage.dogWord);
		grow(this, 4);	// 增加成长值
//		checkGrow(this);
		return this.name + WordManage.drinkDescribe + WordManage.dogWord;
	}

	public String play() {	// 狗狗和主人玩
		System.out.println(this.name + WordManage.playDescribe + WordManage.dogWord);
		grow(this, 6);	// 增加成长值
//		checkGrow(this);
		return this.name + WordManage.playDescribe + WordManage.dogWord;
	}
	
	public String wantPlay() {	// 狗狗想玩
		System.out.println(this.name + "摇着尾巴看着你，好像希望你陪它玩！");
		return this.name + "摇着尾巴看着你，好像希望你陪它玩！";
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
	public int getGrowthValue() {
		return growthValue;
	}
	public void setGrowthValue(int growthValue) {
		this.growthValue = growthValue;
	}
	public boolean isCanSell() {
		return canSell;
	}
	public void setCanSell(boolean canSell) {
		this.canSell = canSell;
	}
	@Override
	public String toString() {
		return "【狗】" + name;
	}
	
}
