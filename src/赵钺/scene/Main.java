package 赵钺.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import 赵钺.animal.Animal;
import 赵钺.animal.Cat;
import 赵钺.animal.Dog;
import 赵钺.animal.Rabbit;
import 赵钺.animal.Tiger;
import 赵钺.player.Farmer;
/*
 * 场景：牧场
 */
public class Main extends javafx.application.Application {
	private Label stateFrame = new Label(
			"\t 欢   虽   依\n\t 迎   然   旧\n\t 来   目   祝\n\t 到   前   你\n\t 牧   是   游\n\t 场   测   玩\n\t 物   试   愉\n\t 语   版   快\n\t");
	ObservableList<Animal> list = FXCollections.observableArrayList();
	private ListView<Animal> listView = new ListView<>(list); // 显示宠物的列表
	private Button buttonBuy = new Button("购买宠物");
	private Button buttonSell = new Button("出售宠物");
	private Button buttonFeed = new Button("喂食宠物");
	private Button buttonDrink = new Button("宠物喝水");
	private Button buttonPlay = new Button("陪玩宠物");
	private Button buttonStart = new Button("游戏开始");
	private Label gameFrame = new Label(); // 中间游戏界面
	private Label gameDescribe = new Label("欢迎来到牧场物语，你可以在这里购买宠物，喂养宠物，售卖宠物，以此获取金钱，然后购买新的宠物。当你拥有一定数量的宠物后游戏才会结束，尽情的享受牧场生活吧！"); // 游戏描述
	private boolean isStarted = false; // 游戏是否开始
	Farmer player; // 声明用户，但是等点击游戏开始再初始化

