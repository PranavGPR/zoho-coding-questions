import java.util.Scanner;

public class RotateMatrix {
    static int R;
    static int C;

    private static void rotateMatrix(int m, int n, int mat[][]) {
        int row = 0, col = 0;
        int prev, curr;

        while (row < m && col < n) {
            if (row + 1 == m || col + 1 == n) {
                break;
            }

            prev = mat[row + 1][col];

            for (int i = col; i < n; i++) {
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;

            for (int i = row; i < m; i++) {
                curr = mat[i][n - 1];
                mat[i][n - 1] = prev;
                prev = curr;
            }
            n--;

            if (row < m) {
                for (int i = n - 1; i >= col; i--) {
                    curr = mat[m - 1][i];
                    mat[m - 1][i] = prev;
                    prev = curr;
                }
            }
            m--;

            if (col < n) {
                for (int i = m - 1; i >= row; i--) {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        }
    }

    private static void displayMatrix(int m, int n, int mat[][]) {
        System.out.println("\nRotated Matrix:");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int rotate;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows of the matrix: ");
        R = sc.nextInt();

        System.out.print("\nEnter the number of columns of the matrix: ");
        C = sc.nextInt();

        int mat[][] = new int[R][C];

        System.out.print("\nEnter the elements of the matrix...");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print("\nElement[" + i + "][" + j + "] : ");
                mat[i][j] = sc.nextInt();
                System.out.println();
            }
        }

        System.out.print("Enter the number of rotations need to be done: ");
        rotate = sc.nextInt();

        sc.close();

        for (int i = 0; i < rotate; i++)
            rotateMatrix(R, C, mat);

        displayMatrix(R, C, mat);
    }
}
