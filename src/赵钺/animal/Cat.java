package 赵钺.animal;

import 赵钺.util.WordManage;
/*
 * 动物类的子类，猫类
 */
public class Cat extends Animal{
	private String animalType = "猫";
	private String name = "猫咪";
	private float value_get = 100; 	// 买入价格
	private float value_sell = 200; // 卖出价格
	private int growthValue = 0;	// 默认成长值为0
	private boolean canSell = false;// 能否出售
	
	public Cat(){};
	public Cat(String name){
		this.name = name;
	}
	
	public String eat(){	// 猫吃东西
		System.out.println(this.name + WordManage.eatDescribe + WordManage.catWord);
		grow(this, 8);
		return this.name + WordManage.eatDescribe + WordManage.catWord;
	}
	
	public String drink(){	// 猫喝水
		System.out.println(this.name + WordManage.drinkDescribe + WordManage.catWord);
		grow(this, 4);	// 增加成长值
		return this.name + WordManage.drinkDescribe + WordManage.catWord;
	}
	
	public String play(){	// 猫和主人玩
		System.out.println(this.name + WordManage.playDescribe + WordManage.catWord);
		grow(this, 6);	// 增加成长值
		return this.name + WordManage.playDescribe + WordManage.catWord;
	}
	
	public String wantPlay(){	// 猫想玩
		System.out.println(this.name + "瞪大了眼睛看着你，好像希望你能陪它玩！");
		return this.name + "瞪大了眼睛看着你，好像希望你能陪它玩！";
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
		return "【猫】" + name;
	}
	
}
