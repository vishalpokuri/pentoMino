import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PieceUtils {
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
    Set<String> seen = new HashSet<>();

    // Logic to remove duplicates
    // Step -1: Use serialize function to convert into a string, check if it
    // not contains in the set, add or skip

    for (int i = 0; i < 4; i++) {
      piece = rotate(piece);
      if (!seen.contains(serialise(piece))) {
        results.add(piece);
        seen.add(serialise(piece));
      }
    }
    // Remove duplicates (optional if you want to deduplicate orientations)
    // for (var item : results) {
    // display(item);
    // System.out.println();
    // }
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

  public static String serialise(int[][] orientation) {
    StringBuilder sb = new StringBuilder();
    for (int[] row : orientation) {
      for (int item : row) {
        sb.append(item);
      }
      sb.append(";");
    }
    return sb.toString();
  }

  public static int[] emptyCellonBoard(int[][] board) {
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == 0) {
          return new int[] { i, j };
        }
      }
    }
    return new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE };
  }

  // collision function, and piece start index picker
  public static int[] touchablePieceIndex(int[][] piece) {
    for (int i = 0; i < piece.length; i++) {
      for (int j = 0; j < piece[0].length; j++) {
        if (piece[i][j] == 1) {
          return new int[] { i, j };
        }
      }
    }
    return new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE };
  }

  public static boolean collision(int[][] board, int[][] piece) {
    int[] cell = emptyCellonBoard(board); // [row, col]
    int[] anchor = touchablePieceIndex(piece); // [row, col] in the piece

    int baseRow = cell[0] - anchor[0];
    int baseCol = cell[1] - anchor[1];

    for (int i = 0; i < piece.length; i++) {
      for (int j = 0; j < piece[0].length; j++) {
        if (piece[i][j] == 1) {
          int r = baseRow + i;
          int c = baseCol + j;
          // boundary check
          if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return true;
          }
          // collision check
          if (board[r][c] + piece[i][j] != 1) {
            return true;
          }
        }
      }
    }

    return false;
    // TODO: missing update the piece on the board by filling ones
  }

}
