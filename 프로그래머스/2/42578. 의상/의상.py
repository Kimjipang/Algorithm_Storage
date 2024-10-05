from collections import *

def solution(clothes):
    answer = 0
    
    clothes_dict = defaultdict(int)
    
    for _, category in clothes:
        clothes_dict[category] += 1
    
    answer = 1

    for count in clothes_dict.values():
        answer *= (count + 1)

    
    
    return answer - 1