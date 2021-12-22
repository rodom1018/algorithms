from sys import stdin

n = int(stdin.readline())

my_list = []

for i in range(n):
    temp = stdin.readline().strip()
    if temp.startswith('push'):
        
        temp_list = list(temp.split())
        my_num = int(temp_list[1])
        my_list.append(my_num)
        
    elif temp =="pop":
        if len(my_list) == 0 :
            print("-1")
            continue
        
        print(my_list[len(my_list)-1])
        my_list.pop()
        
    elif temp == "size":
        
        print(len(my_list))
        
    elif temp == "empty":    
        
        if len(my_list) == 0 :
            print("1")
        else:
            print("0")
            
    elif temp == "top":
        if len(my_list) == 0 :
            print("-1")
            continue
        
        print(my_list[len(my_list)-1])
        
        