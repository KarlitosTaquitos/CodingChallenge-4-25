import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GridUtil {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean[][] generateGrid(int size) {
        System.out.println("Generating grid");
        boolean[][] grid = new boolean[size][size];

        // marking true or false whether the point is valid
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (Math.random() > 0.2)
                    grid[i][j] = true;
                else
                    grid[i][j] = false;

        // 0, 0 is always valid
        grid[0][0] = true;

        // final point is always valid
        grid[size - 1][size - 1] = true;

        return grid;
    }

    public String createPath(boolean[][] grid) {
        List<Point> validPoints = getValidPoints(grid);
        List<Point> invalidPoints = getInvalidPoints(grid);

        List<Point> pointsToCheck = new ArrayList<>();
        pointsToCheck.add(validPoints.get(0));

        List<Point> pathList = new ArrayList<>();

        int gridSize = grid.length;
        Point finalPoint = new Point(gridSize - 1, gridSize - 1);

        System.out.println("Searching...\n");
        while (!pointsToCheck.isEmpty()) {
            Point currentPoint = pointsToCheck.remove(0);

            Point rightSide = new Point(currentPoint.x + 1, currentPoint.y);

            Point bottomSide = new Point(currentPoint.x, currentPoint.y + 1);

            if (validPoints.contains(rightSide))
                pointsToCheck.add(rightSide);
            if (validPoints.contains(bottomSide))
                pointsToCheck.add(bottomSide);

            if (pointsToCheck.contains(finalPoint))
                break;
        }

        if (pointsToCheck.contains(finalPoint))
            return "The robot can reach the end!";
        else
            return "The robot is blocked in.";
    }

    public List<Point> getValidPoints(boolean[][] grid) {
        List<Point> valids = new ArrayList<>();

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++)
                if (grid[i][j])
                    valids.add(new Point(i, j));

        return valids;
    }

    public List<Point> getInvalidPoints(boolean[][] grid) {
        List<Point> invalids = new ArrayList<>();

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++)
                if (!grid[i][j])
                    invalids.add(new Point(i, j));

        return invalids;
    }
}
