n,c = map(int, input().split())
house_list = []
for i in range(n):
    house_list.append(int(input()))

house_list.sort()
min=house_list[0]
max=house_list[len(house_list)-1]

left = 1
right = max-min
result = -1
while left <= right:
    
    dist = (left+right)//2
    
    temp_pointer=min
    count = 0 
    for i in range(len(house_list)):
        if temp_pointer+dist <= house_list[i]:
            temp_pointer = house_list[i]
            count +=1
    if count >= c-1 :
        left = dist +1
        result = dist
    else:
        right = dist-1
print(result)
    