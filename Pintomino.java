import java.util.ArrayList;

public class Pintomino {
  public static int[][] board;

  public static void display(int[][] item) {
    for (var x : item) {
      for (var i : x) {
        if (i == 1) {

          System.out.print(i + " ");
        } else {
          System.out.print("  ");

        }
      }
      System.out.println();
    }
  }

  public static ArrayList<int[][]> getAllOrientations(int[][] piece) {
    ArrayList<int[][]> results = new ArrayList<>();

    for (int i = 0; i < 4; i++) {
      piece = rotate(piece);
      results.add(piece);
    }
    // Remove duplicates (optional if you want to deduplicate orientations)
    for (var item : results) {
      display(item);
      System.out.println();
    }
    return results;
  }

  public static int[][] rotate(int[][] piece) {
    int row = piece.length;
    int col = piece[0].length;

    int[][] rotated = new int[col][row];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        rotated[j][row - 1 - i] = piece[i][j];
      }
    }
    return rotated;
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
    ArrayList<int[][]> orientsPieceTap = getAllOrientations(pieceTap);
    ArrayList<int[][]> orientsPieceI = getAllOrientations(pieceI);
    ArrayList<int[][]> orientsPieceBaton = getAllOrientations(pieceBaton);
    ArrayList<int[][]> orientsPieceL2x4 = getAllOrientations(pieceL2x4);
    ArrayList<int[][]> orientsPieceBend2x4 = getAllOrientations(pieceBend2x4);
    ArrayList<int[][]> orientsPieceBend3x3 = getAllOrientations(pieceBend3x3);
    ArrayList<int[][]> orientsPieceBuilding = getAllOrientations(pieceBuilding);
    ArrayList<int[][]> orientsPieceL3x3 = getAllOrientations(pieceL3x3);
    ArrayList<int[][]> orientsPieceU = getAllOrientations(pieceU);
    ArrayList<int[][]> orientsPieceT = getAllOrientations(pieceT);

    // Need to find a logic to remove duplicates

  }

}
