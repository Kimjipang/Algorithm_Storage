from collections import Counter

def solution(k, tangerine):
    answer = 0
    counter = dict(Counter(tangerine))
    
    sorted_tangerine = sorted(counter.items(),key=lambda x:x[1],reverse=True)
    
    for i in sorted_tangerine:
        k -= i[1]
        answer += 1
        
        if k <= 0:
            break
        
    return answer