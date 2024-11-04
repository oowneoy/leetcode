class Solution {
    static boolean[] visited;
    static Set<Boolean> visitCheck = new HashSet<Boolean>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms, 0);

        for (boolean v : visited) {
            if(!v) return false;
        }
        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int key) {
        for (int k : rooms.get(key)) {
            if(key == k) continue;
            if (!visited[k]) {
                visited[k] = true;
                dfs(rooms, k);
            }
        }
    }
}