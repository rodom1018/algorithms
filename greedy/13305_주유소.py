n = int(input())

cost_list = list(map(int, input().split()))
nation_list = list(map(int,input().split()))

start = 0
end = start+1
result = 0
while start < n-1 :
    
    temp_distance = 0
    
    temp_distance += cost_list[end-1]
    
    while nation_list[start] < nation_list[end]:
        temp_distance += cost_list[end]
        end+=1
        if end == n-1:
            break
    
    result += (temp_distance * nation_list[start])
    start = end
    end = end+1
    
print(result)