package 赵钺.animal;

import 赵钺.util.WordManage;
/*
 * 动物类的子类，兔子类
 */
public class Rabbit extends Animal{
	private String animalType = "兔子";
	private String name = "小白兔";
	private float value_get = 150; 	// 买入价格
	private float value_sell = 300; // 卖出价格
	private int growthValue = 0;	// 默认成长值为0
	private boolean canSell = false;// 能否出售

	public Rabbit() {};
	public Rabbit(String name){
		this.name = name;
	}

	public String eat() {	// 兔子吃东西
		System.out.println(this.name  + WordManage.eatDescribe + WordManage.rabbitWord);
		grow(this, 8);	// 增加成长值
		return this.name  + WordManage.eatDescribe + WordManage.rabbitWord;
	}

	public String drink() {	// 兔子喝水
		System.out.println(this.name + WordManage.drinkDescribe + WordManage.rabbitWord);
		grow(this, 4);	// 增加成长值
		return this.name + WordManage.drinkDescribe + WordManage.rabbitWord;
	}

	public String play() {	// 兔子和主人玩
		System.out.println(this.name + WordManage.playDescribe + WordManage.rabbitWord);
		grow(this, 6);	// 增加成长值
		return this.name + WordManage.playDescribe + WordManage.rabbitWord;
	}
	
	public String wantPlay() {	// 兔子想玩
		System.out.println(this.name + "在你周围蹦来蹦去，好像希望你陪它玩！");
		return this.name + "在你周围蹦来蹦去，好像希望你陪它玩！";
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
		return "【兔子】" + name;
	}

}