package ����.player;

import ����.animal.Animal;
/*
 * ũ������
 */
public class Farmer {
	private String name = "����";		
	Animal[] animals = null;	// ���ĳ�����
	// private Animal animal = null;// ���ĳ���
	private int animalCount = 0;	// ӵ�г��������
	private float money = 200;		// ӵ�н�Ǯ
	
	public Farmer(){}
	public Farmer(String name) {
		this.name = name;
	}
	
	public String playWithAnimal(Animal animal){	// ��ĳ��������
		return animal.play();
	}
	
	public String sellAnimal(Animal animal){	// �ѳ�������
		if (animal.isCanSell()) {	// ���������
			System.out.println(this.name + "��" + animal.getName() + "�����ˣ�׬��" + animal.getValue_sell() + "Ԫ��");
			this.animalCount--;	// ��������-1
			for(int i = 0 ; i < animals.length ; i++){	// ���������ˣ�
				if (animals[i].getName().equals(animal.getName())) {
					animals[i] = null;
					break;
				}
			}
			this.money += animal.getValue_sell();
			return this.name + "��" + animal.getName() + "�����ˣ�׬��" + animal.getValue_sell() + "Ԫ��";
		}else {	// ��������
			System.out.println(animal.getName() + "Ŀǰ�ĳɳ�ֵֻ��" + animal.getGrowthValue() + ",����������");
			return animal.getName() + "Ŀǰ�ĳɳ�ֵֻ��" + animal.getGrowthValue() + ",����������";
		}
	}
	
	public boolean canBuy(Animal animal){	// �Ƿ������
		if (this.money >= animal.getValue_get()) {
			return true;
		}else{
			return false;
		}
	}
	public String buyAnimal(Animal animal){	// �������
		if(animals == null){
			animals = new Animal[100];	// ��ʼ������֮·
		}
		
		if (canBuy(animal)) {	// �����
			for (Animal myAnimal : animals) {
				if (myAnimal == null) {	// �����գ�����
					break;
				}
				if (myAnimal == animal) {	// ͬһֻ����
					System.out.println("��ֻ�����Ѿ������ѽ��");
					return "��ֻ�����Ѿ������ѽ��";
				}
				if (myAnimal.getName() == animal.getName() ) {	// ͬ��
					System.out.println("�Ѿ���������ֵĳ����ˣ�");
					return "�Ѿ���������ֵĳ����ˣ�";
				}
			}
			
			System.out.println(this.name + "����һֻ" + animal.getAnimalType() + ",������" + animal.getValue_get() + "Ԫ,ʣ��" + (this.money-animal.getValue_get()) + "Ԫ��");
			this.money -= animal.getValue_get();
			this.animals[animalCount] = animal;	// ���ĳ�������
			this.animalCount++;	// ��������+1
			return this.name + "����һֻ" + animal.getAnimalType() + ",������" + animal.getValue_get() + "Ԫ,ʣ��" + this.money + "Ԫ��";
		}else{	// ����
			System.out.println("�Բ������㣬�޷�����");
			return "�Բ������㣬�޷�����";
		}
	}
	
	public String showAll(){
		System.out.println("********************");
		System.out.println(this.name + "Ŀǰ��" + this.animalCount + "ֻ���");
		System.out.println(this.name + "Ŀǰ��" + this.money + "Ԫ��");
		System.out.println(this.name + "Ŀǰ������Ϣ��");
		if (animals!=null) {
			for (Animal animal : animals) {
				if(animal == null){
					break;
				}
				System.out.println(animal.getName() + "�ĳɳ�ֵΪ" + animal.getGrowthValue() + "��");
			}
		}else {
			System.out.println("Ŀǰû�г��");
		}
		System.out.println("********************");
		
		StringBuilder content = new StringBuilder();
		content.append("****************\n");
		content.append("��" + this.name + "��\n");
		content.append("��������:" + this.animalCount + "ֻ��\n");
		
		content.append("��Ǯ����:" + this.money + "Ԫ��\n");
		content.append("������Ϣ:\n");
		if (animals!=null) {
			for (Animal animal : animals) {
				if(animal == null){
					break;
				}
				content.append(animal.getName() + "�ĳɳ�ֵ��" + animal.getGrowthValue() + "��\n");
			}
		}else {
			content.append("Ŀǰû�г��");
		}
		content.append("****************\n");
		return content+"";
	}
	
	public String feedAnimal(Animal animal){	// ι����
		return animal.eat();
	}
	
	public String giveWater(Animal animal){	// ������ˮ��
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
