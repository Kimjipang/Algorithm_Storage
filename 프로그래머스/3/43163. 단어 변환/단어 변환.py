from collections import deque

def solution(begin, target, words):
    answer = 0
    visited = set()
    queue = deque()
    length = len(begin)
    
    queue.append([begin, 0])
    visited.add(begin)

    
    while queue:
        w, c = queue.popleft()
        
        if w == target:
            return c
            
        for word in words:
            count = 0
            for i in range(length):
                if w[i] != word[i]:
                    count += 1
                    
            if count == 1 and word not in visited:
                visited.add(word)
                queue.append([word, c + 1])
    
    
    return answer