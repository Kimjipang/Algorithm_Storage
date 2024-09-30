from collections import *

def solution(progresses, speeds):
    answer = []
    count = 0
    time = 0
    
    progresses = deque(progresses)
    speeds = deque(speeds)
    
    while progresses:
        if progresses[0] + time * speeds[0] >= 100:
            progresses.popleft()
            speeds.popleft()
            count += 1
        else:
            if count != 0:
                answer.append(count)
                count = 0
            time += 1
        
    answer.append(count)
    return answer