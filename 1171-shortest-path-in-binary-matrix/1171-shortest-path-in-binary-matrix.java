class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] != 0 || grid[n - 1][m - 1] != 0) return -1;

        boolean[][] visited = new boolean[n][m];
        int[][] depth = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new int[]{0, 0});
        int[][] locations = {{-1, -1}, {-1, 0}, {-1, 1}, {1, 0}, {0, -1}, {0, 1}, {1, -1}, {1, 1}};
        while (!queue.isEmpty()) {
            int[] vertex = queue.poll();
            for (int[] location : locations) {
                int x = vertex[0] + location[0];
                int y = vertex[1] + location[1];
                if ((x >= 0 && x < m) && (y >= 0 && y < n)
                        && !visited[x][y] && grid[x][y] == 0) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                    depth[x][y] = depth[vertex[0]][vertex[1]] + 1;
                }
            }
        }
        return visited[n - 1][m - 1] ? depth[n - 1][m - 1] + 1 : -1;
    }
}