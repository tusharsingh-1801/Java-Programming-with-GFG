class Solution {

    void helper(int[][] maze, int r, int c, String path,
                ArrayList<String> ans, boolean[][] vis) {

        int n = maze.length;

        if (r < 0 || c < 0 || r >= n || c >= n ||
            maze[r][c] == 0 || vis[r][c] == true) {
            return;
        }

        if (r == n - 1 && c == n - 1) {
            ans.add(path);
            return;
        }

        vis[r][c] = true;

        // D
        helper(maze, r + 1, c, path + "D", ans, vis);

        // L
        helper(maze, r, c - 1, path + "L", ans, vis);

        // R
        helper(maze, r, c + 1, path + "R", ans, vis);

        // U
        helper(maze, r - 1, c, path + "U", ans, vis);

        vis[r][c] = false;
    }

    public ArrayList<String> ratInMaze(int[][] maze) {

        int n = maze.length;

        ArrayList<String> ans = new ArrayList<>();

        boolean[][] vis = new boolean[n][n];

        helper(maze, 0, 0, "", ans, vis);

        return ans;
    }
}