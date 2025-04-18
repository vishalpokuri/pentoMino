import java.util.*;

public class Pentomino {
  public static int[][] board;
  public static int[] used;
  public static int[] usedOtn;
  public static ArrayList<ArrayList<int[][]>> allOrientations;

  public static void main(String args[]) {
    board = new int[6][9];

    // Board filling
    PieceUtils.initialiseBoard(board);

    System.out.println();

    // used pieces tracking
    used = new int[10];
    usedOtn = new int[10];
    Arrays.fill(used, 0);

    // All the orientations with indexing
    allOrientations = PieceUtils.returnAllOrientations();

    // Take user input
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the date you want");
    String date = scan.nextLine();
    System.out.println("Enter the day you want");
    String day = scan.nextLine();
    System.out.println("Enter the month you want");
    String month = scan.nextLine();

    int[] idxDate = PieceUtils.findrevealMapIdx(date);
    int[] idxDay = PieceUtils.findrevealMapIdx(day);
    int[] idxMonth = PieceUtils.findrevealMapIdx(month);

    // fix the positions on board
    PieceUtils.fixPositions(idxMonth, board);
    PieceUtils.fixPositions(idxDate, board);
    PieceUtils.fixPositions(idxDay, board);

    recursion(board);
    scan.close();
  }

  public static boolean recursion(int[][] board) {
    // Find the first empty cell
    int[] cell = PieceUtils.emptyCellonBoard(board);

    // basecase
    if (cell[0] == Integer.MIN_VALUE) {
      System.out.println("Solution found!");

      PieceUtils.displayColorful(board);
      return true;
    }

    // recursion
    for (int i = 0; i < 10; i++) {
      if (used[i] == 1)
        continue;

      ArrayList<int[][]> otnsOfi = allOrientations.get(i);
      for (int j = 0; j < otnsOfi.size(); j++) {
        int[][] selectedPiece = otnsOfi.get(j);

        if (PieceUtils.placePiece(board, selectedPiece, cell, i + 1)) { // also sending the pieceId
          used[i] = 1;
          if (recursion(board)) {
            return true;
          }

          used[i] = 0;
          PieceUtils.removePiece(board, selectedPiece, cell);
        }
      }
    }

    return false;
  }
}
