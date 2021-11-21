from collections import deque

test = int(input())

dx = [-2,-1,1,2,2,1,-1,-2]
dy = [1,2,2,1,-1,-2,-2,-1]
def bfs():
    size = int(input())
    queue = deque()
    chess = [[-1 for i in range(size)] for i in range(size)]
    
    s_x, s_y = map(int, input().split())
    d_x, d_y = map(int, input().split())
    chess[s_x][s_y] = 0
    queue.append([s_x,s_y])
    
    while queue:
        temp_list = queue.popleft()
        
        s_x = temp_list[0]
        s_y = temp_list[1]
        
        if s_x == d_x and s_y ==d_y:
            print(chess[s_x][s_y])
            break
        
        for i in range(8):
            if s_x+dx[i]>= 0 and s_x+dx[i]<size and s_y+dy[i]<size and s_y+dy[i]>=0:
                if chess[s_x+dx[i]][s_y+dy[i]] == -1:
                    chess[s_x+dx[i]][s_y+dy[i]] = chess[s_x][s_y]+1
                    queue.append([s_x+dx[i], s_y+dy[i]])
                    
    
for i in range(test):
    bfs()