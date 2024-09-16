

while True:
    my_list = list(map(int, input().split()))
    
    if my_list[0] == 0:
        break
    
    my_list = my_list[1:]
    my_stack = []
    my_max = 0
  
    for i in range(len(my_list)):
        while True:
            if len(my_stack) == 0:
                my_stack.append([my_list[i], i])
                break
            
            comp_value = my_stack[len(my_stack)-1][0]
            if len(my_stack)>=2:
              comp_index = my_stack[len(my_stack)-2][1]
            else:
              comp_index = -1
            
            if comp_value<=my_list[i]:
                my_stack.append([my_list[i], i])
                break
            else:
                
                my_stack.pop()
            
                    
                if my_max < comp_value * (i-comp_index-1):
                    my_max = comp_value * (i-comp_index-1)
                
                if my_max < my_list[i] * (i-comp_index):
                    my_max = my_list[i] * (i-comp_index)

                
            
    stand = my_stack[len(my_stack)-1][1]
  
    while(len(my_stack) != 0):
        if len(my_stack)>=2:
          now = my_stack[len(my_stack)-2][1]
        else:
          now = -1
        diff = stand-now
        if my_max< diff * my_stack[len(my_stack)-1][0]:
          my_max =  diff * my_stack[len(my_stack)-1][0]
        my_stack.pop()
    
    
    print(my_max)
    
        