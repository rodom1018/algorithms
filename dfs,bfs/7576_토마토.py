from collections import deque
from sys import stdin
c,r = map(int, stdin.readline().split())

my_map = []
for i in range(r):
    my_map.append(list(map(int,stdin.readline().split())))

visited = [[600000 for i in range(c)] for i in range(r)]

def bfs():
    queue = deque()
    
    for i in range(r):
        for j in range(c):
            if my_map[i][j] == 1:
                queue.append([i,j])
                visited[i][j] = 1
    
    while queue:
        temp_coord = queue.popleft()
        temp_x = temp_coord[0]
        temp_y = temp_coord[1]
        
        if temp_x != 0 :
            if visited[temp_x-1][temp_y] > visited[temp_x][temp_y]+1 and my_map[temp_x-1][temp_y] !=-1 :
                visited[temp_x-1][temp_y] = visited[temp_x][temp_y]+1
                queue.append([temp_x-1,temp_y])
            
        if temp_x != r-1:
            if visited[temp_x+1][temp_y] > visited[temp_x][temp_y]+1 and my_map[temp_x+1][temp_y] !=-1:
                visited[temp_x+1][temp_y] = visited[temp_x][temp_y]+1
                queue.append([temp_x+1 , temp_y])
            
        if temp_y != 0:
            if visited[temp_x][temp_y-1] > visited[temp_x][temp_y]+1 and my_map[temp_x][temp_y-1] !=-1:
                visited[temp_x][temp_y-1] = visited[temp_x][temp_y]+1
                queue.append([temp_x, temp_y-1])
            
        if temp_y != c-1:
            if visited[temp_x][temp_y+1] > visited[temp_x][temp_y]+1 and my_map[temp_x][temp_y+1] !=-1: 
                visited[temp_x][temp_y+1] = visited[temp_x][temp_y]+1
                queue.append([temp_x, temp_y+1])
                
    return visited
    
bfs()
  
max = -1     
no_tomato = 1
for i in range(r):
    for j in range(c):
        if visited[i][j] == 600000 and my_map[i][j] != -1:
            print("-1")
            exit()
        
        if visited[i][j] > max and my_map[i][j] != -1 :
            no_tomato =0
            max = visited[i][j]
if no_tomato == 0:
    print(max-1)
else:
    print("-1")
    
