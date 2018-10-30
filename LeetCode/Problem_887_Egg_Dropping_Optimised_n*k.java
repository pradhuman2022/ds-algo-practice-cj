class Solution {
    public static void main(String[] args) {
        System.out.println("Answer: " + computeEggDroppingProblem(15, 10));
    }

    public static int computeEggDroppingProblem(int n, int e) {
        int [][] m = new int[e + 1][n + 1];

        // fill the base case for the first egg and all floors
        for (int i = 1; i <= n; i++) {
            m[1][i] = i;
        }

        // start from the second egg and 1st floor
        for (int egg = 2; egg <= e; egg++) {
            int x = 1;
            for (int floor = 1; floor <= n; floor++) {
                // start from floor 1 and go to current floor.
                while (x < floor && Math.max(m[egg - 1][x-1], m[egg][floor-x]) > Math.max(m[egg - 1][x], m[egg][floor-x-1]))
                    x++;
                m[egg][floor] = 1 + Math.max(m[egg - 1][x-1], m[egg][floor-x]);               
            }
        }

        for (int i = 0; i < e + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        return m[e][n];
    }
}