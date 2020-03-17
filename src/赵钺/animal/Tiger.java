package ����.animal;

import ����.util.WordManage;
/*
 * ����������࣬�ϻ���
 */
public class Tiger extends Animal{
	private String animalType = "�ϻ�";
	private String name = "���ϻ�";
	private float value_get = 250; 	// ����۸�
	private float value_sell = 500; // �����۸�
	private int growthValue = 0;	// Ĭ�ϳɳ�ֵΪ0
	private boolean canSell = false;// �ܷ����

	public Tiger() {};
	public Tiger(String name){
		this.name = name;
	}

	public String eat() {	// �ϻ��Զ���
		System.out.println(this.name  + WordManage.eatDescribe + WordManage.tigerWord);
		grow(this, 8);	// ���ӳɳ�ֵ
		return this.name  + WordManage.eatDescribe + WordManage.tigerWord;
	}

	public String drink() {	// ���Ӻ�ˮ
		System.out.println(this.name + WordManage.drinkDescribe + WordManage.tigerWord);
		grow(this, 4);	// ���ӳɳ�ֵ
		return this.name + WordManage.drinkDescribe + WordManage.tigerWord;
	}

	public String play() {	// ���Ӻ�������
		System.out.println(this.name + WordManage.playDescribe + WordManage.tigerWord);
		grow(this, 6);	// ���ӳɳ�ֵ
		return this.name + WordManage.playDescribe + WordManage.tigerWord;
	}
	
	public String wantPlay() {	// ��������
		System.out.println(this.name + "�������ϵĶ����㿴������ϣ���������棨Ӧ�ò���������㣩��");
		return this.name + "�������ϵĶ����㿴������ϣ���������棨Ӧ�ò���������㣩��";
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
		return "���ϻ���" + name;
	}

}
