from collections import *

def solution(numbers, target):
    answer = 0
    
    queue = deque([(0,0)])
    length = len(numbers)
    
    while queue:
        num, idx = queue.popleft()
        
        if idx == length:
            if num == target:
                answer += 1
        else:
            queue.append((num + numbers[idx] * 1, idx + 1))
            queue.append((num + numbers[idx] * - 1, idx + 1))
    
    return answer