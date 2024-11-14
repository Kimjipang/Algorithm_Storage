from collections import deque

def solution(s):
    answer = 0
    
    queue = deque(s)
    length = len(queue)
    cnt = len(queue)
    q = deque()
    
    
    while cnt > 0:
        stack = []
        
        for item in queue:
            
            if len(stack) == 0:
                stack.append(item)
            else:
                if stack[-1] == "{" and item == "}":
                        stack.pop()
                elif stack[-1] == "(" and item == ")":
                        stack.pop()
                elif stack[-1] == "[" and item == "]":
                        stack.pop()
                else:
                    stack.append(item)
        
        if len(stack) == 0:
            answer += 1
            
        element = queue.popleft()
        queue.append(element)
        cnt -= 1
        
    
    return answer