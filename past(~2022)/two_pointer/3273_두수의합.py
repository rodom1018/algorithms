n = int(input())
my_list =sorted(list(map(int, input().split())))
x = int(input())
result = 0

left = 0
right =len(my_list)-1

while left<right:
    temp = my_list[left]+my_list[right]
    if temp ==x: result+=1
    
    if temp < x:
        left+=1
        continue
    
    right-=1

print(result)