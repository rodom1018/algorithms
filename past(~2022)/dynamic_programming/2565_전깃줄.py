n=int(input())
my_list = []
for i in range(n):
    temp_list= list(map(int, input().split()))
    my_list.append(temp_list)

my_list = sorted(my_list, key = lambda x: x[0])

result = [0 for i in range(n)]

result[0]=1
for i in range(1,n):
    temp_max = 0
    
    for j in range(0,i):
        if my_list[i][1] > my_list[j][1]:
            if temp_max < result[j]:
                temp_max = result[j]
                
    result[i] = temp_max+1
    
result.sort()
print(n-result[n-1])
        
        
            
            
            