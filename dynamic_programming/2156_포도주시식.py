n = int(input())
stand_list=[]
my_list_1= [0 for i in range(n)]
my_list_2= [0 for i in range(n)]

for i in range(n):
    stand_list.append(int(input()))

if n ==1 :
    print(stand_list[0])
    exit()

my_list_1[0] = stand_list[0]

my_list_1[1] = stand_list[1]
my_list_2[1] = stand_list[0] + stand_list[1]

for i in range(2,n):
    
    temp_max1 = 0
    temp_max2 = 0
    
    for j in range(0, i-1):
        if my_list_1[j] > temp_max1:
            temp_max1 = my_list_1[j]
        if my_list_2[j] > temp_max2:
            temp_max2 = my_list_2[j]
        
    my_list_1[i] = max(temp_max1, temp_max2) + stand_list[i]
    my_list_2[i] = my_list_1[i-1] + stand_list[i]

my_list_1.sort()
my_list_2.sort()

if my_list_1[n-1] >= my_list_2[n-1]:
    print(my_list_1[n-1])
else:
    print(my_list_2[n-1])