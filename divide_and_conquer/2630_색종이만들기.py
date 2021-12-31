n = int(input())

board = []

blue = 0
white = 0

def check(x,y,len):
    
    global blue
    global white
    
    flag = 0
    color = board[x][y]
    
    if len == 1:
        if color == 0 :
            white +=1
            return
        if color == 1:
            blue +=1
            return
        
    for i in range(x,x+len):
        
        if flag == 1 :
            break
        
        for j in range(y,y+len):
            if color != board[i][j]:
                flag = 1
                break
            
    
    if flag == 1:
        
        half = len//2
        
        check(x,y,half)
        check(x+half, y , half)
        check(x, y+half, half)
        check(x+half, y+half, half)
    else:
        if color == 1:
            blue+=1
        else:
            white+=1
        

for i in range(n):
    temp = list(map(int, input().split()))
    board.append(temp)
    
check(0,0,n)

print(white)
print(blue)

