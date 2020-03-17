package ����.scene;

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
import ����.animal.Animal;
import ����.animal.Cat;
import ����.animal.Dog;
import ����.animal.Rabbit;
import ����.animal.Tiger;
import ����.player.Farmer;
/*
 * ����������
 */
public class Main extends javafx.application.Application {
	private Label stateFrame = new Label(
			"\t ��   ��   ��\n\t ӭ   Ȼ   ��\n\t ��   Ŀ   ף\n\t ��   ǰ   ��\n\t ��   ��   ��\n\t ��   ��   ��\n\t ��   ��   ��\n\t ��   ��   ��\n\t");
	ObservableList<Animal> list = FXCollections.observableArrayList();
	private ListView<Animal> listView = new ListView<>(list); // ��ʾ������б�
	private Button buttonBuy = new Button("�������");
	private Button buttonSell = new Button("���۳���");
	private Button buttonFeed = new Button("ιʳ����");
	private Button buttonDrink = new Button("�����ˮ");
	private Button buttonPlay = new Button("�������");
	private Button buttonStart = new Button("��Ϸ��ʼ");
	private Label gameFrame = new Label(); // �м���Ϸ����
	private Label gameDescribe = new Label("��ӭ���������������������ﹺ����ι�������������Դ˻�ȡ��Ǯ��Ȼ�����µĳ������ӵ��һ�������ĳ������Ϸ�Ż�����������������������ɣ�"); // ��Ϸ����
	private boolean isStarted = false; // ��Ϸ�Ƿ�ʼ
	Farmer player; // �����û������ǵȵ����Ϸ��ʼ�ٳ�ʼ��

