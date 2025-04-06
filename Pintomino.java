public class Pintomino {
  public static int[][] board;

  public static void display(int[][] board) {
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    board = new int[6][9];

    // Board filling
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 9; j++) {
        if ((i == 4 && j == 8) || (i == 5 && j == 8)) {
          board[i][j] = -1;
        } else {
          board[i][j] = 0;
        }
      }
    }

    display(board);
  }
}
