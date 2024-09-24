def solution(numbers):
    answer = ''
    
    str_numbers = [str(num) for num in numbers]
    str_numbers.sort(key=lambda x : x * 3, reverse = True)
    result = ''.join(str_numbers)
    
    return result if int(result) != 0 else '0'