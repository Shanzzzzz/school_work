public class Knapsack {
    public static int maxProfit(int C, int N, int[] w, int[] p) {
        int[][] dp = new int[C+1][N+1];

        // Initialize initial values
        for(int i=0; i<N+1; i++){
            dp[0][i] = 0;
        }
        for(int i=1; i<C+1; i++){
            dp[i][0] = 0;
        }

        for(int c=1; c<C+1; c++){
            for(int n=1; n<N+1; n++){
                dp[c][n] = dp[c][n-1]; // Exclude n'th item
                if(w[n] <= c){ // Enough space to fit n'th itrm
                    if(dp[c][n] < dp[ c-w[n] ][n] + p[n]){
                        dp[c][n] = dp[ c-w[n] ][n] + p[n];
                    }
                }
            }
        }
        
        //print2d(dp);

        return dp[C][N];
    }

    public static void print2d(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
