import java.util.*;

public class Pintomino {
  public static int[][] board;

  public static final Map<String, int[]> revealMap = Map.ofEntries(
      Map.entry("Jan", new int[] { 0, 0 }),
      Map.entry("Feb", new int[] { 0, 1 }),
      Map.entry("Mar", new int[] { 0, 2 }),
      Map.entry("Apr", new int[] { 0, 3 }),
      Map.entry("1", new int[] { 0, 4 }),
      Map.entry("2", new int[] { 0, 5 }),
      Map.entry("3", new int[] { 0, 6 }),
      Map.entry("Mon", new int[] { 0, 7 }),
      Map.entry("Tue", new int[] { 0, 8 }),
      Map.entry("May", new int[] { 1, 0 }),
      Map.entry("4", new int[] { 1, 1 }),
      Map.entry("5", new int[] { 1, 2 }),
      Map.entry("6", new int[] { 1, 3 }),
      Map.entry("7", new int[] { 1, 4 }),
      Map.entry("8", new int[] { 1, 5 }),
      Map.entry("9", new int[] { 1, 6 }),
      Map.entry("Wed", new int[] { 1, 7 }),
      Map.entry("Jun", new int[] { 2, 0 }),
      Map.entry("10", new int[] { 2, 1 }),
      Map.entry("11", new int[] { 2, 2 }),
      Map.entry("12", new int[] { 2, 3 }),
      Map.entry("13", new int[] { 2, 4 }),
      Map.entry("31", new int[] { 2, 5 }),
      Map.entry("15", new int[] { 2, 6 }),
      Map.entry("Thu", new int[] { 2, 7 }),
      Map.entry("Jul", new int[] { 3, 0 }),
      Map.entry("16", new int[] { 3, 1 }),
      Map.entry("17", new int[] { 3, 2 }),
      Map.entry("18", new int[] { 3, 3 }),
      Map.entry("19", new int[] { 3, 4 }),
      Map.entry("20", new int[] { 3, 5 }),
      Map.entry("21", new int[] { 3, 6 }),
      Map.entry("Fri", new int[] { 3, 7 }),
      Map.entry("Sat", new int[] { 3, 8 }),
      Map.entry("Aug", new int[] { 4, 0 }),
      Map.entry("22", new int[] { 4, 1 }),
      Map.entry("23", new int[] { 4, 2 }),
      Map.entry("24", new int[] { 4, 3 }),
      Map.entry("25", new int[] { 4, 4 }),
      Map.entry("26", new int[] { 4, 5 }),
      Map.entry("27", new int[] { 4, 6 }),
      Map.entry("Sep", new int[] { 5, 0 }),
      Map.entry("Oct", new int[] { 5, 1 }),
      Map.entry("Nov", new int[] { 5, 2 }),
      Map.entry("Dec", new int[] { 5, 3 }),
      Map.entry("28", new int[] { 5, 4 }),
      Map.entry("29", new int[] { 5, 5 }),
      Map.entry("30", new int[] { 5, 6 }),
      Map.entry("14", new int[] { 5, 7 }),
      Map.entry("X", new int[] { 5, 8 }));

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

  // need to get the anchored values on the board

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
