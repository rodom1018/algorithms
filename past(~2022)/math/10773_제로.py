n = int(input())

my_list = []

for i in range(n):
    temp = int(input())
    
    if temp == 0 :
        my_list.pop()
    else:
        my_list.append(temp)
        
sum = 0
for i in range(len(my_list)):
    sum+=my_list[i]
    
print(sum)