num1, num2 = map(int, input().split())

num1_divide = [0 for i in range(10001)]
num2_divide = [0 for i in range(10001)]

result1 = 1
result2 = 1

divider = 2
while True:
    if num1< divider: break

    if num1 % divider == 0 : 
        num1 = num1//divider
        num1_divide[divider] +=1
        divider = 2
    else:
        divider+=1

divider = 2       
while True:
    if num2 < divider: break

    if num2 % divider==0 : 
        num2 = num2//divider
        num2_divide[divider] +=1
        divider = 2
    else:
        divider+=1        

for i in range(10001):
    if num1_divide[i] !=0 and num2_divide[i] !=0:
        temp1 = min(num1_divide[i], num2_divide[i])
        temp2 = max(num1_divide[i], num2_divide[i])
        result1 *= i ** temp1
        result2 *= i ** temp2
        continue
    elif num1_divide[i] != 0 or num2_divide[i] !=0:
        temp2 = max(num1_divide[i], num2_divide[i])
        result2 *= i ** temp2
        continue
        
        
print(result1)
print(result2)
