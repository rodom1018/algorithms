import math

start = int(input())
end = int(input())

prime_list = []
sum = 0
for i in range(start, end+1):
    temp = i 
    flag = 0
    
    if i ==1:
        continue
    
    for j in range(2,int(math.sqrt(i))+1):
        if i % j == 0 :
            flag = 1
            break
    
    if flag == 0:
        prime_list.append(i)
        sum+=i
        
if len(prime_list) == 0:
    print(-1)
else:    
    print(sum)
    print(prime_list[0])
