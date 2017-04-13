import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HW5Krieger extends Application{
    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
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
//        primaryStage.show();

        Scene scene = new Scene(buildSecondary(), 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

//        Scene scene = new Scene(new Group(), 450, 250);
//
//        ComboBox<String> myComboBox = new ComboBox<String>();
//        myComboBox.getItems().addAll("A","B","C","D","E");
//        myComboBox.setEditable(true);
//
//        Group root = (Group) scene.getRoot();
//        root.getChildren().add(myComboBox);
//        primaryStage.setScene(scene);
//        primaryStage.show();

    }

    // item id - dropdown
    // item name - text when dropdown
    // itme price - text when dd
    // quantity - input box
    // item total - text when dropdown
    // add button
    private String[] flagTitles = {"Canada", "China", "Denmark",
            "France", "Germany", "India", "Norway", "United Kingdom",
            "United States of America"};

    private GridPane grid = new GridPane();

    private Pane buildSecondary(){
//        GridPane grid = new GridPane();
        ColumnConstraints c1 = new ColumnConstraints(75);
        ColumnConstraints c2 = new ColumnConstraints(50,200,300);
        grid.getColumnConstraints().addAll(c1, c2);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(10);
        grid.setVgap(10);


        Label itemLbl = new Label("Item ID:");
        GridPane.setHalignment(itemLbl, HPos.RIGHT);
        grid.add(itemLbl, 0, 0);

        ComboBox<String> cboItems = new ComboBox<String>();
        cboItems.setPrefWidth(500);
        ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
        cboItems.getItems().addAll(items);
        grid.add(cboItems, 1, 0);

        Label itemNameLbl = new Label("Item Name:");
        GridPane.setHalignment(itemNameLbl, HPos.RIGHT);
        grid.add(itemNameLbl, 0, 1);

        Label itemNameTxt = new Label("holder for item name");
        GridPane.setHalignment(itemNameTxt, HPos.LEFT);
        grid.add(itemNameTxt, 1, 1);

        Label itemPriceLbl = new Label("Item Price:");
        GridPane.setHalignment(itemPriceLbl, HPos.RIGHT);
        grid.add(itemPriceLbl, 0, 2);

        Label itemPriceTxt = new Label("$$ holder for item price");
        GridPane.setHalignment(itemPriceTxt, HPos.LEFT);
        grid.add(itemPriceTxt, 1, 2);

        Label qtyLbl = new Label("Quantity:");
        GridPane.setHalignment(qtyLbl, HPos.RIGHT);
        grid.add(qtyLbl, 0, 3);

        // add input box for quantity

        Label totalLbl = new Label("Item Price:");
        GridPane.setHalignment(totalLbl, HPos.RIGHT);
        grid.add(totalLbl, 0, 4);

        Label totalTxt = new Label("$$ holder for item price");
        GridPane.setHalignment(totalTxt, HPos.LEFT);
        grid.add(totalTxt, 1, 4);

        // add a fucking button


        // event handlers
        cboItems.setOnAction(e -> {
            grid.getChildren().remove(itemNameTxt);
            itemNameTxt.setText(cboItems.getValue());
            grid.add(itemNameTxt, 1, 1);
        });

        return grid;
    }

    public void setItemName(int index){
//        Label itemNameTxt = new Label(flagTitles[index]);
//        GridPane.setHalignment(itemNameTxt, HPos.LEFT);
//        grid.set(itemNameTxt, 1, 1);
    }

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