n = int(input())

my_list = list(map(int, input().split()))
increase_mode = [0 for i in range(n)]
decrease_mode = [0 for i in range(n)]

increase_mode[0] = 1
decrease_mode[0] = 1

for i in range(1,n):
    temp_inc = 0
    temp_dec = 0
    
    for j in range(0,i):
        if my_list[i]>my_list[j]:
            if increase_mode[j] > temp_inc :
                temp_inc=increase_mode[j]
                
        if my_list[i]<my_list[j]:
            if max(increase_mode[j] ,decrease_mode[j]) > temp_dec:
                temp_dec=max(increase_mode[j], decrease_mode[j])
    
    increase_mode[i] = temp_inc+1
    decrease_mode[i] = temp_dec+1

increase_mode.sort()
decrease_mode.sort()

print(max(increase_mode[n-1], decrease_mode[n-1]))