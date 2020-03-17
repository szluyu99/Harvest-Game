package ����.animal;

/*
 * ��������࣬ʵ�ֶ���ӿ�
 */
public abstract class Animal implements AnimalInterface {
	String animalType;	// ����
	String name;		// ����
	float value_get = 100;	// �����ֵ
	float value_sell = 80;	// ������ֵ
	boolean canSell = false; // �ܷ�������Ĭ�ϲ�������
	/*
	 *  �ɳ�ֵ�����ɳ�ֵ >= 50,��������
	 *  ��ʼ�ɳ�ֵΪ 1 
	 *  ÿ�������棬�ɳ�ֵ + 6
	 *  �Զ������ɳ�ֵ + 8
	 *  ��ˮ���ɳ�ֵ + 4
	 */
	int growthValue = 0;
	
	public String eat() {		// �Զ���
		System.out.println(this.name  + "���˵㶫�����Եĺñ�ѽ��");
		grow(8);	// ���ӳɳ�ֵ
		return this.name  + "���˵㶫�����Եĺñ�ѽ�����ɳ�ֵ+8��";
	};
	public String drink(){		// ��ˮ
		System.out.println(this.name + "���˵�ˮ��һ��Ҳ���ɿ��ˣ�");
		grow(4);	// ���ӳɳ�ֵ
		return this.name + "���˵�ˮ��һ��Ҳ���ɿ��ˣ�";
	};
	public String play(){		// ��������
		System.out.println(this.name + "��������һ�����������ʮ�ֿ��ģ�");
		grow(6);	// ���ӳɳ�ֵ
		return this.name + "��������һ�����������ʮ�ֿ��ģ�";
	}
	public String wantPlay(){	// ��Ҫ��
		System.out.println(this.name + "�����㣬�ƺ���Ҫ������档");
		return this.name + "�����㣬�ƺ���Ҫ������档";
	}
	/*
	 * grow(Animal animal, int value) Ϊ�Ż���Ĵ��룬���õ������˼̳�
	 * grow(int value) ���Բ���Ҫ��
	 */
	public static String grow(Animal animal, int value){	// ���ӳɳ�ֵ
		animal.setGrowthValue(animal.getGrowthValue() + value);
		System.out.println(animal.getName() +"�ĳɳ�ֵ������" + value);
		checkGrow(animal);
		return animal.getName() +"�ĳɳ�ֵ������" + value;
	}
	public String grow(int value){	// ���ӳɳ�ֵ
		this.growthValue += value;
		System.out.println(this.name + "�ĳɳ�ֵ����" + value);
		return this.name + "�ĳɳ�ֵ����" + value;	// ���ӳɳ�ֵ
	}
	/*
	 * checkGrow(Animal animal) Ϊ�Ż���Ĵ��룬���õ����ü̳�
	 * checkGrow() ���Բ���Ҫ��
	 */
	static int checkGrow(Animal animal){	// ���ɳ�ֵ
		if (!animal.isCanSell()) {
			if (animal.getGrowthValue() >= 50) {
				animal.setCanSell(true);
				System.out.println("@@@��ֻ�����Ѿ�������������@@@");
				return animal.getGrowthValue();
			}else{
				return animal.getGrowthValue();
			}
		}
		return animal.getGrowthValue();
	}
	public int checkGrow(){	// ÿ�غϼ��ɳ�ֵ
		if (!canSell) {	// ��������ʱ��⣬�����������ü��
			if (this.growthValue >= 50) {
				canSell = true; // ��ʱ���������ˡ�
				System.out.println("��ֻ�����Ѿ�������������");
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
