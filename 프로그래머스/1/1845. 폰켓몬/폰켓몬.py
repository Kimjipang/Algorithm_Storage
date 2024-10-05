from collections import *

def solution(nums):
    answer = 0
    
    nums_set = set(nums)
    
    
    return len(nums_set) if len(nums) / 2 >= len(nums_set) else len(nums) / 2
