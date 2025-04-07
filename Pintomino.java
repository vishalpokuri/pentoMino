import java.util.*;

public class Pintomino {
  public static int[][] board;

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
    // used initialization
    int[] used = new int[10];
    Arrays.fill(used, 0);

    // pieces initialization
    int[][] pieceI = { { 1 }, { 1 }, { 1 }, { 1 }, { 1 } };
    int[][] pieceBaton = { { 1, 0 }, { 1, 0 }, { 1, 1 }, { 1, 0 } };
    int[][] pieceL2x4 = { { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 1 } };
    int[][] pieceBend2x4 = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { 0, 1 } };
    int[][] pieceBend3x3 = { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 1 } };
    int[][] pieceBuilding = { { 1, 0 }, { 1, 1 }, { 1, 1 } };
    int[][] pieceL3x3 = { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 1, 1 } };
    int[][] pieceU = { { 1, 0, 1 }, { 1, 1, 1 } };
    int[][] pieceT = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 1, 0 } };
    int[][] pieceTap = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 0, 1 } };

    // Create all orentations
    ArrayList<int[][]> orientsPieceTap = PieceUtils.getAllOrientations(pieceTap);
    ArrayList<int[][]> orientsPieceI = PieceUtils.getAllOrientations(pieceI);
    ArrayList<int[][]> orientsPieceBaton = PieceUtils.getAllOrientations(pieceBaton);
    ArrayList<int[][]> orientsPieceL2x4 = PieceUtils.getAllOrientations(pieceL2x4);
    ArrayList<int[][]> orientsPieceBend2x4 = PieceUtils.getAllOrientations(pieceBend2x4);
    ArrayList<int[][]> orientsPieceBend3x3 = PieceUtils.getAllOrientations(pieceBend3x3);
    ArrayList<int[][]> orientsPieceBuilding = PieceUtils.getAllOrientations(pieceBuilding);
    ArrayList<int[][]> orientsPieceL3x3 = PieceUtils.getAllOrientations(pieceL3x3);
    ArrayList<int[][]> orientsPieceU = PieceUtils.getAllOrientations(pieceU);
    ArrayList<int[][]> orientsPieceT = PieceUtils.getAllOrientations(pieceT);
    // PieceUtils.display(orientsPieceBaton.get(2));

    // int[] cell = PieceUtils.touchablePieceIndex(orientsPieceBaton.get(2));
    // System.out.println(cell[0] + " " + cell[1]);
  }

  public static void recursion(int[][] board) {
    // basecase
    int[] cell = PieceUtils.emptyCellonBoard(board);
    if (cell[0] == Integer.MIN_VALUE && cell[1] == Integer.MIN_VALUE) {
      // solution validity check

      PieceUtils.display(board);
      return;
    }

    /*
     * Try to fit the item, if fits
     * updated used
     * go to next piece
     * 
     * If doesnt fit
     * updated used back to 0 with its right index
     * try with another orientation -> if exhausted, try with another index
     * 
     */

  }

}
