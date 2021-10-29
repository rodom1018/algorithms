my_list = [987654 for i in range(1000001)]

n= int(input())

my_list[n] = 0
for i in range(n, 0, -1):
    if my_list[i] ==987654: continue

    if i%3 == 0 :
        temp = my_list[i] +1
        if my_list[i//3] >temp:
            my_list[i//3] = temp
            
    if i%2 == 0 :
        temp = my_list[i] +1
        if my_list[i//2] >temp:
            my_list[i//2] = temp
            
    temp= my_list[i] +1
    if my_list[i-1] >temp:
        my_list[i-1] = temp
        
print(my_list[1])
    
