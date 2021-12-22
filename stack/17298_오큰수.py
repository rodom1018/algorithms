n = int(input())

my_list = list(map(int, input().split()))

my_stack = []

result = [0 for i in range(n)]

for i in range(n):
    my_stack.append(i)
    
    while True:
        
        if len(my_stack) == 0 :
            break
        
        temp_index = len(my_stack)-1
        temp = my_stack[temp_index]
        
        if i == n-1:
            break
        
        if my_list[temp] < my_list[i+1]:
            result[temp] = my_list[i+1]
            my_stack.pop()
        else:
            break

for i in range(len(my_stack)):
    result[my_stack[i]] = -1
for i in range(n):
    print(result[i], end = " ")
    
        
        
    