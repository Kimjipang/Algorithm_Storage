from collections import *
def solution(priorities, location):
    answer = 1
    count = 1
    
    priorities = deque(priorities)
    pos = deque([i for i in range(len(priorities))])
    
    while priorities:
        flag = False
        num = priorities.popleft()
        idx = pos.popleft()
        
        for item in priorities:
            if num < item:
                flag = True
                break
        if flag:
            priorities.append(num)
            pos.append(idx)
        else:
            if idx == location:
                return answer
            answer += 1
            

    return answer