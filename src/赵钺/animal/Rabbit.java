package ����.animal;

import ����.util.WordManage;
/*
 * ����������࣬������
 */
public class Rabbit extends Animal{
	private String animalType = "����";
	private String name = "С����";
	private float value_get = 150; 	// ����۸�
	private float value_sell = 300; // �����۸�
	private int growthValue = 0;	// Ĭ�ϳɳ�ֵΪ0
	private boolean canSell = false;// �ܷ����

	public Rabbit() {};
	public Rabbit(String name){
		this.name = name;
	}

	public String eat() {	// ���ӳԶ���
		System.out.println(this.name  + WordManage.eatDescribe + WordManage.rabbitWord);
		grow(this, 8);	// ���ӳɳ�ֵ
		return this.name  + WordManage.eatDescribe + WordManage.rabbitWord;
	}

	public String drink() {	// ���Ӻ�ˮ
		System.out.println(this.name + WordManage.drinkDescribe + WordManage.rabbitWord);
		grow(this, 4);	// ���ӳɳ�ֵ
		return this.name + WordManage.drinkDescribe + WordManage.rabbitWord;
	}

	public String play() {	// ���Ӻ�������
		System.out.println(this.name + WordManage.playDescribe + WordManage.rabbitWord);
		grow(this, 6);	// ���ӳɳ�ֵ
		return this.name + WordManage.playDescribe + WordManage.rabbitWord;
	}
	
	public String wantPlay() {	// ��������
		System.out.println(this.name + "������Χ������ȥ������ϣ���������棡");
		return this.name + "������Χ������ȥ������ϣ���������棡";
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
		return "�����ӡ�" + name;
	}

}