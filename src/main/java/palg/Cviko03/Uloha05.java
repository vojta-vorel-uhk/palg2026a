package palg.Cviko03;

public class Uloha05
{
    public static void main(String[] args)
    {
        double[][] matrix0 = {
                {1.0, 1.5, 2.5, 2.7, 1.7, 2.54, 2.75, 1.775},
                {1.9, 2.1, 4.0, 4.0, 4.6, 8.88, 2.1, 3.9},
                {8.8, 2.1, 3.9, 8.1, 11.6, 2.18, 4.04, 4.6},
                {10.9, 2.1, 2.1, 4.0, 4.6, 3.1, 7.2, 7.11},
                {0.1, 3.1, 7.2, 7.1, 9.6, 17.72, 5.62, 6.15}};
        print(matrix0);
    }

    // TODO: Doplň metodu, která vypíše prvky matice do konzole
    public static void print(double[][] matrix)
    {
        for(int row = 0; row < matrix.length; row++ ){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.printf("%6.2f",matrix[row][col]);
            }
            System.out.println();
        }
    }
}
