class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memory = [0]*(amount+1)
        for i in range(1,amount+1):
            if i in coins:
                memory[i]=1
            else:
                min_coins = float('inf')
                for coin in coins:
                    if i-coin>=0:
                        min_coins = min(memory[i-coin],min_coins)
                memory[i] = min_coins+1
        return memory[amount] if memory[amount]!=float('inf') else -1