	@Override
	public void start(Stage primaryStage) throws Exception {
		listView.setPrefSize(145, 328); // 设置列表视图的宽、高
		// listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // 多选模式

		BorderPane borderPane = new BorderPane(); // 边界面板

		/*************** 左边 **************************/
		borderPane.setLeft(new ScrollPane(listView)); // 左边显示拥有的宠物列表
		borderPane.setPadding(new Insets(10, 0, 0, 10));

		/*************** 右边 **************************/
		stateFrame.setPrefSize(200, 440); // 右边玩家状态
		stateFrame.setTextFill(javafx.scene.paint.Color.BLUE);
		stateFrame.setFont(new Font("Cambria", 19));
		stateFrame.setWrapText(true); // 自动换行
		borderPane.setRight(stateFrame);

		/*************** 中间 **************************/
		Image imageBag = new Image("backg2.png");
		ImageView bagImageView = new ImageView();
		bagImageView.setImage(imageBag);
		bagImageView.setFitWidth(410);
		bagImageView.setPreserveRatio(true); // 按比例缩放
		gameFrame.setGraphic(bagImageView);
		borderPane.setCenter(gameFrame); // 中间

		/*************** 底下 **************************/
		FlowPane buttonPane = new FlowPane(2, 2);
		borderPane.setBottom(buttonPane);
		gameDescribe.setPrefSize(700, 60); // 游戏描述
		buttonPane.getChildren().add(gameDescribe);
		gameDescribe.setTextFill(Color.RED);
		gameDescribe.setFont(new Font("Cambria", 18));
		gameDescribe.setWrapText(true); // 自动换行

		buttonPane.setOrientation(Orientation.HORIZONTAL); // 设置节点水平摆放
		buttonPane.setPadding(new Insets(12, 13, 14, 15)); // 设置面板边缘内测四周空白的距离
		buttonPane.setHgap(40); // 设置面板上节点之间的水平间距为40像素
		buttonPane.setVgap(5); // 设置面板上节点之间的垂直间距为5像素
		buttonPane.getChildren().add(buttonBuy);
		buttonPane.getChildren().add(buttonSell);
		buttonPane.getChildren().add(buttonFeed);
		buttonPane.getChildren().add(buttonDrink);
		buttonPane.getChildren().add(buttonPlay);
		buttonPane.getChildren().add(buttonStart);

		/************************ 点击事件 ***********************/
		// 开始游戏
		buttonStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) { // 若游戏还未开始，提示开始游戏
					TextInputDialog dialog = new TextInputDialog("振宇"); // 默认用户名
					dialog.setTitle("创建角色");
					dialog.setHeaderText(null);
					dialog.setContentText("请输入你的姓名:");
					Optional<String> result = dialog.showAndWait();
					if (result.isPresent()) { // 输入名字后，创建角色，开始游戏
						String name = result.get();
						player = new Farmer(name);
						stateFrame.setText(player.showAll());
						isStarted = true;
					}
				} else { // 若游戏已经开始，提示已经在游戏
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("提示框");
					alert.setHeaderText(null);
					alert.setContentText("你已经开始游戏了呀！");
					alert.showAndWait();
				}
			}
		});
		// 购买宠物
		buttonBuy.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) { // 未开始游戏
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("提示框");
					alert.setHeaderText(null);
					alert.setContentText("你倒是先开始游戏啊！");
					alert.showAndWait();
				} else { // 游戏中
					List<String> choices = new ArrayList<>();
					choices.add("狗");
					choices.add("猫");
					choices.add("兔子");
					choices.add("老虎");
					choices.add("陆振宇");
				    /* ...........
					 * 此处可以继续拓展
					 */
						
					ChoiceDialog<String> dialog = new ChoiceDialog<>("狗", choices);
					dialog.setTitle("购买宠物");
					dialog.setHeaderText(null);
					dialog.setContentText("选择你要购买的宠物：");
					Optional<String> result = dialog.showAndWait();
					if (result.isPresent()) {
						String animalType = result.get();
						switch (animalType) {
							case "狗": {
								TextInputDialog dialog2 = new TextInputDialog("小狗");
								dialog2.setTitle("宠物取名");
								dialog2.setHeaderText(null);
								dialog2.setContentText("请输入宠物名称：");
								result = dialog2.showAndWait();
								if (result.isPresent()) {
									Dog dog = new Dog(result.get());
									if (player.canBuy(dog)) { // 买得起才买
										gameDescribe.setText(player.buyAnimal(dog));
										list.add(dog);
									}else{
										Alert alert = new Alert(AlertType.WARNING);
										alert.setTitle("错误提示");
										alert.setHeaderText(null);
										alert.setContentText("余额不足，无法购买！");
										alert.showAndWait();
									}
								}
								break;
							}
							case "猫": {
								TextInputDialog dialog2 = new TextInputDialog("喵咪");
								dialog2.setTitle("宠物取名");
								dialog2.setHeaderText(null);
								dialog2.setContentText("请输入宠物名称：");
								result = dialog2.showAndWait();
								if (result.isPresent()) {
									Cat cat = new Cat(result.get());
									if (player.canBuy(cat)) { // 买得起才买
										gameDescribe.setText(player.buyAnimal(cat));
										list.add(cat);
									}else{
										Alert alert = new Alert(AlertType.WARNING);
										alert.setTitle("错误提示");
										alert.setHeaderText(null);
										alert.setContentText("余额不足，无法购买！");
										alert.showAndWait();
									}
								}
								break;
							}
							case "兔子": {
								TextInputDialog dialog2 = new TextInputDialog("兔兔");
								dialog2.setTitle("宠物取名");
								dialog2.setHeaderText(null);
								dialog2.setContentText("请输入宠物名称：");
								result = dialog2.showAndWait();
								if (result.isPresent()) {
									Rabbit rabbit = new Rabbit(result.get());
									if (player.canBuy(rabbit)) { // 买得起才买
										gameDescribe.setText(player.buyAnimal(rabbit));
										list.add(rabbit);
									}else{
										Alert alert = new Alert(AlertType.WARNING);
										alert.setTitle("错误提示");
										alert.setHeaderText(null);
										alert.setContentText("余额不足，无法购买！");
										alert.showAndWait();
									}
								}
							}
							case "老虎": {
								TextInputDialog dialog2 = new TextInputDialog("阿虎");
								dialog2.setTitle("宠物取名");
								dialog2.setHeaderText(null);
								dialog2.setContentText("请输入宠物名称：");
								result = dialog2.showAndWait();
								if (result.isPresent()) {
									Tiger tiger = new Tiger(result.get());
									if (player.canBuy(tiger)) { // 买得起才买
										gameDescribe.setText(player.buyAnimal(tiger));
										list.add(tiger);
									}else{
										Alert alert = new Alert(AlertType.WARNING);
										alert.setTitle("错误提示");
										alert.setHeaderText(null);
										alert.setContentText("余额不足，无法购买！");
										alert.showAndWait();
									}
								}
								break;
							}
							case "陆振宇":{
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("错误提示");
								alert.setHeaderText("你怕是在搞蛇皮。");
								alert.setContentText("你是在想什么呢!小老弟？");
								alert.showAndWait();
								break;
							}
						}
					}
					stateFrame.setText(player.showAll()); // 刷新界面
				}
			}
		});
		// 卖宠物
		buttonSell.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) {	// 游戏未开始
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("提示框");
					alert.setHeaderText(null);
					alert.setContentText("你倒是先开始游戏啊！");
					alert.showAndWait();
				} else {	// 游戏中
					try{
						if (listView.getSelectionModel().getSelectedItem().isCanSell()) {
							gameDescribe.setText(player.sellAnimal(listView.getSelectionModel().getSelectedItem()));
							showMessage("你把" +listView.getSelectionModel().getSelectedItem().getName()+"卖掉了！" );
							list.remove(listView.getSelectionModel().getSelectedItem());
						}else{
							showMessage(listView.getSelectionModel().getSelectedItem().getName()+"目前的成长值只有"
									+ listView.getSelectionModel().getSelectedItem().getGrowthValue()+",还不能卖！\n"
									+ "（成长值>=50才可以卖）");
						}
					}catch (Exception e) {
						showMessage("你倒是选择你要卖的宠物啊！");
					}finally{
						stateFrame.setText(player.showAll()); // 刷新界面
					}
				}
			}
		});
		// 给宠物喂食
		buttonFeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) {	// 游戏未开始
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("提示框");
					alert.setHeaderText(null);
					alert.setContentText("你倒是先开始游戏啊！");
					alert.showAndWait();
				} else {	// 游戏中
					try{
						gameDescribe.setText(player.feedAnimal(listView.getSelectionModel().getSelectedItem()));
					}catch (Exception e) {
						showMessage("你倒是选择你要喂食的宠物啊！");
					}finally{
						stateFrame.setText(player.showAll()); // 刷新界面
					}
				}
			}
		});
		// 给宠物喝水
		buttonDrink.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) {	// 游戏未开始
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("提示框");
					alert.setHeaderText(null);
					alert.setContentText("你倒是先开始游戏啊！");
					alert.showAndWait();
				} else {	// 游戏中
					try{
						gameDescribe.setText(player.giveWater(listView.getSelectionModel().getSelectedItem()));
					}catch (Exception e) {
						showMessage("你倒是选择你要给哪只宠物喝水啊！");
					}finally{
						stateFrame.setText(player.showAll()); // 刷新界面
					}
				}
			}
		});
		// 陪宠物玩
		buttonPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) {	// 游戏未开始
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("提示框");
					alert.setHeaderText(null);
					alert.setContentText("你倒是先开始游戏啊！");
					alert.showAndWait();
				} else {	// 游戏中
						try{
							gameDescribe.setText(player.playWithAnimal(listView.getSelectionModel().getSelectedItem()));
						}catch (Exception e) {
							showMessage("你到是选择你要陪哪只宠物玩啊！");
						}finally {
							stateFrame.setText(player.showAll()); // 刷新界面
					}
				}
			}
		});
		// 点击列表，中间显示图片
		listView.getSelectionModel().selectedItemProperty().addListener(ov -> {
			System.out.println(listView.getSelectionModel().getSelectedIndex()); // 获取选择元素的下标
			System.out.println(listView.getSelectionModel().getSelectedItem().getName());// 获取选择元素Item
			switch (listView.getSelectionModel().getSelectedItem().getAnimalType()) {
				case "狗": {
					setPicture(gameFrame, "dog.png", 300);
					break;
				}
				case "猫": {
					setPicture(gameFrame, "cat.png", 260);
					break;
				}
				case "兔子": {
					setPicture(gameFrame, "rabbit.png", 192);
					break;
				}
				case "老虎": {
					setPicture(gameFrame, "tiger.png", 196);
					break;
				}
			}
		});

		Scene scene = new Scene(borderPane, 730, 450);
		primaryStage.setResizable(false);  // 窗口设定为不可调整
		primaryStage.setTitle("振宇的牧场物语");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// 封装的标签设置图片方法
	public void setPicture(Label label, String picName, int size) {
		Image image = new Image(picName);
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setPreserveRatio(true); // 保持缩放比例
		imageView.setFitWidth(size); // 设置宽度
		imageView.setSmooth(true); // 设置圆滑
		imageView.setCache(true); // 设置缓冲
		label.setGraphic(imageView);
	}
	// 封装的谈对话框方法
	public void showMessage(String showStr){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("提示框");
		alert.setHeaderText(null);
		alert.setContentText(showStr);
		alert.showAndWait();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
