def solution(s):
    answer = True
    
    stack = []
    
    for st in s:
        if len(stack) == 0:
            stack.append(st)
        else:
            if stack[-1] == "(":
                if st == ")":
                    stack.pop()
                else:
                    stack.append(st)
            else:
                return False
            
    
    return True if len(stack) == 0 else False