	@Override
	public void start(Stage primaryStage) throws Exception {
		listView.setPrefSize(145, 328); // �����б���ͼ�Ŀ���
		// listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // ��ѡģʽ

		BorderPane borderPane = new BorderPane(); // �߽����

		/*************** ��� **************************/
		borderPane.setLeft(new ScrollPane(listView)); // �����ʾӵ�еĳ����б�
		borderPane.setPadding(new Insets(10, 0, 0, 10));

		/*************** �ұ� **************************/
		stateFrame.setPrefSize(200, 440); // �ұ����״̬
		stateFrame.setTextFill(javafx.scene.paint.Color.BLUE);
		stateFrame.setFont(new Font("Cambria", 19));
		stateFrame.setWrapText(true); // �Զ�����
		borderPane.setRight(stateFrame);

		/*************** �м� **************************/
		Image imageBag = new Image("backg2.png");
		ImageView bagImageView = new ImageView();
		bagImageView.setImage(imageBag);
		bagImageView.setFitWidth(410);
		bagImageView.setPreserveRatio(true); // ����������
		gameFrame.setGraphic(bagImageView);
		borderPane.setCenter(gameFrame); // �м�

		/*************** ���� **************************/
		FlowPane buttonPane = new FlowPane(2, 2);
		borderPane.setBottom(buttonPane);
		gameDescribe.setPrefSize(700, 60); // ��Ϸ����
		buttonPane.getChildren().add(gameDescribe);
		gameDescribe.setTextFill(Color.RED);
		gameDescribe.setFont(new Font("Cambria", 18));
		gameDescribe.setWrapText(true); // �Զ�����

		buttonPane.setOrientation(Orientation.HORIZONTAL); // ���ýڵ�ˮƽ�ڷ�
		buttonPane.setPadding(new Insets(12, 13, 14, 15)); // ��������Ե�ڲ����ܿհ׵ľ���
		buttonPane.setHgap(40); // ��������Ͻڵ�֮���ˮƽ���Ϊ40����
		buttonPane.setVgap(5); // ��������Ͻڵ�֮��Ĵ�ֱ���Ϊ5����
		buttonPane.getChildren().add(buttonBuy);
		buttonPane.getChildren().add(buttonSell);
		buttonPane.getChildren().add(buttonFeed);
		buttonPane.getChildren().add(buttonDrink);
		buttonPane.getChildren().add(buttonPlay);
		buttonPane.getChildren().add(buttonStart);

		/************************ ����¼� ***********************/
		// ��ʼ��Ϸ
		buttonStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) { // ����Ϸ��δ��ʼ����ʾ��ʼ��Ϸ
					TextInputDialog dialog = new TextInputDialog("����"); // Ĭ���û���
					dialog.setTitle("������ɫ");
					dialog.setHeaderText(null);
					dialog.setContentText("�������������:");
					Optional<String> result = dialog.showAndWait();
					if (result.isPresent()) { // �������ֺ󣬴�����ɫ����ʼ��Ϸ
						String name = result.get();
						player = new Farmer(name);
						stateFrame.setText(player.showAll());
						isStarted = true;
					}
				} else { // ����Ϸ�Ѿ���ʼ����ʾ�Ѿ�����Ϸ
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("��ʾ��");
					alert.setHeaderText(null);
					alert.setContentText("���Ѿ���ʼ��Ϸ��ѽ��");
					alert.showAndWait();
				}
			}
		});
		// �������
		buttonBuy.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) { // δ��ʼ��Ϸ
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("��ʾ��");
					alert.setHeaderText(null);
					alert.setContentText("�㵹���ȿ�ʼ��Ϸ����");
					alert.showAndWait();
				} else { // ��Ϸ��
					List<String> choices = new ArrayList<>();
					choices.add("��");
					choices.add("è");
					choices.add("����");
					choices.add("�ϻ�");
					choices.add("½����");
				    /* ...........
					 * �˴����Լ�����չ
					 */
						
					ChoiceDialog<String> dialog = new ChoiceDialog<>("��", choices);
					dialog.setTitle("�������");
					dialog.setHeaderText(null);
					dialog.setContentText("ѡ����Ҫ����ĳ��");
					Optional<String> result = dialog.showAndWait();
					if (result.isPresent()) {
						String animalType = result.get();
						switch (animalType) {
							case "��": {
								TextInputDialog dialog2 = new TextInputDialog("С��");
								dialog2.setTitle("����ȡ��");
								dialog2.setHeaderText(null);
								dialog2.setContentText("������������ƣ�");
								result = dialog2.showAndWait();
								if (result.isPresent()) {
									Dog dog = new Dog(result.get());
									if (player.canBuy(dog)) { // ��������
										gameDescribe.setText(player.buyAnimal(dog));
										list.add(dog);
									}else{
										Alert alert = new Alert(AlertType.WARNING);
										alert.setTitle("������ʾ");
										alert.setHeaderText(null);
										alert.setContentText("���㣬�޷�����");
										alert.showAndWait();
									}
								}
								break;
							}
							case "è": {
								TextInputDialog dialog2 = new TextInputDialog("����");
								dialog2.setTitle("����ȡ��");
								dialog2.setHeaderText(null);
								dialog2.setContentText("������������ƣ�");
								result = dialog2.showAndWait();
								if (result.isPresent()) {
									Cat cat = new Cat(result.get());
									if (player.canBuy(cat)) { // ��������
										gameDescribe.setText(player.buyAnimal(cat));
										list.add(cat);
									}else{
										Alert alert = new Alert(AlertType.WARNING);
										alert.setTitle("������ʾ");
										alert.setHeaderText(null);
										alert.setContentText("���㣬�޷�����");
										alert.showAndWait();
									}
								}
								break;
							}
							case "����": {
								TextInputDialog dialog2 = new TextInputDialog("����");
								dialog2.setTitle("����ȡ��");
								dialog2.setHeaderText(null);
								dialog2.setContentText("������������ƣ�");
								result = dialog2.showAndWait();
								if (result.isPresent()) {
									Rabbit rabbit = new Rabbit(result.get());
									if (player.canBuy(rabbit)) { // ��������
										gameDescribe.setText(player.buyAnimal(rabbit));
										list.add(rabbit);
									}else{
										Alert alert = new Alert(AlertType.WARNING);
										alert.setTitle("������ʾ");
										alert.setHeaderText(null);
										alert.setContentText("���㣬�޷�����");
										alert.showAndWait();
									}
								}
							}
							case "�ϻ�": {
								TextInputDialog dialog2 = new TextInputDialog("����");
								dialog2.setTitle("����ȡ��");
								dialog2.setHeaderText(null);
								dialog2.setContentText("������������ƣ�");
								result = dialog2.showAndWait();
								if (result.isPresent()) {
									Tiger tiger = new Tiger(result.get());
									if (player.canBuy(tiger)) { // ��������
										gameDescribe.setText(player.buyAnimal(tiger));
										list.add(tiger);
									}else{
										Alert alert = new Alert(AlertType.WARNING);
										alert.setTitle("������ʾ");
										alert.setHeaderText(null);
										alert.setContentText("���㣬�޷�����");
										alert.showAndWait();
									}
								}
								break;
							}
							case "½����":{
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("������ʾ");
								alert.setHeaderText("�������ڸ���Ƥ��");
								alert.setContentText("��������ʲô��!С�ϵܣ�");
								alert.showAndWait();
								break;
							}
						}
					}
					stateFrame.setText(player.showAll()); // ˢ�½���
				}
			}
		});
		// ������
		buttonSell.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) {	// ��Ϸδ��ʼ
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("��ʾ��");
					alert.setHeaderText(null);
					alert.setContentText("�㵹���ȿ�ʼ��Ϸ����");
					alert.showAndWait();
				} else {	// ��Ϸ��
					try{
						if (listView.getSelectionModel().getSelectedItem().isCanSell()) {
							gameDescribe.setText(player.sellAnimal(listView.getSelectionModel().getSelectedItem()));
							showMessage("���" +listView.getSelectionModel().getSelectedItem().getName()+"�����ˣ�" );
							list.remove(listView.getSelectionModel().getSelectedItem());
						}else{
							showMessage(listView.getSelectionModel().getSelectedItem().getName()+"Ŀǰ�ĳɳ�ֵֻ��"
									+ listView.getSelectionModel().getSelectedItem().getGrowthValue()+",����������\n"
									+ "���ɳ�ֵ>=50�ſ�������");
						}
					}catch (Exception e) {
						showMessage("�㵹��ѡ����Ҫ���ĳ��ﰡ��");
					}finally{
						stateFrame.setText(player.showAll()); // ˢ�½���
					}
				}
			}
		});
		// ������ιʳ
		buttonFeed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) {	// ��Ϸδ��ʼ
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("��ʾ��");
					alert.setHeaderText(null);
					alert.setContentText("�㵹���ȿ�ʼ��Ϸ����");
					alert.showAndWait();
				} else {	// ��Ϸ��
					try{
						gameDescribe.setText(player.feedAnimal(listView.getSelectionModel().getSelectedItem()));
					}catch (Exception e) {
						showMessage("�㵹��ѡ����Ҫιʳ�ĳ��ﰡ��");
					}finally{
						stateFrame.setText(player.showAll()); // ˢ�½���
					}
				}
			}
		});
		// �������ˮ
		buttonDrink.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) {	// ��Ϸδ��ʼ
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("��ʾ��");
					alert.setHeaderText(null);
					alert.setContentText("�㵹���ȿ�ʼ��Ϸ����");
					alert.showAndWait();
				} else {	// ��Ϸ��
					try{
						gameDescribe.setText(player.giveWater(listView.getSelectionModel().getSelectedItem()));
					}catch (Exception e) {
						showMessage("�㵹��ѡ����Ҫ����ֻ�����ˮ����");
					}finally{
						stateFrame.setText(player.showAll()); // ˢ�½���
					}
				}
			}
		});
		// �������
		buttonPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!isStarted) {	// ��Ϸδ��ʼ
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("��ʾ��");
					alert.setHeaderText(null);
					alert.setContentText("�㵹���ȿ�ʼ��Ϸ����");
					alert.showAndWait();
				} else {	// ��Ϸ��
						try{
							gameDescribe.setText(player.playWithAnimal(listView.getSelectionModel().getSelectedItem()));
						}catch (Exception e) {
							showMessage("�㵽��ѡ����Ҫ����ֻ�����氡��");
						}finally {
							stateFrame.setText(player.showAll()); // ˢ�½���
					}
				}
			}
		});
		// ����б��м���ʾͼƬ
		listView.getSelectionModel().selectedItemProperty().addListener(ov -> {
			System.out.println(listView.getSelectionModel().getSelectedIndex()); // ��ȡѡ��Ԫ�ص��±�
			System.out.println(listView.getSelectionModel().getSelectedItem().getName());// ��ȡѡ��Ԫ��Item
			switch (listView.getSelectionModel().getSelectedItem().getAnimalType()) {
				case "��": {
					setPicture(gameFrame, "dog.png", 300);
					break;
				}
				case "è": {
					setPicture(gameFrame, "cat.png", 260);
					break;
				}
				case "����": {
					setPicture(gameFrame, "rabbit.png", 192);
					break;
				}
				case "�ϻ�": {
					setPicture(gameFrame, "tiger.png", 196);
					break;
				}
			}
		});

		Scene scene = new Scene(borderPane, 730, 450);
		primaryStage.setResizable(false);  // �����趨Ϊ���ɵ���
		primaryStage.setTitle("�������������");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// ��װ�ı�ǩ����ͼƬ����
	public void setPicture(Label label, String picName, int size) {
		Image image = new Image(picName);
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setPreserveRatio(true); // �������ű���
		imageView.setFitWidth(size); // ���ÿ��
		imageView.setSmooth(true); // ����Բ��
		imageView.setCache(true); // ���û���
		label.setGraphic(imageView);
	}
	// ��װ��̸�Ի��򷽷�
	public void showMessage(String showStr){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("��ʾ��");
		alert.setHeaderText(null);
		alert.setContentText(showStr);
		alert.showAndWait();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
