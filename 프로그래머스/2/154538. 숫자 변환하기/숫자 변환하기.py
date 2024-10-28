from collections import deque

def solution(x, y, n):
    answer = -1
    
    queue = deque()
    visited = set()
    
    queue.append([x, 0])
    visited.add(x)
    
    while queue:
        num, count = queue.popleft()
        
        if num == y:
            return count
        
        for i in (num + n, num * 2, num * 3):
            if i <= y and i not in visited:
                visited.add(i)
                queue.append([i, count + 1])
        
    return answer