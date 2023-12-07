package pain;

import java.util.LinkedList;
import java.util.Queue;

public class FishPathFinder {

    static class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isValidMove(int x, int y, char[][] terrain) {
        int rows = terrain.length;
        int cols = terrain[0].length;
        return x >= 0 && x < rows && y >= 0 && y < cols && terrain[x][y] == '~';
    }

    static boolean findPath(char[][] terrain) {
        if (terrain == null || terrain.length == 0 || terrain[0].length == 0) {
            return false;
        }

        int rows = terrain.length;
        int cols = terrain[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0, 0));
        visited[0][0] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int x = cell.x;
            int y = cell.y;

            if (x == rows - 1 && y == cols - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (isValidMove(newX, newY, terrain) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Cell(newX, newY));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Example usage
        int length = 0, width = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the length of the terrain: ");
            length = scanner.nextInt();
            System.out.print("Enter the width of the terrain: ");
            width = scanner.nextInt();
            scanner.nextLine();
            char[][] terrain = new char[length][width];
            System.out.println("Enter the terrain:");
            for (int i = 0; i < length; i++) {
                terrain[i] = scanner.nextLine().trim().toCharArray();
            }
            scanner.close();
            boolean result = findPath(terrain);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }
}
