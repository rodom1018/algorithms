n = int(input())

board = []

first = 0
second = 0
third = 0

def check(x,y,len):
    
    global first
    global second
    global third
    
    flag = 0
    color = board[x][y]
    
    if len == 1:
        if color == -1 :
            first +=1
            return
        elif color == 0:
            second +=1
            return
        else:
            third +=1
            return 
        
    for i in range(x,x+len):
        
        if flag == 1 :
            break
        
        for j in range(y,y+len):
            if color != board[i][j]:
                flag = 1
                break
            
    
    if flag == 1:
        
        half = len//3
        
        check(x,y,half)
        check(x, y+half, half)
        check(x, y+half*2 , half)
        
        check(x+half, y , half)
        check(x+half, y+half, half)
        check(x+half, y+half*2, half)
        
        check(x+half*2, y, half)
        check(x+half*2, y+half, half)
        check(x+half*2, y+half*2, half)
    else:
        if color == -1:
            first+=1
        elif color == 0 :
            second +=1
        else:
            third +=1
        

for i in range(n):
    temp = list(map(int, input().split()))
    board.append(temp)
    
check(0,0,n)

print(first)
print(second)
print(third)


