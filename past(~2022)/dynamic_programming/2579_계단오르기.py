n= int(input())

my_list = []

step_0 = [0 for i in range(n)]
step_1 = [0 for i in range(n)]

for i in range(n):
    my_list.append(int(input()))

if n>=3:
    step_0[1] = 0
    step_1[1] = my_list[0]+my_list[1]
    
    step_0[2] = my_list[0] + my_list[2]
    step_1[2] = my_list[1] + my_list[2]
    
    for i in range(3,n):
        step_0[i] = max(step_0[i-2],step_1[i-2])+my_list[i]
        step_1[i] = step_0[i-1] + my_list[i]
        
    print(max(step_0[n-1], step_1[n-1]))
elif n==2:
    print(my_list[0]+my_list[1])
elif n==1:
    print(my_list[0])

    
    
