from collections import deque

def solution(maps):
    answer = bfs(maps)
    return answer

def bfs(maps):
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    n, m = len(maps), len(maps[0])
    visited = set()
    visited.add((0, 0)) 
    queue = deque([(0, 0, 1)]) 
    
    while queue:
        y, x, count = queue.popleft()
        
        if y == n - 1 and x == m - 1:
            return count
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < m and 0 <= ny < n and maps[ny][nx] == 1:
                if (ny, nx) not in visited: 
                    visited.add((ny, nx))
                    queue.append((ny, nx, count + 1))
    
    return -1
