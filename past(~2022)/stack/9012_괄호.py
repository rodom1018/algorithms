n = int(input())

for i in range(n):
    my_stack = []
    flag = 0
    my_str = input()
    
    for j in range(len(my_str)):
        
        if my_str[j] == '(':
            my_stack.append('(')
        elif my_str[j] == ')':
            
            if len(my_stack) == 0:
                print("NO")
                flag = 1
                break
            elif my_stack[len(my_stack)-1] != '(':
                print("NO")
                flag = 1
                break
            else:
                my_stack.pop()
    
    if flag == 1 : continue
    if len(my_stack) == 0 :
        print("YES")
    else:
        print("NO")