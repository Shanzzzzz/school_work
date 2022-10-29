import java.sql.Struct;

public class KnapsackApp {
    public static void main(String[] args) {
        int max_profit;

        int[] w1 = {0,4,6,8};
        int[] p1 = {0,7,6,9};

        max_profit = Knapsack.maxProfit(14, 3, w1, p1);
        System.out.println(max_profit);

        int[] w2 = {0,5,6,8};
        int[] p2 = {0,7,6,9};

        max_profit = Knapsack.maxProfit(14, 3, w2, p2);
        System.out.println(max_profit);
    }
}
