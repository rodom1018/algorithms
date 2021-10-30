n = int(input())
my_list= list(map(int, input().split()))

result_list = [0 for i in range(n)]
result_list[0] = 1

for i in range(1, n):
    max = 0 
    
    for j in range(0, i):
        if my_list[j]<my_list[i]:
            if max< result_list[j]:
                max = result_list[j]
                
    result_list[i]=max+1

result_list.sort()
print(result_list[n-1])