
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix to a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");
            int input = reader.nextInt();
            if (input == 0) {
                break;
            } else if (input == 1) {
                add(reader);
            } else if (input == 2) {
                cmultiply(reader);
            } else if (input == 3) {
                mmultiply(reader);
            } else if (input == 4) {
                transpose(reader);
            } else if (input == 5) {
                determinant(reader);
            } else if (input == 6) {
                inverse(reader);
            }
        }

    }

    public static void add(Scanner reader) {
        System.out.println("Enter size of first matrix: ");
        int a = reader.nextInt();
        int b = reader.nextInt();
        System.out.println("Enter first matrix: ");
        double[][] arr = new double[a][b];
        for (int x = 0; x < a; x++) {
            for (int j = 0; j < b; j++) {
                arr[x][j] = Double.parseDouble(reader.next());
            }
        }
        System.out.println("Enter size of second matrix: ");
        int c = reader.nextInt();
        int d = reader.nextInt();
        System.out.println("Enter second matrix: ");

        double[][] arr1 = new double[c][d];
        for (int x = 0; x < c; x++) {
            for (int j = 0; j < d; j++) {
                arr1[x][j] = Double.parseDouble(reader.next());
            }
        }
        if (a != c || b != d) {
            System.out.println("ERROR");
        } else {
            int[][] arr2 = new int[a][b];
            for (int x = 0; x < a; x++) {
                for (int j = 0; j < b; j++) {
                    System.out.print(arr[x][j] + arr1[x][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void cmultiply(Scanner reader) {
        System.out.println("Enter size of matrix: ");
        int a = reader.nextInt();
        int b = reader.nextInt();
        System.out.println("Enter matrix: ");
        double[][] arr = new double[a][b];
        for (int x = 0; x < a; x++) {
            for (int j = 0; j < b; j++) {
                arr[x][j] = Double.parseDouble(reader.next());
            }
        }
        System.out.println("Enter constant: ");
        int c = reader.nextInt();
        for (int x = 0; x < a; x++) {
            for (int j = 0; j < b; j++) {
                System.out.print(arr[x][j] * c + " ");
            }
            System.out.println();
        }
    }

    public static void mmultiply(Scanner reader) {
        System.out.println("Enter size of first matrix: ");
        int a = reader.nextInt();
        int b = reader.nextInt();
        System.out.println("Enter first matrix: ");
        double[][] arr = new double[a][b];
        for (int x = 0; x < a; x++) {
            for (int j = 0; j < b; j++) {
                arr[x][j] = Double.parseDouble(reader.next());
            }
        }
        System.out.println("Enter size of second matrix: ");
        int c = reader.nextInt();
        int d = reader.nextInt();
        System.out.println("Enter second matrix: ");

        double[][] arr1 = new double[c][d];
        for (int x = 0; x < c; x++) {
            for (int j = 0; j < d; j++) {
                arr1[x][j] = Double.parseDouble(reader.next());
            }
        }

        double[][] arr3 = new double[a][d];

        double sum = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < d; j++) {
                for (int k = 0; k < b; k++) {
                    sum += arr[i][k] * arr1[k][j];
                }
                arr3[i][j] = sum;
                sum = 0;
            }
        }

        for (int x = 0; x < a; x++) {
            for (int j = 0; j < d; j++) {
                System.out.print(arr3[x][j] + " ");
            }
            System.out.println();
        }
    }

    public static void transpose(Scanner reader) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.println("Your choice: ");

        int input = Integer.parseInt(reader.next());

        System.out.println("Enter matrix size: ");
        int a = Integer.parseInt(reader.next());
        int b = Integer.parseInt(reader.next());

        double[][] arr = new double[a][b];
        for (int x = 0; x < a; x++) {
            for (int j = 0; j < b; j++) {
                arr[x][j] = Double.parseDouble(reader.next());
            }
        }

        if (input == 1) {
            mainDiagonal(arr);
        } else if (input == 2) {
            sideDiagonal(arr);
        } else if (input == 3) {
            verticalLine(arr);
        } else if (input == 4) {
            horizontalLine(arr);
        }
    }

    private static void mainDiagonal(double[][] arr) {
        for (int x = 0; x < arr.length; x++) {
            for (int j = x; j < arr[x].length; j++) {
                double temp = arr[x][j];
                arr[x][j] = arr[j][x];
                arr[j][x] = temp;
            }
        }
        printArray(arr);
    }

    private static void sideDiagonal(double[][] arr) {
        for (int x = 0; x < arr.length; x++) {
            for (int j = 0; j < arr.length - 1 - x; j++) {
                double temp = arr[x][j];
                arr[x][j] = arr[arr.length - 1 - j][arr.length - 1 - x];
                arr[arr.length - 1 - j][arr.length - 1 - x] = temp;
            }
        }
        printArray(arr);
    }


    private static void verticalLine(double[][] arr) {
        for (int x = 0; x < arr.length; x++) {
            int start = 0;
            int end = arr.length - 1;
            while (start < end) {
                double temp = arr[x][start];
                arr[x][start] = arr[x][end];
                arr[x][end] = temp;

                start += 1;
                end -= 1;
            }
        }
        printArray(arr);
    }

    public static void horizontalLine(double[][] arr) {
        int last = arr.length - 1;
        for (int x = last / 2; x >= 0; x--) {
            double[] temp = arr[x];
            arr[x] = arr[last - x];
            arr[last - x] = temp;
        }
        printArray(arr);
    }

    public static void determinant(Scanner reader) {
        System.out.println("Enter matrix size: ");
        int a = Integer.parseInt(reader.next());
        int b = Integer.parseInt(reader.next());

        double[][] arr = new double[a][b];
        for (int x = 0; x < a; x++) {
            for (int j = 0; j < b; j++) {
                arr[x][j] = Double.parseDouble(reader.next());
            }
        }
        System.out.println(new Determinant(arr, arr.length).determinant(arr, arr.length));
    }

    public static void inverse(Scanner reader) {
        System.out.println("Enter matrix size: ");
        int a = Integer.parseInt(reader.next());
        int b = Integer.parseInt(reader.next());

        double[][] arr = new double[a][b];
        for (int x = 0; x < a; x++) {
            for (int j = 0; j < b; j++) {
                arr[x][j] = Double.parseDouble(reader.next());
            }
        }
        double [][]inversed = invert(arr);
        printArray(inversed);

    }

    public static double[][] invert(double a[][])
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];

        // Perform backward substitutions
        for (int i=0; i<n; ++i)
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.

    public static void gaussian(double a[][], int index[])
    {
        int n = index.length;
        double c[] = new double[n];

        for (int i=0; i<n; ++i)
            index[i] = i;

        for (int i=0; i<n; ++i)
        {
            double c1 = 0;
            for (int j=0; j<n; ++j)
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        int k = 0;
        for (int j=0; j<n-1; ++j)
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i)
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1)
                {
                    pi1 = pi0;
                    k = i;
                }
            }

            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)
            {
                double pj = a[index[i]][j]/a[index[j]][j];

                a[index[i]][j] = pj;

                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

    public static void printArray(double[][] arr) {
        for (int x = 0; x < arr.length; x++) {
            for (int j = 0; j < arr[x].length; j++) {
                System.out.print(arr[x][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

class Determinant {

    double A[][];
    double m[][];
    int N;

    public Determinant(double A[][], int N) {
        this.A = A;
        this.N = N;
    }

    public double[][] generateSubArray(double A[][], int N, int j1) {
        m = new double[N - 1][];
        for (int k = 0; k < (N - 1); k++)
            m[k] = new double[N - 1];

        for (int i = 1; i < N; i++) {
            int j2 = 0;
            for (int j = 0; j < N; j++) {
                if (j == j1)
                    continue;
                m[i - 1][j2] = A[i][j];
                j2++;
            }
        }
        return m;
    }

    /*
     * Calculate determinant recursively
     */
    public double determinant(double A[][], int N) {
        double res;

        // 1x1 matrix
        if (N == 1) res = A[0][0];
            // 2x2 matrix
        else if (N == 2) res = A[0][0] * A[1][1] - A[1][0] * A[0][1];
            // NxN matrix
        else {
            res = 0;
            for (int j1 = 0; j1 < N; j1++) {
                m = generateSubArray(A, N, j1);
                res += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1] * determinant(m, N - 1);
            }
        }
        return res;
    }
}
