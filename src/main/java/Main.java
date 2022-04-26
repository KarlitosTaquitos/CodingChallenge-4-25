import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        GridUtil gridUtil = new GridUtil();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("How big is the grid for the robot? ");
        int size = Integer.parseInt(reader.readLine());

        boolean[][] grid = gridUtil.generateGrid(size);
        printGrid(grid);

        String path = gridUtil.createPath(grid);

        System.out.println(path);
    }

    public static void printGrid(boolean[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j])
                    System.out.print("_");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }
}
