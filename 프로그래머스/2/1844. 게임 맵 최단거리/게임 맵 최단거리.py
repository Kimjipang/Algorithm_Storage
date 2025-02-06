from collections import deque

def solution(maps):
    answer = -1

    n = len(maps)
    m = len(maps[0])

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    visited = set()
    queue = deque()
    
    visited.add((0,0))
    queue.append((0, 0, 1))
    
    while queue:
        x, y, cnt = queue.popleft()
        
        if (x, y) == (n - 1, m - 1):
            return cnt
        
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x < n and 0 <= next_y < m and maps[next_x][next_y] == 1:
                
                if (next_x, next_y) not in visited:
                    visited.add((next_x, next_y))
                    queue.append([next_x, next_y, cnt + 1])
        
    return answer