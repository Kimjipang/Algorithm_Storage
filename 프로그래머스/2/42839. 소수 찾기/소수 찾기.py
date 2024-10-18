from itertools import permutations

def solution(numbers):
    answer = 0
    length = len(numbers)
    
    nums = set()
    
    for i in range(1, length + 1):
        temp = list(permutations(numbers, i))
        
        for j in temp:
            nums.add(int(''.join(j)))
    
    for num in nums:
        if is_prime_num(num):
            answer += 1
            
    return answer


def is_prime_num(num):

    if num < 2:
        return False
    
    for i in range(2, int(num / 2) + 1):
        if num % i == 0:
            return False
        
    return True