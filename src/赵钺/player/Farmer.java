package 赵钺.player;

import 赵钺.animal.Animal;
/*
 * 农场主类
 */
public class Farmer {
	private String name = "主人";		
	Animal[] animals = null;	// 养的宠物们
	// private Animal animal = null;// 养的宠物
	private int animalCount = 0;	// 拥有宠物的数量
	private float money = 200;		// 拥有金钱
	
	public Farmer(){}
	public Farmer(String name) {
		this.name = name;
	}
	
	public String playWithAnimal(Animal animal){	// 和某个宠物玩
		return animal.play();
	}
	
	public String sellAnimal(Animal animal){	// 把宠物卖了
		if (animal.isCanSell()) {	// 如果可以卖
			System.out.println(this.name + "把" + animal.getName() + "卖掉了，赚了" + animal.getValue_sell() + "元！");
			this.animalCount--;	// 宠物数量-1
			for(int i = 0 ; i < animals.length ; i++){	// 宠物卖掉了！
				if (animals[i].getName().equals(animal.getName())) {
					animals[i] = null;
					break;
				}
			}
			this.money += animal.getValue_sell();
			return this.name + "把" + animal.getName() + "卖掉了，赚了" + animal.getValue_sell() + "元！";
		}else {	// 还不能卖
			System.out.println(animal.getName() + "目前的成长值只有" + animal.getGrowthValue() + ",还不能卖！");
			return animal.getName() + "目前的成长值只有" + animal.getGrowthValue() + ",还不能卖！";
		}
	}
	
	public boolean canBuy(Animal animal){	// 是否买得起
		if (this.money >= animal.getValue_get()) {
			return true;
		}else{
			return false;
		}
	}
	public String buyAnimal(Animal animal){	// 购买宠物
		if(animals == null){
			animals = new Animal[100];	// 开始养宠物之路
		}
		
		if (canBuy(animal)) {	// 买得起
			for (Animal myAnimal : animals) {
				if (myAnimal == null) {	// 遇到空，跳出
					break;
				}
				if (myAnimal == animal) {	// 同一只宠物
					System.out.println("这只宠物已经买过了呀！");
					return "这只宠物已经买过了呀！";
				}
				if (myAnimal.getName() == animal.getName() ) {	// 同名
					System.out.println("已经有这个名字的宠物了！");
					return "已经有这个名字的宠物了！";
				}
			}
			
			System.out.println(this.name + "买了一只" + animal.getAnimalType() + ",花费了" + animal.getValue_get() + "元,剩余" + (this.money-animal.getValue_get()) + "元。");
			this.money -= animal.getValue_get();
			this.animals[animalCount] = animal;	// 养的宠物增加
			this.animalCount++;	// 宠物数量+1
			return this.name + "买了一只" + animal.getAnimalType() + ",花费了" + animal.getValue_get() + "元,剩余" + this.money + "元。";
		}else{	// 买不起
			System.out.println("对不起，余额不足，无法购买！");
			return "对不起，余额不足，无法购买！";
		}
	}
	
	public String showAll(){
		System.out.println("********************");
		System.out.println(this.name + "目前有" + this.animalCount + "只宠物。");
		System.out.println(this.name + "目前有" + this.money + "元。");
		System.out.println(this.name + "目前宠物信息：");
		if (animals!=null) {
			for (Animal animal : animals) {
				if(animal == null){
					break;
				}
				System.out.println(animal.getName() + "的成长值为" + animal.getGrowthValue() + "。");
			}
		}else {
			System.out.println("目前没有宠物！");
		}
		System.out.println("********************");
		
		StringBuilder content = new StringBuilder();
		content.append("****************\n");
		content.append("【" + this.name + "】\n");
		content.append("宠物数量:" + this.animalCount + "只。\n");
		
		content.append("金钱数量:" + this.money + "元。\n");
		content.append("宠物信息:\n");
		if (animals!=null) {
			for (Animal animal : animals) {
				if(animal == null){
					break;
				}
				content.append(animal.getName() + "的成长值：" + animal.getGrowthValue() + "。\n");
			}
		}else {
			content.append("目前没有宠物！");
		}
		content.append("****************\n");
		return content+"";
	}
	
	public String feedAnimal(Animal animal){	// 喂宠物
		return animal.eat();
	}
	
	public String giveWater(Animal animal){	// 给动物水喝
		return animal.drink();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Animal[] getAnimals() {
		return animals;
	}
	public void setAnimals(Animal[] animals) {
		this.animals = animals;
	}
	public int getAnimalCount() {
		return animalCount;
	}
	public void setAnimalCount(int animalCount) {
		this.animalCount = animalCount;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	
}
