import math

def solution(w,h):
    answer = 0
    num = math.gcd(w, h)
    
    answer = w * h - (w + h - num)
    
    return answer