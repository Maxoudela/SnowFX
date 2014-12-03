SnowFX
======

A simple class to add some snow to your JavaFX application! I used many lines of code of https://github.com/skrb/JavaFXChristmasCard but I couldn't make it work properly so I made my own project.

The class SnowFX will allow you to add some snow to your application. Simply give your Pane you want snow in into the constructor. Then SnowFX will encapsulate your pane and you just have to add SnowFX at the place where you wanted to place your Pane.

![alt tag](http://i.imgur.com/U3rbYOA.png)

## Code example : 
```java
VBox box = new VBox(10);
  box.setStyle("-fx-background-color : cornflowerblue;");

  for (int i = 0; i < 10; ++i) {

      Label label = new Label("This is a test label");
      TextField textField = new TextField();
      HBox hbox = new HBox(label, textField);
      box.getChildren().add(hbox);
  }
  SnowFX snowFX = new SnowFX(box);

  Button button = new Button("Make it snow!");
  button.setOnAction((ActionEvent event) -> {
      snowFX.showSnow(!snowFX.isSnowing());
  });

  box.getChildren().add(button);

  Scene scene = new Scene(snowFX);
  primaryStage.setScene(scene);
  primaryStage.show();
  ```
