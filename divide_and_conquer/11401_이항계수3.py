my_mod = 1000000007

def factorial(num):
    result = 1
    for i in range(2, num+1):
        result = result * i % my_mod
    return result

def power(num, p):
    if p == 1:
        return num % my_mod
    
    if p % 2 == 1:
        #홀수승 일 때 
        return (power(num,p//2) ** 2 * num) % my_mod
    else:
        #짝수승 일 때 
        return power(num,p//2)** 2 % my_mod
        
n, k = map(int, input().split())

a=factorial(k) % my_mod
b=factorial(n-k) % my_mod
c=factorial(n) % my_mod
b2 = power(a*b,my_mod-2) % my_mod
result = ((c%my_mod) * (b2%my_mod))%my_mod
print(result)
