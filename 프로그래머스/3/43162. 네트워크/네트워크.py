from collections import deque

def solution(n, computers):
    answer = 0
    
    def bfs(i):
        queue = deque([i])
        visited[i] = 1
        
        while queue:
            i = queue.popleft()
            
            for j in range(n):
                if computers[i][j] == 1 and not visited[j]:
                    visited[j] = 1
                    queue.append(j)
        
    visited = [0 for i in range(n)]
    
    for i in range(n):
        if not visited[i]: 
            bfs(i)
            answer += 1
        
    return answer