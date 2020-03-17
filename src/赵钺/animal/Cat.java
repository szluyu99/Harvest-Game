package ����.animal;

import ����.util.WordManage;
/*
 * ����������࣬è��
 */
public class Cat extends Animal{
	private String animalType = "è";
	private String name = "è��";
	private float value_get = 100; 	// ����۸�
	private float value_sell = 200; // �����۸�
	private int growthValue = 0;	// Ĭ�ϳɳ�ֵΪ0
	private boolean canSell = false;// �ܷ����
	
	public Cat(){};
	public Cat(String name){
		this.name = name;
	}
	
	public String eat(){	// è�Զ���
		System.out.println(this.name + WordManage.eatDescribe + WordManage.catWord);
		grow(this, 8);
		return this.name + WordManage.eatDescribe + WordManage.catWord;
	}
	
	public String drink(){	// è��ˮ
		System.out.println(this.name + WordManage.drinkDescribe + WordManage.catWord);
		grow(this, 4);	// ���ӳɳ�ֵ
		return this.name + WordManage.drinkDescribe + WordManage.catWord;
	}
	
	public String play(){	// è��������
		System.out.println(this.name + WordManage.playDescribe + WordManage.catWord);
		grow(this, 6);	// ���ӳɳ�ֵ
		return this.name + WordManage.playDescribe + WordManage.catWord;
	}
	
	public String wantPlay(){	// è����
		System.out.println(this.name + "�ɴ����۾������㣬����ϣ�����������棡");
		return this.name + "�ɴ����۾������㣬����ϣ�����������棡";
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
		return "��è��" + name;
	}
	
}
