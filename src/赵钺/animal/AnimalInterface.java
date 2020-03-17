package 赵钺.animal;
/*
 * 动物接口
 */
public interface AnimalInterface {
	public abstract String eat();		// 吃东西
	public abstract String drink();		// 喝水
	public abstract String wantPlay();	// 想要玩
	public abstract String play();		// 和主人玩
	public abstract String grow(int value);// 成长
	public abstract int checkGrow();	// 查看成长值
}