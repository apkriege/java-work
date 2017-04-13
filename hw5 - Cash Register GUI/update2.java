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
import javafx.scene.image.ImageView;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;
import java.awt.TextArea;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;



public class HW5Krieger extends Application{
    public static void main(String[] args){
        Application.launch(args);
    }

    private VBox mainContainer = new VBox();
    private GridPane inputGrid = new GridPane();
    private GridPane outputGrid = new GridPane();
    private VBox textArea = new VBox();
    private ArrayList<Integer> itemCodes = new ArrayList<>();
    private ArrayList<String> itemNames = new ArrayList<>();
    private ArrayList<Double> itemPrice = new ArrayList<>();

    private Label itemLbl = new Label("Item ID:");
    private Label itemNameLbl = new Label("Item Name:");
    private Label itemPriceLbl = new Label("Item Price:");
    private Label qtyLbl = new Label("Quantity:");
    private Label totalLbl = new Label("Item Price:");
    private Text itemNameTxt = new Text("holder for item name");
    private Text itemPriceTxt = new Text("$$ holder for item price");
    private Text totalTxt = new Text("$$ holder for item price");
    private ComboBox<Integer> cboItems = new ComboBox<Integer>();
    private TextField qtyTxt = new TextField("");
    private Button addBtn = new Button("Add");

    private Label initTextArea  = new Label("Items: \n");
    private Label saleSubTotalLbl = new Label("Sale Sub Total:");
    private Label saleTaxTotalLbl = new Label("Sale Tax Total (6%):");
    private Label tenderedAmtLbl = new Label("Tendered Amount:");
    private Label changeLbl = new Label("Change:");
    private Text saleSubTotalTxt = new Text();
    private Text saleTotalTxt = new Text();
    private Text changeTxt = new Text();
    private TextField tenderedAmtTxt = new TextField();
    private Button checkoutBtn = new Button("Checkout");

    private ObservableList<Integer> items;

//    private
    private double subtotal = 0;
    private double totalWithTax = 0;

