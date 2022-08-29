//200. Number of Islands
//https://leetcode.com/problems/number-of-islands/
class NumberOfIslands {

    fun numIslands(grid: Array<CharArray>): Int {
        val visited = Array(grid.size) { IntArray(grid[0].size) { 0 } }
        var result = 0;
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    result++
                    findWater(i, j, grid, visited)
                }
            }
        }
        return result
    }

    private fun findWater(i: Int, j: Int, grid: Array<CharArray>, visited: Array<IntArray>) {
        if (grid[i][j] == '1' && visited[i][j] == 0) {
            visited[i][j] = 1
            if (j + 1 < grid[i].size) { findWater(i, j + 1, grid, visited) }
            if (i + 1 < grid.size) { findWater(i + 1, j, grid, visited) }
            if (i - 1 >= 0) { findWater(i - 1, j, grid, visited) }
            if (j - 1 >= 0) { findWater(i, j - 1, grid, visited) }
        }
    }

}