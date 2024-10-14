def solution(brown, yellow):
    answer = []
    
    flag = True
    depth = 0
    while flag:
        brown_carpet = 0
        depth += 1
        yellow_carpet = yellow / depth
        brown_carpet = (yellow_carpet + 2) * 2 + depth * 2
        
        if brown_carpet == brown:
            return [yellow_carpet + 2, depth + 2]
        
    
    return answer