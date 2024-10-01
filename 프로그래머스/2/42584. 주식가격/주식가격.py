from collections import *

def solution(prices):
    answer = []
    
    prices = deque(prices)
    
    while prices:
        num = prices.popleft()
        count = 0
        for item in prices:
            if num <= item:
                count += 1
            else:
                count += 1
                break
        answer.append(count)


    
    return answer