n = int(input())

my_list = [0] + list(map(int, input().split()))
result = [0 for i in range(n+1)]

minus_flag = 1
for i in range(1,len(my_list)):
    temp = result[i-1] + my_list[i]
    
    if temp >=0 :
        result[i] = temp
        minus_flag = 0
    else:
        result[i] = 0

if minus_flag ==0:
    result.sort()
    print(result[n])
else:
    my_list.sort()
    print(my_list[n-1])
