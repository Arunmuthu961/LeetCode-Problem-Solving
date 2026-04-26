class Solution {
    public int maxProfit(int[] prices) {
        // We use Integer.MIN_VALUE for buy states to represent that 
        // we haven't made any purchases yet.
        int firstBuy = Integer.MIN_VALUE;
        int secondBuy = Integer.MIN_VALUE;
        
        int firstSell = 0;
        int secondSell = 0;
        
        for (int price : prices) {
            // 1. Maximize cash after first buy (spending 'price')
            firstBuy = Math.max(firstBuy, -price);
            
            // 2. Maximize profit after first sell
            firstSell = Math.max(firstSell, firstBuy + price);
            
            // 3. Maximize cash after second buy 
            // (Previous profit - current price)
            secondBuy = Math.max(secondBuy, firstSell - price);
            
            // 4. Maximize total profit after second sell
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        
        return secondSell;
    }
}