    @Override
    public void start(Stage primaryStage) {
        mainContainer.setSpacing(10);
        mainContainer.setPadding(new Insets(5, 5, 5, 5));
        // somehow have to implement using this shit
//        FileChooser fc = new FileChooser();
//        File file = new File("items.txt");
//        System.out.print(file);

        loadFile();
        System.out.println(itemCodes);
        System.out.println(itemNames);
        System.out.println(itemPrice);

        setElementPositions();
        stylizeFormElements();
        loadEvents();

        Scene scene = new Scene(mainContainer, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    private void buildScene(){
        
    }
    

    private void loadEvents(){
        cboItems.setOnAction(e -> {
            int id = cboItems.getValue()-1;
            itemNameTxt.setText(""+itemNames.get(id));
            itemPriceTxt.setText(""+itemPrice.get(id));
        });

        qtyTxt.setOnKeyReleased(e ->{
            if(qtyTxt.getText() != "" || qtyTxt.getText() != null) {
                int qty = Integer.valueOf(qtyTxt.getText());
                double iPrice = Double.valueOf(itemPriceTxt.getText());
                double ttl = qty * iPrice;
                totalTxt.setText("" + ttl);
            }
        });

        tenderedAmtTxt.setOnKeyReleased(e -> {
            if(qtyTxt.getText() != "" || qtyTxt.getText() != null) {
                double ta = Double.valueOf(tenderedAmtTxt.getText());
                double chg = ta - Double.valueOf(saleTotalTxt.getText());
//                System.out.println(ta);
//                System.out.println(chg);
                changeTxt.setText(""+chg);
            }
        });

        addBtn.setOnAction(e ->{
            String out = qtyTxt.getText()+ " "+itemNameTxt.getText();
            Label tmp = new Label(out);
            textArea.getChildren().add(tmp);

            double total = Double.valueOf(totalTxt.getText());
            subtotal = subtotal + total;
            totalWithTax = subtotal * 1.06;

//            System.out.println(subtotal);
            saleSubTotalTxt.setText(""+subtotal);
            saleTotalTxt.setText(""+totalWithTax);

        });

        checkoutBtn.setOnAction(e -> {
            buildMain(50);
            System.out.print("something");
        });
    }

    private void loadFile(){
        try (Scanner scanner = new Scanner(new File("C:\\Users\\adamk\\IdeaProjects\\HW5Krieger\\src\\items.txt"))) {
            while (scanner.hasNextLine()) {
                itemCodes.add(scanner.nextInt());
                itemNames.add(scanner.next());
                itemPrice.add(scanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        items = FXCollections.observableArrayList(itemCodes);
    }

    private void setElementPositions(){
        VBox vb = new VBox();
        vb.setStyle("-fx-border-color:#ccc; -fx-padding:10");

        textArea.getChildren().add(initTextArea);
        cboItems.getItems().addAll(items);

        inputGrid.add(itemLbl, 0, 0);
        inputGrid.add(cboItems, 1, 0);
        inputGrid.add(itemNameLbl, 0, 1);
        inputGrid.add(itemNameTxt, 1, 1);
        inputGrid.add(itemPriceLbl, 0, 2);
        inputGrid.add(itemPriceTxt, 1, 2);
        inputGrid.add(qtyLbl, 0, 3);
        inputGrid.add(qtyTxt, 1,3);
        inputGrid.add(totalLbl, 0, 4);
        inputGrid.add(totalTxt, 1, 4);
        inputGrid.add(addBtn, 1, 5);

        outputGrid.add(saleSubTotalLbl, 0, 0);
        outputGrid.add(saleTaxTotalLbl, 0, 1);
        outputGrid.add(tenderedAmtLbl, 0, 2);
        outputGrid.add(changeLbl, 0, 3);
        outputGrid.add(saleSubTotalTxt, 1,0);
        outputGrid.add(saleTotalTxt, 1,1);
        outputGrid.add(tenderedAmtTxt, 1,2);
        outputGrid.add(changeTxt, 1,3);
        outputGrid.add(checkoutBtn, 1, 4);

        vb.getChildren().add(inputGrid);
        vb.getChildren().add(textArea);
        vb.getChildren().add(outputGrid);
        mainContainer.getChildren().add(vb);

    }

    private void stylizeFormElements(){
        ColumnConstraints c1 = new ColumnConstraints(75);
        ColumnConstraints c2 = new ColumnConstraints(50,200,300);
        inputGrid.getColumnConstraints().addAll(c1, c2);
        inputGrid.setPadding(new Insets(20, 20, 20, 20));
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);

        GridPane.setHalignment(itemLbl, HPos.RIGHT);
        GridPane.setHalignment(itemNameLbl, HPos.RIGHT);
        GridPane.setHalignment(itemPriceLbl, HPos.RIGHT);
        GridPane.setHalignment(qtyLbl, HPos.RIGHT);
        GridPane.setHalignment(totalLbl, HPos.RIGHT);
        addBtn.setPrefWidth(250);

        ColumnConstraints c1a = new ColumnConstraints(150);
        ColumnConstraints c2a = new ColumnConstraints(50,200,300);
        outputGrid.getColumnConstraints().addAll(c1a, c2a);
        outputGrid.setPadding(new Insets(20, 20, 20, 20));
        outputGrid.setHgap(10);
        outputGrid.setVgap(10);

//        initTextArea.setStyle("-fx-background-color:#ccc");
        textArea.setStyle("-fx-background-color:#fff; -fx-border-color: #ddd; -fx-padding: 10 10");
        textArea.setPrefHeight(300);
        textArea.setPrefWidth(400);
        cboItems.setPrefWidth(500);

    }

    private Pane buildMain(double test){
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

//        
//        Scene scene = new Scene(mainContainer, 400, 600);
//        Stage primaryStage;
//        primaryStage.setScene(scene);
//        primaryStage.show();
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

//        VBox comp = new VBox();

        /* ************** TOP SECTION *************/
//        GridPane grid = new GridPane();
//        ColumnConstraints c1 = new ColumnConstraints(75);
//        ColumnConstraints c2 = new ColumnConstraints(50,200,300);
//        grid.getColumnConstraints().addAll(c1, c2);
//        grid.setPadding(new Insets(20, 20, 20, 20));
//        grid.setHgap(10);
//        grid.setVgap(10);

// set observable items
//        ObservableList<Integer> items = FXCollections.observableArrayList(itemCodes);

// set preferences
//        GridPane.setHalignment(itemLbl, HPos.RIGHT);
//        cboItems.setPrefWidth(500);
//        cboItems.getItems().addAll(items);
//        GridPane.setHalignment(itemNameLbl, HPos.RIGHT);
//        GridPane.setHalignment(itemPriceLbl, HPos.RIGHT);
//        GridPane.setHalignment(qtyLbl, HPos.RIGHT);
//        GridPane.setHalignment(totalLbl, HPos.RIGHT);
//        addBtn.setPrefWidth(250);


// add items to pane
//        grid.add(itemLbl, 0, 0);
//        grid.add(cboItems, 1, 0);
//        grid.add(itemNameLbl, 0, 1);
//        grid.add(itemNameTxt, 1, 1);
//        grid.add(itemPriceLbl, 0, 2);
//        grid.add(itemPriceTxt, 1, 2);
//        grid.add(qtyLbl, 0, 3);
//        grid.add(qtyTxt, 1,3);
//        grid.add(totalLbl, 0, 4);
//        grid.add(totalTxt, 1, 4);
//        grid.add(addBtn, 1, 5);

//        comp.getChildren().add(grid);



        /* ************** MID SECTION *************/
//        VBox vb = new VBox();
//        TextArea ta = new TextArea();
//        vb.add(ta);
//        TODO: def need to work on this box
//        VBox test = new VBox();
//        test.setPrefHeight(300);
//        test.setPrefWidth(400);
//        test.setStyle("-fx-background-color:#ccc");
//        vb.getChildren().add(test);
//        Label base = new Label("Items: \n");
//        test.getChildren().add(base);

//        GridPane gr = new GridPane();
//        ColumnConstraints c1a = new ColumnConstraints(150);
//        ColumnConstraints c2a = new ColumnConstraints(50,200,300);
//        outputGrid.getColumnConstraints().addAll(c1a, c2a);
//        outputGrid.setPadding(new Insets(20, 20, 20, 20));
//        outputGrid.setHgap(10);
//        outputGrid.setVgap(10);

//        gr.add(saleSubTotalLbl, 0, 0);
//        gr.add(saleTaxTotalLbl, 0, 1);
//        gr.add(tenderedAmtLbl, 0, 2);
//        gr.add(changeLbl, 0, 3);
//        gr.add(saleSubTotalTxt, 1,0);
//        gr.add(saleTotalTxt, 1,1);
//        gr.add(tenderedAmtTxt, 1,2);
//        gr.add(changeTxt, 1,3);
//        gr.add(checkoutBtn, 1, 4);

//        vb.getChildren().add(gr);
//        comp.getChildren().add(vb);

//        grid.setStyle("-fx-border-color:red;");
//        vb.setStyle("-fx-border-color:red;");


        /* ************** EVENT HANDLERS *************/
//        cboItems.setOnAction(e -> {
//            int id = cboItems.getValue()-1;
//            itemNameTxt.setText(""+itemNames.get(id));
//            itemPriceTxt.setText(""+itemPrice.get(id));
//        });
//
//        qtyTxt.setOnKeyReleased(e ->{
//            if(qtyTxt.getText() != "" || qtyTxt.getText() != null) {
//                int qty = Integer.valueOf(qtyTxt.getText());
//                double iPrice = Double.valueOf(itemPriceTxt.getText());
//                double ttl = qty * iPrice;
//                totalTxt.setText("" + ttl);
//            }
//        });
//
//        addBtn.setOnAction(e ->{
//            String out = qtyTxt.getText()+ " "+itemNameTxt.getText();
//            Label tmp = new Label(out);
//            test.getChildren().add(tmp);
//        });


//        mainContainer.getChildren().add(comp);
//        return comp;