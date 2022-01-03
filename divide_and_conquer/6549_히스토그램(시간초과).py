

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
            comp_index = my_stack[len(my_stack)-1][1]
            
            if comp_value<=my_list[i]:
                my_stack.append([my_list[i], i])
                break
            else:
                
                my_stack.pop()
                
                not_include_left = comp_index
                while True:
                  if not_include_left == -1 :
                    break
                  if my_list[not_include_left]>=comp_value:
                    not_include_left = not_include_left -1
                  else:
                    break         
                not_include_left = not_include_left+1
            
              
                include_left = comp_index
                while True:
                  if include_left == -1 :
                    break
                  if my_list[include_left]>=my_list[i]:
                    include_left = include_left -1
                  else:
                    break
                include_left = include_left+1
                    
                if my_max < comp_value * (i-not_include_left):
                    my_max = comp_value * (i-not_include_left)
                
                if my_max < my_list[i] * (i-include_left+1):
                    my_max = my_list[i] * (i-include_left+1)

                
                  
    stand = my_stack[len(my_stack)-1][1]
  
    while(len(my_stack) != 0):
        now = my_stack[len(my_stack)-1][1]
        now_value = my_stack[len(my_stack)-1][0]
        while True:
            if now== -1 :
                break
            if my_list[now]>=now_value:
                now = now-1
            else:
                break         
        now = now+1
        diff = stand-now+1
        if my_max< diff * my_stack[len(my_stack)-1][0]:
          my_max =  diff * my_stack[len(my_stack)-1][0]
        my_stack.pop()
    
    print(my_max)
    
        