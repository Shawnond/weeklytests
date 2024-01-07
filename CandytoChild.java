public class CandytoChild {
    public static int minCandies(int[] ratings) {
        int n = ratings.length;
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        
        leftToRight[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            } else {
                leftToRight[i] = 1;
            }
        }
        
        rightToLeft[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            } else {
                rightToLeft[i] = 1;
            }
        }
        
        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += Math.max(leftToRight[i], rightToLeft[i]);
        }
        
        return totalCandies;
    }

    public static void main(String[] args) {
        // Test cases
        int[] ratings1 = {1, 0, 2};
        System.out.println(minCandies(ratings1)); 
        
        int[] ratings2 = {1, 2, 2};
        System.out.println(minCandies(ratings2));  
    }
}
