from collections import deque

def solution(maps):
    answer = bfs(maps)
    return answer

def bfs(maps):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    n = len(maps)
    m = len(maps[0])
    
    visited = set()
    queue = deque([(0, 0, 1)])
    visited.add((0,0))
    
    while queue:
        x, y, count = queue.popleft()
        
        if x == n - 1 and y == m - 1:
            return count
        
        
        for i in range(4):
            cur_x = x + dx[i]
            cur_y = y + dy[i]
            
            if 0 <= cur_x < n and 0 <= cur_y < m and maps[cur_x][cur_y] == 1:
                if (cur_x, cur_y) not in visited:
                    visited.add((cur_x, cur_y))
                    queue.append((cur_x, cur_y, count + 1))
    return -1
                    