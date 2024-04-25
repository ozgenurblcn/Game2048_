import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Game2048 extends Application {
  
  private int size = 4; // Boyutu belirleyebilirsiniz (4x4 gibi)
  
  private int[][] board;
  private Button[][] buttons;
  
  public void start(Stage primaryStage) {
    board = new int[size][size];
    buttons = new Button[size][size];
    
    GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    
    // Butonlarý oluþturma ve grid'e ekleme
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        Button button = new Button();
        button.setMinSize(100, 100);
        button.setFont(Font.font(24));
        buttons[i][j] = button;
        gridPane.add(button, j, i);
      }
    }
    
    generateNewNumber();
    generateNewNumber();
    updateButtons();
    
    Scene scene = new Scene(gridPane);
    scene.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.UP) {
        moveUp();
      } else if (e.getCode() == KeyCode.DOWN) {
        moveDown();
      } else if (e.getCode() == KeyCode.LEFT) {
        moveLeft();
      } else if (e.getCode() == KeyCode.RIGHT) {
        moveRight();
      }
      updateButtons();
      if (isGameOver()) {
        System.out.println("Oyun bitti!");
      }
    });
    
    primaryStage.setTitle("2048");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  private void updateButtons() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int value = board[i][j];
        Button button = buttons[i][j];
        if (value == 0) {
          button.setText("");
        } else {
          button.setText(String.valueOf(value));
        }
      }
    }
  }
  
  private void generateNewNumber() {
    int emptyCount = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (board[i][j] == 0) {
          emptyCount++;
        }
      }
    }
    if (emptyCount == 0) {
      return;
    }
    int index = (int) (Math.random() * emptyCount) + 1;
    emptyCount = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (board[i][j] == 0) {
          emptyCount++;
          if (emptyCount == index) {
            board[i][j] = Math.random() < 0.9 ? 2 : 4;
            return;
          }
        }
      }
    }
  }
  
  private void moveUp() {
    boolean moved = false;
    for (int j = 0; j < size; j++) {
      int index = 0;
      for (int i = 1; i < size; i++) {
        if (board[i][j] != 0) {
          if (board[i][j] == board[index][j]) {
            board[index][j] *= 2;
            board[i][j] = 0;
            moved = true;
          } else if (board[index][j] == 0) {
            board[index][j] = board[i][j];
            board[i][j] = 0;
            moved = true;
          } else {
            index++;
            if (i != index) {
              board[index][j] = board[i][j];
              board[i][j] = 0;
              moved = true;
            }
          }
        }
      }
    }
    if (moved) {
      generateNewNumber();
    }
  }
  
  private void moveDown() {
    boolean moved = false;
    for (int j = 0; j < size; j++) {
      int index = size - 1;
      for (int i = size - 2; i >= 0; i--) {
        if (board[i][j] != 0) {
          if (board[i][j] == board[index][j]) {
            board[index][j] *= 2;
            board[i][j] = 0;
            moved = true;
          } else if (board[index][j] == 0) {
            board[index][j] = board[i][j];
            board[i][j] = 0;
            moved = true;
          } else {
            index--;
            if (i != index) {
              board[index][j] = board[i][j];
              board[i][j] = 0;
              moved = true;
            }
          }
        }
      }
    }
    if (moved) {
      generateNewNumber();
    }
  }
  
  private void moveLeft() {
    boolean moved = false;
    for (int i = 0; i < size; i++) {
      int index = 0;
      for (int j = 1; j < size; j++) {
        if (board[i][j] != 0) {
          if (board[i][j] == board[i][index]) {
            board[i][index] *= 2;
            board[i][j] = 0;
            moved = true;
          } else if (board[i][index] == 0) {
            board[i][index] = board[i][j];
            board[i][j] = 0;
            moved = true;
          } else {
            index++;
            if (j != index) {
              board[i][index] = board[i][j];
              board[i][j] = 0;
              moved = true;
            }
          }
        }
      }
    }
    if (moved) {
      generateNewNumber();
    }
  }
  
  private void moveRight() {
    boolean moved = false;
    for (int i = 0; i < size; i++) {
      int index = size - 1;
      for (int j = size - 2; j >= 0; j--) {
        if (board[i][j] != 0) {
          if (board[i][j] == board[i][index]) {
            board[i][index] *= 2;
            board[i][j] = 0;
            moved = true;
          } else if (board[i][index] == 0) {
            board[i][index] = board[i][j];
            board[i][j] = 0;
            moved = true;
          } else {
            index--;
            if (j != index) {
              board[i][index] = board[i][j];
              board[i][j] = 0;
              moved = true;
            }
          }
        }
      }
    }
    if (moved) {
      generateNewNumber();
    }
  }
  
  private boolean isGameOver() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (board[i][j] == 0) {
          return false;
        }
        if (i > 0 && board[i][j] == board[i - 1][j]) {
          return false;
        }
        if (i < size - 1 && board[i][j] == board[i + 1][j]) {
          return false;
        }
        if (j > 0 && board[i][j] == board[i][j - 1]) {
          return false;
        }
        if (j < size - 1 && board[i][j] == board[i][j + 1]) {
          return false;
        }
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}
