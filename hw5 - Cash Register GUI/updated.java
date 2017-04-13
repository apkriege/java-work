import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.awt.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;



public class HW5Krieger extends Application{
    public static void main(String[] args){
        Application.launch(args);
    }

//    private VBox temp = new VBox();

    private ArrayList<Integer> itemCodes = new ArrayList<>();
    private ArrayList<String> itemNames = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

//        FileChooser fc = new FileChooser();
//        File file = new File("items.txt");
//        System.out.print(file);

//        ArrayList<Object> l = new ArrayList<>();

//        ArrayList<Integer> itemCode = new ArrayList<>();
//        ArrayList<String> itemName = new ArrayList<>();
        ArrayList<Double> itemPrice = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("C:\\Users\\apkriege\\IdeaProjects\\HW5\\src\\items.txt"))) {
            while (scanner.hasNextLine()) {
                itemCodes.add(scanner.nextInt());
                itemNames.add(scanner.next());
                itemPrice.add(scanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//
        System.out.println(itemCodes);
        System.out.println(itemNames);
        System.out.println(itemPrice);

//        while(scanner.hasNextLine()){
//            System.out.print("test");
//        }
//        while(scanner.hasNextLine()){
////            l.add(scanner.next());
//            System.out.print("test");
//        }

//        System.out.print(l);


        VBox temp = new VBox();
        temp.setSpacing(10);
        temp.setPadding(new Insets(5, 5, 5, 5));
        temp.getChildren().add(build1());
//        temp.getChildren().add(build2());

        Scene scene = new Scene(temp, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }



    private Pane build1(){
        VBox comp = new VBox();

        /* ************** TOP SECTION *************/
        GridPane grid = new GridPane();
        ColumnConstraints c1 = new ColumnConstraints(75);
        ColumnConstraints c2 = new ColumnConstraints(50,200,300);
        grid.getColumnConstraints().addAll(c1, c2);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(10);
        grid.setVgap(10);

        Label itemLbl = new Label("Item ID:");
        Label itemNameLbl = new Label("Item Name:");
        Label itemPriceLbl = new Label("Item Price:");
        Label qtyLbl = new Label("Quantity:");
        Label totalLbl = new Label("Item Price:");
        Text itemNameTxt = new Text("holder for item name"); // CHANGE TO TEXT
        Text itemPriceTxt = new Text("$$ holder for item price"); // CHANGE TO TEXT
        Text totalTxt = new Text("$$ holder for item price"); // CHANGE TO TEXT
        ComboBox<Integer> cboItems = new ComboBox<Integer>();
        TextField qtyTxt = new TextField();
        Button addBtn = new Button("Add");
//        Text qtyTxt = new Text("asdfasdf"); // this might me used somewhere

        // set observable items
        ObservableList<Integer> items = FXCollections.observableArrayList(itemCodes);

        // set preferences
        GridPane.setHalignment(itemLbl, HPos.RIGHT);
        cboItems.setPrefWidth(500);
        cboItems.getItems().addAll(items);
        GridPane.setHalignment(itemNameLbl, HPos.RIGHT);
        GridPane.setHalignment(itemPriceLbl, HPos.RIGHT);
        GridPane.setHalignment(qtyLbl, HPos.RIGHT);
        GridPane.setHalignment(totalLbl, HPos.RIGHT);
        addBtn.setPrefWidth(250);


        // add items to pane
        grid.add(itemLbl, 0, 0);
        grid.add(cboItems, 1, 0);
        grid.add(itemNameLbl, 0, 1);
        grid.add(itemNameTxt, 1, 1);
        grid.add(itemPriceLbl, 0, 2);
        grid.add(itemPriceTxt, 1, 2);
        grid.add(qtyLbl, 0, 3);
        grid.add(qtyTxt, 1,3);
        grid.add(totalLbl, 0, 4);
        grid.add(totalTxt, 1, 4);
        grid.add(addBtn, 1, 5);

        comp.getChildren().add(grid);



        /* ************** MID SECTION *************/
        VBox vb = new VBox();

        //TODO: def need to work on this box
        VBox test = new VBox();
        test.setPrefHeight(300);
        test.setPrefWidth(400);
        test.setStyle("-fx-background-color:#555");
        vb.getChildren().add(test);
        // possibly use text type for this

        GridPane gr = new GridPane();
        ColumnConstraints c1a = new ColumnConstraints(150);
        ColumnConstraints c2a = new ColumnConstraints(50,200,300);
        gr.getColumnConstraints().addAll(c1a, c2a);
        gr.setPadding(new Insets(20, 20, 20, 20));
        gr.setHgap(10);
        gr.setVgap(10);

        Label saleSubTotalLbl = new Label("Sale Sub Total:");
        Label saleTaxTotalLbl = new Label("Sale Tax Total (6%):");
        Label tenderedAmtLbl = new Label("Tendered Amount:");
        Label changeLbl = new Label("Change:");
        Text saleSubTotalTxt = new Text();
        Text saleTotalTxt = new Text();
        Text changeTxt = new Text();
        TextField tenderedAmtTxt = new TextField();
        Button checkoutBtn = new Button("Checkout");

        gr.add(saleSubTotalLbl, 0, 0);
        gr.add(saleTaxTotalLbl, 0, 1);
        gr.add(tenderedAmtLbl, 0, 2);
        gr.add(changeLbl, 0, 3);
        gr.add(saleSubTotalTxt, 1,0);
        gr.add(saleTotalTxt, 1,1);
        gr.add(tenderedAmtTxt, 1,2);
        gr.add(changeTxt, 1,3);
        gr.add(checkoutBtn, 1, 4);

        vb.getChildren().add(gr);
        comp.getChildren().add(vb);

        grid.setStyle("-fx-border-color:red;");
        vb.setStyle("-fx-border-color:red;");


        /* ************** EVENT HANDLERS *************/
        cboItems.setOnAction(e -> {
            grid.getChildren().remove(itemNameTxt);
            String tmp = itemNames.get(cboItems.getValue()-1);
            itemNameTxt.setText(tmp);
            grid.add(itemNameTxt, 1, 1);
        });

        addBtn.setOnAction(e ->{
            Label tmp = new Label(itemNameTxt.getText()+ " $ something");
            test.getChildren().add(tmp);

//            double t =
//            System.out.print(t);

        });



        return comp;
    }

//    private Pane testing(){
//
//
//        return test;
//    }

    private Pane buildMain(){
        BorderPane bp = new BorderPane();
        Text title = new Text(20, 20, "Welcome to the POST System!!");
        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(30,12,12,12));
        title.setFont(Font.font(null, FontWeight.NORMAL, 28));
        bp.setTop(title);

        Button btnOK = new Button("New Sale");
        btnOK.setStyle("-fx-padding: 10 40; -fx-font: 14 arial");
        bp.setCenter(btnOK);

        Text saleText = new Text(20, 20, "Total sale for the day is: $XX.XX");
        BorderPane.setAlignment(saleText, Pos.CENTER);
        BorderPane.setMargin(saleText, new Insets(10,12,50,12));
        saleText.setFont(Font.font(null, FontWeight.NORMAL, 24));
        bp.setBottom(saleText);

        return bp;
    }

}

//        BorderPane pane = new BorderPane();
//        pane.setCenter(buildMain());
//
//        Scene scene = new Scene(pane, 450, 300);
//        primaryStage.setScene(scene);
//        primaryStage.show();

//        BorderPane a = new BorderPane();
//        a.setCenter(buildSecondary());
//
//        Scene s = new Scene(a, 450, 300);
//        primaryStage.setScene(s);
//        primaryStage.show();w