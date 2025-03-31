// TC: O(m * n * k)
// SC: O(m * n * k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // BFS, additional decision making factor k
    // TC = O(m * n * k), SC = O(m * n * k)
    public int shortestPath(int[][] grid, int k) {
        // null
        if(grid == null || grid.length == 0) return 0;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, k});
        visited[0][0][k] = true;
        int level = 0;
        // BFS traversal
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if(curr[0] == m - 1 && curr[1] == n - 1) return level;
                for(int[] dir : dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];
                    if(row >= 0 && row < m && col >= 0 && col < n) {
                        int K = curr[2] - grid[row][col];
                        if(K >= 0 && !visited[row][col][K]) {
                            q.add(new int[] {row, col, K});
                            visited[row][col][K] = true;
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}