from collections import *

def solution(people, limit):
    answer = 0
    start = 0
    end = len(people) - 1
    flag = True
    
    people.sort()
    people = deque(people)

    while end > start:
        if people[start] + people[end] > limit:
            end -= 1
            answer += 1

        else:
            answer += 1
            start += 1
            end -= 1
            
    if end == start:
        answer += 1
        
    return answer