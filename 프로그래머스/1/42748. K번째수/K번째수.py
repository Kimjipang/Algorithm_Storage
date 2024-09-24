def solution(array, commands):
    answer = []
    
    for command in commands:
        i, j, k = command
        num = array[i - 1 : j]
        num.sort()
        answer.append(num[k - 1])
    return answer