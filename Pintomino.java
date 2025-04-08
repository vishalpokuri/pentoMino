import java.util.*;

public class Pintomino {
  public static int[][] board;
  public static ArrayList<ArrayList<int[][]>> allOrientations;

  public static void main(String args[]) {
    board = new int[6][9];

    // Board filling
    PieceUtils.initialiseBoard(board);
    PieceUtils.display(board);

    // used pieces tracking
    int[] used = new int[10];
    Arrays.fill(used, 0);

    // All the orientations with indexing
    allOrientations = PieceUtils.returnAllOrientations();

    // Take user input
    // Scanner scan = new Scanner(System.in);
    // System.out.println("Enter the date you want");
    // String date = scan.nextLine();
    // System.out.println("Enter the day you want");
    // String day = scan.nextLine();
    // System.out.println("Enter the month you want");
    // String month = scan.nextLine();

    String date = "31";
    String day = "Tue";
    String month = "Mar";

    int[] idxDate = PieceUtils.findrevealMapIdx(date);
    int[] idxDay = PieceUtils.findrevealMapIdx(day);
    int[] idxMonth = PieceUtils.findrevealMapIdx(month);

    // fix the positions on board
    PieceUtils.fixPositions(idxMonth, board);
    PieceUtils.fixPositions(idxDate, board);
    PieceUtils.fixPositions(idxDay, board);

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
