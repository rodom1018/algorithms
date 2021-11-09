n,c = map(int, input().split())
product_list = list(map(int, input().split()))

product_list_a = product_list[:n//2]
product_list_b = product_list[n//2:]

part_a_weight = []
part_b_weight = []

def a_dfs(a_temp_weight, a_index):
    
    if a_temp_weight > c :
        return
    else: 
        part_a_weight.append(a_temp_weight)
    
    for i in range(a_index, len(product_list_a)):
        
        a_temp_weight+=product_list_a[i]
        a_dfs(a_temp_weight, i+1)
        a_temp_weight-=product_list_a[i]
        
def b_dfs(b_temp_weight, b_index):
    
    if b_temp_weight > c :
        return
    else: 
        part_b_weight.append(b_temp_weight)
    
    for i in range(b_index, len(product_list_b)):
        
        b_temp_weight+=product_list_b[i]
        b_dfs(b_temp_weight, i+1)
        b_temp_weight-=product_list_b[i]
        

a_dfs(0, 0)
b_dfs(0, 0)

part_b_weight.sort()

sum = 0

for i in range(len(part_a_weight)):
    for j in range(len(part_b_weight)):
        if part_a_weight[i]+part_b_weight[j] <= c:
            sum+=1
        else:
            break
            
print(sum)
    
    
    
    