import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Driver extends Application {
    public static int[][] array2d;
    public static int[][] arrows2d;
    public static int[] solution;
    public static GridPane dptable = new GridPane();
    public static int current = 0;
    public static Button nextB = new Button(">>");
    public static Button playpauseB = new Button("Play/Pause");
    public static int flag = 0;

    @Override
    public void start(Stage primaryStage) {
        ImageView funcimg = new ImageView(new Image("file:func_pic.png"));
        funcimg.setFitHeight(400);
        funcimg.setFitWidth(1200);
        StackPane sPane = new StackPane();
        Line hSeperator = new Line();
        Line hSeperator2 = new Line();
        Line hSeperator3 = new Line();
        Line hSeperator4 = new Line();
        HBox playeraHBox = new HBox(30);
        HBox playerbHBox = new HBox(30);
        Label playeraL = new Label("Player A");
        Label playerbL = new Label("Player B");
        Label playeraL2 = new Label("Optimal Solution: ");
        Label playerbL2 = new Label("Optimal Solution: ");
        Label playeraL3 = new Label("Values: ");
        Label playerbL3 = new Label("Values: ");
        Label playeraL4 = new Label("Indexes: ");
        Label playerbL4 = new Label("Indexes: ");
        playeraL.setStyle("-fx-border-color: green; -fx-border-width: 2");
        playerbL.setStyle("-fx-border-color: blue; -fx-border-width: 2");
        playerbL.setFont(new Font("Arial", 19));
        playerbL.setPrefSize(120, 85);
        playerbL2.setFont(new Font("Arial", 19));
        playerbL2.setPrefSize(250, 85);
        playerbL3.setFont(new Font("Arial", 19));
        playerbL3.setPrefSize(350, 85);
        playerbL4.setFont(new Font("Arial", 19));
        playerbL4.setPrefSize(350, 85);
        playeraL.setFont(new Font("Arial", 19));
        playeraL.setPrefSize(120, 85);
        playeraL.setAlignment(Pos.CENTER);
        playeraL2.setFont(new Font("Arial", 19));
        playeraL2.setPrefSize(250, 85);
        playeraL3.setFont(new Font("Arial", 19));
        playeraL3.setPrefSize(350, 85);
        playeraL4.setFont(new Font("Arial", 19));
        playeraL4.setPrefSize(350, 85);
        playerbL.setAlignment(Pos.CENTER);
        playerbL.setTextFill(Color.WHITE);
        playeraL.setTextFill(Color.WHITE);
        playerbL2.setTextFill(Color.WHITE);
        playeraL2.setTextFill(Color.WHITE);
        playerbL3.setTextFill(Color.WHITE);
        playeraL3.setTextFill(Color.WHITE);
        playerbL4.setTextFill(Color.WHITE);
        playeraL4.setTextFill(Color.WHITE);
        Button previousB = new Button("<<");
        HBox mediaHBox = new HBox(30);
        mediaHBox.getChildren().addAll(previousB, playpauseB, nextB);
        nextB.setFont(new Font("Arial", 19));
        nextB.setPrefSize(90, 30);
        previousB.setFont(new Font("Arial", 19));
        previousB.setPrefSize(90, 30);
        playpauseB.setFont(new Font("Arial", 19));
        playpauseB.setPrefSize(150, 30);
        hSeperator.setStartX(1000);
        hSeperator.setStrokeWidth(2);
        hSeperator.setStroke(Color.WHITE);
        hSeperator2.setStartX(1300);
        hSeperator2.setStrokeWidth(2);
        hSeperator2.setStroke(Color.WHITE);
        hSeperator3.setStartX(1000);
        hSeperator3.setStrokeWidth(2);
        hSeperator3.setStroke(Color.WHITE);
        hSeperator4.setStartX(500);
        hSeperator4.setStrokeWidth(2);
        hSeperator4.setStroke(Color.WHITE);
        Line vSeperator1 = new Line();
        Line vSeperator2 = new Line();
        Line vSeperator3 = new Line();
        Line vSeperator4 = new Line();
        Line vSeperator5 = new Line();
        Line vSeperator6 = new Line();
        vSeperator1.setStartY(85);
        vSeperator1.setStrokeWidth(2);
        vSeperator1.setStroke(Color.WHITE);
        vSeperator2.setStartY(85);
        vSeperator2.setStrokeWidth(2);
        vSeperator2.setStroke(Color.WHITE);
        vSeperator3.setStartY(85);
        vSeperator3.setStrokeWidth(2);
        vSeperator3.setStroke(Color.WHITE);
        vSeperator4.setStartY(85);
        vSeperator4.setStrokeWidth(2);
        vSeperator4.setStroke(Color.WHITE);
        vSeperator5.setStartY(85);
        vSeperator5.setStrokeWidth(2);
        vSeperator5.setStroke(Color.WHITE);
        vSeperator6.setStartY(85);
        vSeperator6.setStrokeWidth(2);
        vSeperator6.setStroke(Color.WHITE);
        playeraHBox.getChildren().addAll(playeraL, vSeperator1, playeraL2, vSeperator2, playeraL3, vSeperator3,
                playeraL4);
        playerbHBox.getChildren().addAll(playerbL, vSeperator4, playerbL2, vSeperator5, playerbL3, vSeperator6,
                playerbL4);
        Button plusB = new Button("+");
        Button minusB = new Button("-");
        Button exitB = new Button("Exit");
        Button playB = new Button("Play");
        Label titleL = new Label("  The ''Fair'' Coins Game");
        VBox titleVbox = new VBox(5);
        VBox mainvbox = new VBox(60);
        titleL.setTextFill(Color.WHITE);
        Line line1 = new Line();
        titleVbox.getChildren().addAll(titleL, line1);
        exitB.setFont(new Font("Arial", 25));
        exitB.setPrefSize(150, 70);
        titleL.setFont(new Font("Arial", 25));
        titleL.setPrefSize(305, 50);
        playB.setFont(new Font("Arial", 25));
        playB.setMaxSize(150, 70);
        playB.setMinSize(150, 70);
        line1.setStartX(300);
        line1.setStrokeWidth(2);
        mainvbox.setAlignment(Pos.TOP_CENTER);
        mainvbox.getChildren().addAll(titleVbox, playB, exitB);
        titleVbox.setAlignment(Pos.CENTER);
        mainvbox.setPadding(new Insets(30, 0, 0, 0));
        BorderPane bPane = new BorderPane();
        VBox resultvbox = new VBox(5);
        VBox innerresVBox = new VBox(1);
        HBox buttonsHbox = new HBox(10);
        bPane.setBottom(buttonsHbox);
        bPane.setCenter(resultvbox);
        bPane.setVisible(false);
        Button backB = new Button("Back");
        Button resultB = new Button("Result");
        Line line2 = new Line();
        line2.setStartX(500);
        line2.setStrokeWidth(2);
        line2.setStroke(Color.WHITE);
        line1.setStroke(Color.WHITE);
        VBox inputTitleVBox = new VBox(2);
        Label inputL = new Label("                    Add Some Coins");
        inputL.setFont(new Font("Arial", 25));
        inputL.setTextFill(Color.WHITE);
        resultvbox.setAlignment(Pos.TOP_CENTER);
        inputL.setPrefSize(500, 50);
        HBox dataHbox = new HBox(2);
        HBox dataindex = new HBox(2);
        innerresVBox.getChildren().addAll(dataHbox, dataindex);
        TextField n1 = new TextField();
        TextField n2 = new TextField();
        n1.setTextFormatter(new TextFormatter<>(c -> {
            if (!c.getControlNewText().matches("\\d*") || c.getControlNewText().matches("0"))
                return null;
            else
                return c;
        }));
        n2.setTextFormatter(new TextFormatter<>(c -> {
            if (!c.getControlNewText().matches("\\d*") || c.getControlNewText().matches("0"))
                return null;
            else
                return c;
        }));
        Label index1 = new Label("1");
        Label index2 = new Label("2");
        Label filler1 = new Label();
        Label filler2 = new Label();
        dataHbox.setPadding(new Insets(0, 20, 0, 30));
        resultvbox.setPadding(new Insets(30, 0, 0, 0));
        plusB.setMinSize(50, 50);
        plusB.setMaxSize(50, 50);
        minusB.setMinSize(50, 50);
        minusB.setMaxSize(50, 50);
        plusB.setFont(new Font("Arial", 20));
        minusB.setFont(new Font("Arial", 25));
        n1.setMinSize(50, 50);
        n1.setMaxSize(50, 50);
        n2.setMinSize(50, 50);
        n2.setMaxSize(50, 50);
        index1.textFillProperty().set(Color.WHITE);
        index2.textFillProperty().set(Color.WHITE);
        index1.setMinSize(50, 50);
        index1.setMaxSize(50, 50);
        index2.setMinSize(50, 50);
        index2.setMaxSize(50, 50);
        filler1.setMinSize(50, 50);
        filler1.setMaxSize(50, 50);
        filler2.setMinSize(50, 50);
        filler2.setMaxSize(50, 50);
        n1.setFont(new Font("Arial", 15));
        n2.setFont(new Font("Arial", 15));
        index1.setFont(new Font("Arial", 15));
        index2.setFont(new Font("Arial", 15));
        filler1.setFont(new Font("Arial", 15));
        filler2.setFont(new Font("Arial", 15));
        dataindex.getChildren().addAll(index1, index2, filler1, filler2);
        dataHbox.getChildren().addAll(n1, n2, plusB, minusB);
        inputTitleVBox.setAlignment(Pos.CENTER);
        dataindex.setAlignment(Pos.CENTER);
        inputTitleVBox.getChildren().addAll(inputL, line2);
        backB.setFont(new Font("Arial", 19));
        backB.setPrefSize(90, 30);
        resultB.setFont(new Font("Arial", 19));
        resultB.setPrefSize(90, 30);
        buttonsHbox.setPadding(new Insets(0, 0, 10, 0));
        buttonsHbox.setAlignment(Pos.CENTER);
        playeraHBox.setPadding(new Insets(59, 100, 59, 50));
        playerbHBox.setPadding(new Insets(59, 100, 59, 50));
        Button funcB = new Button("Function");
        Button dbtableB = new Button("DB Table");
        HBox dbhbox = new HBox(1);
        VBox dbvbox = new VBox(1);
        Label infoL1 = new Label("Player A: ");
        Label infoL2 = new Label("Player B: ");
        Label infoL3 = new Label("Coins: ");
        Label infoL4 = new Label("Green Squares");
        Label infoL5 = new Label("Blue Squares");
        Label infoL6 = new Label("Red Squares");
        HBox dbhbox1 = new HBox();
        dbhbox1.getChildren().addAll(infoL1, infoL4);
        HBox dbhbox2 = new HBox();
        dbhbox2.getChildren().addAll(infoL2, infoL5);
        HBox dbhbox3 = new HBox();
        dbhbox3.getChildren().addAll(infoL3, infoL6);
        dbvbox.getChildren().addAll(dbhbox1, dbhbox2, dbhbox3);
        infoL1.setAlignment(Pos.CENTER);
        infoL1.setFont(new Font("Arial", 19));
        infoL1.setPrefSize(150, 50);
        infoL1.setTextFill(Color.GREEN);
        infoL2.setAlignment(Pos.CENTER);
        infoL2.setFont(new Font("Arial", 19));
        infoL2.setPrefSize(150, 50);
        infoL2.setTextFill(Color.BLUE);
        infoL3.setAlignment(Pos.CENTER);
        infoL3.setFont(new Font("Arial", 19));
        infoL3.setPrefSize(150, 50);
        infoL3.setTextFill(Color.RED);
        infoL4.setAlignment(Pos.CENTER);
        infoL4.setFont(new Font("Arial", 19));
        infoL4.setPrefSize(150, 50);
        infoL4.setTextFill(Color.WHITE);
        infoL5.setAlignment(Pos.CENTER);
        infoL5.setFont(new Font("Arial", 19));
        infoL5.setPrefSize(150, 50);
        infoL5.setTextFill(Color.WHITE);
        infoL6.setAlignment(Pos.CENTER);
        infoL6.setFont(new Font("Arial", 19));
        infoL6.setPrefSize(150, 50);
        infoL6.setTextFill(Color.WHITE);
        dataHbox.setAlignment(Pos.CENTER);
        buttonsHbox.getChildren().addAll(backB, resultB);
        funcB.setFont(new Font("Arial", 19));
        funcB.setPrefSize(110, 30);
        dbtableB.setFont(new Font("Arial", 19));
        dbtableB.setPrefSize(120, 30);
        mediaHBox.setAlignment(Pos.CENTER);
        innerresVBox.setAlignment(Pos.CENTER);
        sPane.getChildren().addAll(mainvbox, bPane);
        Scene scene1 = new Scene(sPane, 400, 400);
        sPane.setStyle("-fx-background-color: #1A1919");
        primaryStage.setScene(scene1);
        primaryStage.show();
        // ==========================================================================================
        plusB.setOnAction(e -> {
            dataHbox.getChildren().removeAll(plusB, minusB);
            TextField temp1 = new TextField();
            temp1.setMinSize(50, 50);
            temp1.setMaxSize(50, 50);
            temp1.setFont(new Font("Arial", 15));
            TextField temp2 = new TextField();
            temp2.setMinSize(50, 50);
            temp2.setMaxSize(50, 50);
            temp2.setFont(new Font("Arial", 15));

            temp1.setTextFormatter(new TextFormatter<>(c -> {
                if (!c.getControlNewText().matches("\\d*") || c.getControlNewText().matches("0"))
                    return null;
                else
                    return c;
            }));
            temp2.setTextFormatter(new TextFormatter<>(c -> {
                if (!c.getControlNewText().matches("\\d*") || c.getControlNewText().matches("0"))
                    return null;
                else
                    return c;
            }));
            Label temp3 = new Label(Integer.toString(dataHbox.getChildren().size() + 1));
            temp3.setMinSize(50, 50);
            temp3.setMaxSize(50, 50);
            temp3.setFont(new Font("Arial", 15));
            temp3.textFillProperty().set(Color.WHITE);
            Label temp4 = new Label(Integer.toString(dataHbox.getChildren().size() + 2));
            temp4.textFillProperty().set(Color.WHITE);
            temp4.setMinSize(50, 50);
            temp4.setMaxSize(50, 50);
            temp4.setFont(new Font("Arial", 15));
            dataHbox.getChildren().addAll(temp1, temp2);
            dataHbox.getChildren().addAll(plusB, minusB);
            dataindex.getChildren().removeAll(filler2, filler1);
            dataindex.getChildren().addAll(temp3, temp4);
            dataindex.getChildren().addAll(filler1, filler2);
        });
        minusB.setOnAction(e -> {
            if (dataHbox.getChildren().size() > 4) {
                dataHbox.getChildren().removeAll(plusB, minusB);
                dataindex.getChildren().removeAll(filler2, filler1);
                dataHbox.getChildren().removeAll(dataHbox.getChildren().get(dataHbox.getChildren().size() - 1),
                        dataHbox.getChildren().get(dataHbox.getChildren().size() - 2));
                dataindex.getChildren().removeAll(dataindex.getChildren().get(dataindex.getChildren().size() - 1),
                        dataindex.getChildren().get(dataindex.getChildren().size() - 2));
                dataHbox.getChildren().addAll(plusB, minusB);
                dataindex.getChildren().addAll(filler1, filler2);
            }
        });

        playB.setOnAction(e -> {
            mainvbox.setVisible(false);
            bPane.setVisible(true);
            resultvbox.getChildren().addAll(inputTitleVBox, innerresVBox, hSeperator);
            primaryStage.setMaximized(true);
        });
        backB.setOnAction(e -> {
            if (buttonsHbox.getChildren().contains(resultB) == true) {
                mainvbox.setVisible(true);
                bPane.setVisible(false);
                resultvbox.getChildren().removeAll(inputTitleVBox, innerresVBox, hSeperator);
                primaryStage.setMaximized(false);
            } else if (resultvbox.getChildren().contains(dbhbox) == true) {
                resultvbox.getChildren().remove(dbhbox);
                resultvbox.getChildren().addAll(playeraHBox, hSeperator2, playerbHBox, hSeperator3, mediaHBox,
                        hSeperator4);

                buttonsHbox.getChildren().addAll(funcB, dbtableB);
            } else if (resultvbox.getChildren().contains(funcimg) == true) {
                resultvbox.getChildren().remove(funcimg);
                resultvbox.getChildren().addAll(playeraHBox, hSeperator2, playerbHBox, hSeperator3, mediaHBox,
                        hSeperator4);

                buttonsHbox.getChildren().addAll(funcB, dbtableB);
            } else {
                resultvbox.getChildren().removeAll(hSeperator, innerresVBox);
                resultvbox.getChildren().addAll(inputTitleVBox, innerresVBox, hSeperator);
                buttonsHbox.getChildren().removeAll(dbtableB, funcB);
                buttonsHbox.getChildren().addAll(resultB);
                resultvbox.getChildren().removeAll(playeraHBox, hSeperator2, playerbHBox, hSeperator3, mediaHBox,
                        hSeperator4);
                for (int i = 0; i < dataHbox.getChildren().size(); i++) {
                    TextField temp = (TextField) dataHbox.getChildren().get(i);
                    temp.setEditable(true);
                }

                dataHbox.getChildren().addAll(plusB, minusB);
                dataindex.getChildren().addAll(filler1, filler2);
                for (int q = 0; q < dataHbox.getChildren().size() - 2; q++) {
                    TextField ik = (TextField) dataHbox.getChildren().get(q);
                    ik.setStyle("-fx-background-color: white;");
                }
            }
        });
        resultB.setOnAction(e -> {
            int flagie = 0;
            for (int q = 0; q < dataHbox.getChildren().size() - 2; q++) {
                TextField ik = (TextField) dataHbox.getChildren().get(q);
                if (ik.getText().compareTo("") == 0) {
                    flagie = 1;
                    break;
                }
            }
            if (flagie == 0) {
                flag = 0;
                current = 0;
                playeraL3.setText("Values: ");
                playerbL3.setText("Values: ");
                playeraL4.setText("Indexes: ");
                playerbL4.setText("Indexes: ");
                int[] array1d = new int[dataHbox.getChildren().size() - 2];
                for (int i = 0; i < array1d.length; i++) {
                    TextField tmp = (TextField) dataHbox.getChildren().get(i);
                    array1d[i] = Integer.parseInt(tmp.getText());
                }
                pickCoins(array1d);
                resultvbox.getChildren().removeAll(inputTitleVBox);
                resultvbox.getChildren().addAll(playeraHBox, hSeperator2, playerbHBox, hSeperator3, mediaHBox,
                        hSeperator4);
                buttonsHbox.getChildren().remove(resultB);
                buttonsHbox.getChildren().addAll(funcB, dbtableB);
                dataHbox.getChildren().removeAll(plusB, minusB);
                dataindex.getChildren().removeAll(filler2, filler1);
                for (int i = 0; i < dataHbox.getChildren().size(); i++) {
                    TextField temp = (TextField) dataHbox.getChildren().get(i);
                    temp.setEditable(false);
                }
                playeraL2.setText("Optimal Solution: " + Integer.toString(array2d[0][array1d.length - 1]));
                playerbL2.setText("Optimal Solution: "
                        + Integer.toString(Math.min(array2d[0][array1d.length - 2], array2d[1][array1d.length - 1])));
            }
        });
        exitB.setOnAction(e -> {
            System.exit(0);
        });

        dbtableB.setOnAction(e -> {
            resultvbox.getChildren().removeAll(playeraHBox, hSeperator2, playerbHBox, hSeperator3, mediaHBox,
                    hSeperator4);
            dbhbox.getChildren().clear();
            dbhbox.getChildren().addAll(dptable, dbvbox);
            resultvbox.getChildren().addAll(dbhbox);
            buttonsHbox.getChildren().removeAll(dbtableB, funcB);
        });

        nextB.setOnAction(e -> {
            if (current < solution.length) {
                if (current == 0 || current % 2 == 0) {
                    StringBuilder sb = new StringBuilder(playeraL3.getText());
                    sb.append("+" + array2d[solution[current]][solution[current]]);
                    dataHbox.getChildren().get(solution[current]).setStyle("-fx-background-color: green;");
                    playeraL3.setText(sb.toString());
                    sb = new StringBuilder(playeraL4.getText());
                    sb.append("," + (solution[current] + 1));
                    playeraL4.setText(sb.toString());
                } else {
                    StringBuilder sb = new StringBuilder(playerbL3.getText());
                    sb.append("+" + array2d[solution[current]][solution[current]]);
                    playerbL3.setText(sb.toString());
                    dataHbox.getChildren().get(solution[current]).setStyle("-fx-background-color: blue;");
                    sb = new StringBuilder(playerbL4.getText());
                    sb.append("," + (solution[current] + 1));
                    playerbL4.setText(sb.toString());
                }
                current++;
            }
        });

        previousB.setOnAction(e -> {
            if (current > 0) {
                flag = 0;
                if (current % 2 != 0) {
                    StringBuilder sb = new StringBuilder(playeraL3.getText());
                    sb.delete(sb.lastIndexOf("+"), sb.length());
                    playeraL3.setText(sb.toString());
                    sb = new StringBuilder(playeraL4.getText());
                    sb.delete(sb.lastIndexOf(","), sb.length());
                    playeraL4.setText(sb.toString());
                } else {
                    StringBuilder sb = new StringBuilder(playerbL3.getText());
                    sb.delete(sb.lastIndexOf("+"), sb.length());
                    playerbL3.setText(sb.toString());
                    sb = new StringBuilder(playerbL4.getText());
                    sb.delete(sb.lastIndexOf(","), sb.length());
                    playerbL4.setText(sb.toString());
                }
                current--;
                dataHbox.getChildren().get(solution[current]).setStyle("-fx-background-color: white;");
            }
        });

        playpauseB.setOnAction(e -> {
            Motion timer = new Motion();
            if (flag == 0) {
                flag = 1;
                timer.start();
            } else if (flag == 1) {
                flag = 0;
            }
        });

        funcB.setOnAction(e -> {
            resultvbox.getChildren().removeAll(playeraHBox, hSeperator2, playerbHBox, hSeperator3, mediaHBox,
                    hSeperator4);
            resultvbox.getChildren().addAll(funcimg);
            buttonsHbox.getChildren().removeAll(dbtableB, funcB);
        });
        // ===========================================================================================

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void pickCoins(int[] coins) {
        int n = coins.length;
        array2d = new int[n][n];
        arrows2d = new int[n][n];
        Label tmplabel = new Label();
        tmplabel.setText("i \\ j");
        tmplabel.setAlignment(Pos.CENTER);
        tmplabel.setFont(new Font("Arial", 19));
        tmplabel.setPrefSize(70, 70);
        tmplabel.setTextFill(Color.WHITE);
        dptable = new GridPane();
        dptable.setAlignment(Pos.CENTER);
        dptable.setHgap(10);
        dptable.setVgap(10);
        dptable.add(tmplabel, 0, 0);
        for (int i = 1; i <= n; i++) {
            tmplabel = new Label();
            tmplabel.setText(Integer.toString(i) + "  |");
            tmplabel.setAlignment(Pos.CENTER);
            tmplabel.setFont(new Font("Arial", 19));
            tmplabel.setPrefSize(70, 70);
            tmplabel.setTextFill(Color.WHITE);
            dptable.add(tmplabel, 0, i);
            tmplabel = new Label();
            tmplabel.setText(Integer.toString(i) + "\n―");
            tmplabel.setAlignment(Pos.CENTER);
            tmplabel.setFont(new Font("Arial", 19));
            tmplabel.setPrefSize(70, 70);
            tmplabel.setTextFill(Color.WHITE);
            dptable.add(tmplabel, i, 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    array2d[i][j] = coins[i];
                    tmplabel = new Label();
                    tmplabel.setText(Integer.toString(coins[i]));
                    tmplabel.setAlignment(Pos.CENTER);
                    tmplabel.setFont(new Font("Arial", 19));
                    tmplabel.setStyle("-fx-border-color: red; -fx-border-width: 1");
                    tmplabel.setPrefSize(70, 70);
                    tmplabel.setTextFill(Color.WHITE);
                    dptable.add(tmplabel, i + 1, j + 1);
                } else {
                    int opleft;
                    int opdown;
                    if (i + 2 > coins.length - 1) {
                        opleft = coins[i] + Math.min(0, array2d[i + 1][j - 1]);
                    } else {
                        opleft = coins[i] + Math.min(array2d[i + 2][j], array2d[i + 1][j - 1]);
                    }
                    if (j - 2 < 0) {
                        opdown = coins[j] + Math.min(array2d[i + 1][j - 1], 0);
                    } else {
                        opdown = coins[j] + Math.min(array2d[i + 1][j - 1], array2d[i][j - 2]);
                    }
                    if (opleft > opdown || ((opleft == opdown) && ((coins[i + 1] < coins[j - 1])
                            || ((coins[i] >= coins[j]) && (coins[i + 1] == coins[j - 1]))))) {
                        array2d[i][j] = opleft;
                        arrows2d[i][j] = 1;
                        tmplabel = new Label();
                        tmplabel.setText(Integer.toString(opleft) + "←");
                        tmplabel.setAlignment(Pos.CENTER);
                        tmplabel.setFont(new Font("Arial", 19));
                        if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
                            tmplabel.setStyle("-fx-border-color: green; -fx-border-width: 1");
                        } else {
                            tmplabel.setStyle("-fx-border-color: blue; -fx-border-width: 1");
                        }
                        tmplabel.setPrefSize(70, 70);
                        tmplabel.setTextFill(Color.WHITE);
                        dptable.add(tmplabel, j + 1, i + 1);
                    } else {
                        array2d[i][j] = opdown;
                        arrows2d[i][j] = 2;
                        tmplabel = new Label();
                        tmplabel.setText(Integer.toString(opdown) + "↓");
                        tmplabel.setAlignment(Pos.CENTER);
                        tmplabel.setFont(new Font("Arial", 19));
                        if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
                            tmplabel.setStyle("-fx-border-color: green; -fx-border-width: 1");
                        } else {
                            tmplabel.setStyle("-fx-border-color: blue; -fx-border-width: 1");
                        }
                        tmplabel.setPrefSize(70, 70);
                        tmplabel.setTextFill(Color.WHITE);
                        dptable.add(tmplabel, j + 1, i + 1);
                    }
                }
            }
        }
        solution = new int[n];
        int i = 0;
        int j = n - 1;
        int counter = 0;
        for (int k = 0; k < 2; k++) {
            while (i <= j) {
                if (arrows2d[i][j] == 1) {
                    solution[counter] = i;
                    if (i + 2 <= j) {
                        if (array2d[i + 1][j - 1] == array2d[i + 2][j]) {
                            if (arrows2d[i + 1][j - 1] == 1) {
                                if (arrows2d[i + 2][j] == 1) {
                                    if (array2d[i + 1][i + 1] >= array2d[i + 2][i + 2]) {
                                        i = i + 2;
                                    } else {
                                        i++;
                                        j--;
                                    }
                                } else {
                                    if (array2d[i + 1][i + 1] >= array2d[j][j]) {
                                        i = i + 2;
                                    } else {
                                        i++;
                                        j--;
                                    }
                                }
                            } else {
                                if (arrows2d[i + 2][j] == 1) {
                                    if (array2d[j - 1][j - 1] == array2d[i + 2][i + 2]) {
                                        if (arrows2d[i + 1][j] == 1) {
                                            i = i + 2;
                                        } else {
                                            j--;
                                            i++;
                                        }
                                    } else if (array2d[j - 1][j - 1] > array2d[i + 2][i + 2]) {
                                        i = i + 2;
                                    } else {
                                        i++;
                                        j--;
                                    }
                                } else {
                                    if (array2d[j - 1][j - 1] >= array2d[j][j]) {
                                        i = i + 2;
                                    } else {
                                        i++;
                                        j--;
                                    }
                                }
                            }
                        } else if (array2d[i + 1][j - 1] > array2d[i + 2][j]) {
                            i = i + 2;
                        } else {
                            i++;
                            j--;
                        }
                    } else {
                        break;
                    }
                } else if (arrows2d[i][j] == 2) {
                    solution[counter] = j;
                    if (j - 2 >= i) {
                        if (array2d[i + 1][j - 1] == array2d[i][j - 2]) {
                            if (arrows2d[i + 1][j - 1] == 1) {
                                if (arrows2d[i][j - 2] == 1) {
                                    if (array2d[i + 1][i + 1] >= array2d[i][i]) {
                                        j = j - 2;
                                    } else {
                                        i++;
                                        j--;
                                    }
                                } else {
                                    if (array2d[i + 1][i + 1] == array2d[j - 2][j - 2]) {
                                        if (arrows2d[i][j - 1] == 1) {
                                            i++;
                                            j--;
                                        } else {
                                            j = j - 2;
                                        }
                                    } else if (array2d[i + 1][i + 1] > array2d[j - 2][j - 2]) {
                                        j = j - 2;
                                    } else {
                                        i++;
                                        j--;
                                    }
                                }
                            } else {
                                if (arrows2d[i][j - 2] == 1) {
                                    if (array2d[j - 1][j - 1] == array2d[i][i]) {
                                        if (arrows2d[i][j - 1] == 1) {
                                            i++;
                                            j--;
                                        } else {
                                            j = j - 2;
                                        }
                                    } else if (array2d[j - 1][j - 1] > array2d[i][i]) {
                                        j = j - 2;
                                    } else {
                                        i++;
                                        j--;
                                    }
                                } else {
                                    if (array2d[j - 1][j - 1] >= array2d[j - 2][j - 2]) {
                                        j = j - 2;
                                    } else {
                                        i++;
                                        j--;
                                    }
                                }
                            }
                        } else if (array2d[i + 1][j - 1] > array2d[i][j - 2]) {
                            j = j - 2;
                        } else {
                            i++;
                            j--;
                        }
                    } else {
                        break;
                    }
                } else {
                    solution[counter] = i;
                    break;
                }
                counter = counter + 2;
            }
            if (array2d[0][n - 2] == array2d[1][n - 1]) {
                if (arrows2d[0][n - 1] == 1) {
                    i = 1;
                    j = n - 1;
                } else {
                    i = 0;
                    j = n - 2;
                }
            } else if (array2d[0][n - 2] < array2d[1][n - 1]) {
                i = 0;
                j = n - 2;
            } else {
                i = 1;
                j = n - 1;
            }
            counter = 1;
        }
    }
}