def solution(number, k):
    answer = ''
    
    stack = []
    
    for num in number:
        
        while k > 0 and stack and stack[-1] < num:
            stack.pop()
            k -= 1
        stack.append(num) 
        # 9
        # 9, 3 / k = 2
        # 9, 9 / k = 1
        # 9, 9, 3 / k = 1
        # 9, 9, 9 / k = 0
    
    if k != 0:
        stack = stack[:-k]
    answer = ''.join(stack)
    
    return answer