h, n =map(int, input().split())

block = list(map(int, input().split()))
water = 0

    
for i in range(n):
    temp_left = block[:i]
    temp_right = block[i+1:]
    
    left_max = -1
    right_max = -1
    
    if len(temp_left) >0 :
        left_max = max(temp_left)
    else:
        continue
    
    if len(temp_right) >0 :
        right_max = max(temp_right)
    else:
        continue
    
    stand = min(left_max, right_max)
    temp_water = stand - block[i]
    
    if temp_water > 0 :
        water +=temp_water
        
print(water)
    