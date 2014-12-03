SnowFX
======

A simple class to add some snow to your JavaFX application! 

I used many lines of code of https://github.com/skrb/JavaFXChristmasCard but I couldn't make it work properly so I made my own project.

The class SnowFX will allow you to add some snow to your application.

1) Take a Pane where you want snow (Vbox, Hbox, BorderPane etc).   
2) Give it to SnowFX.   
3) Add SnowFX (it extends BorderPane) where you would have normally placed your Pane.   
4) Enjoy the snow and relax :)

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
