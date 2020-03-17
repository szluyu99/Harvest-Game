package ����.animal;

import ����.util.WordManage;
/*
 * ����������࣬����
 */
public class Dog extends Animal {
	private String animalType = "��";
	private String name = "С��";
	private float value_get = 60; 	// ����۸�
	private float value_sell = 120; // �����۸�
	private int growthValue = 0;	// Ĭ�ϳɳ�ֵΪ0
	private boolean canSell = false;// �ܷ����

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

	public String eat() {	// �����Զ���
		System.out.println(this.name  + WordManage.eatDescribe + WordManage.dogWord);
		grow(this, 8);	// ���ӳɳ�ֵ
//		checkGrow(this);
		return this.name  + WordManage.eatDescribe + WordManage.dogWord;
	}

	public String drink() {	// ������ˮ
		System.out.println(this.name + WordManage.drinkDescribe + WordManage.dogWord);
		grow(this, 4);	// ���ӳɳ�ֵ
//		checkGrow(this);
		return this.name + WordManage.drinkDescribe + WordManage.dogWord;
	}

	public String play() {	// ������������
		System.out.println(this.name + WordManage.playDescribe + WordManage.dogWord);
		grow(this, 6);	// ���ӳɳ�ֵ
//		checkGrow(this);
		return this.name + WordManage.playDescribe + WordManage.dogWord;
	}
	
	public String wantPlay() {	// ��������
		System.out.println(this.name + "ҡ��β�Ϳ����㣬����ϣ���������棡");
		return this.name + "ҡ��β�Ϳ����㣬����ϣ���������棡";
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
		return "������" + name;
	}
	
}
