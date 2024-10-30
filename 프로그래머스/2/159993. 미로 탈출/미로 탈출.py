from collections import deque

def solution(maps):
    def bfs(start_x, start_y, end_x, end_y):
        queue = deque()
        queue.append([start_x, start_y, 0])
        visited = set()
        visited.add((start_x, start_y))

        while queue:
            cur_x, cur_y, count = queue.popleft()

            if cur_x == end_x and cur_y == end_y:
                return count
            
            for i in range(4):
                cur_dx = cur_x + dx[i]
                cur_dy = cur_y + dy[i]

                if 0 <= cur_dx < n and 0 <= cur_dy < m and maps[cur_dx][cur_dy] != 'X':
                    if (cur_dx, cur_dy) not in visited:
                        visited.add((cur_dx, cur_dy))
                        queue.append([cur_dx, cur_dy, count + 1])

    n = len(maps)
    m = len(maps[0])
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    for i in range(n):
            for j in range(m):
                if maps[i][j] == 'S':
                    x, y = i, j
                elif maps[i][j] == 'E':
                    end_x, end_y = i, j
                elif maps[i][j] == 'L':
                    l_x, l_y = i, j
                    
    toLever = bfs(x, y, l_x, l_y)
    toEnd = bfs(l_x, l_y, end_x, end_y)
    
    if toLever and toEnd:
        return toLever + toEnd
    
    return -1
