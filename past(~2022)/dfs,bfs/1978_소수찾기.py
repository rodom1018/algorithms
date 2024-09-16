import math

n = int(input())
num_list = list(map(int, input().split()))

prime_list = []
sum = 0
for i in range(n):
    temp = num_list[i]
    flag = 0
    
    if temp ==1:
        continue
    
    for j in range(2,int(math.sqrt(temp))+1):
        if temp % j == 0 :
            flag = 1
            break
    
    if flag == 0:
        prime_list.append(i)
        sum+=i
        
print(len(prime_list))
