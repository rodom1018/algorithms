from collections import deque
from sys import stdin

c,r, h = map(int, stdin.readline().split())

my_map = []
for i in range(h):
    temp_map=[]
    for i in range(r):
        temp_map.append(list(map(int,stdin.readline().split())))
        
    my_map.append(temp_map)

visited = [[[6000000 for i in range(c)] for i in range(r)]for i in range(h)]

def bfs():
    queue = deque()
    for k in range(h):
        for i in range(r):
            for j in range(c):
                if my_map[k][i][j] == 1:
                    queue.append([k,i,j])
                    visited[k][i][j] = 1

    while queue:
        temp_coord = queue.popleft()
        temp_z = temp_coord[0]
        temp_x = temp_coord[1]
        temp_y = temp_coord[2]
        
        if temp_x != 0 :
            if visited[temp_z][temp_x-1][temp_y] > visited[temp_z][temp_x][temp_y]+1 and my_map[temp_z][temp_x-1][temp_y] !=-1 :
                visited[temp_z][temp_x-1][temp_y] = visited[temp_z][temp_x][temp_y]+1
                queue.append([temp_z,temp_x-1,temp_y])
            
        if temp_x != r-1:
            if visited[temp_z][temp_x+1][temp_y] > visited[temp_z][temp_x][temp_y]+1 and my_map[temp_z][temp_x+1][temp_y] !=-1:
                visited[temp_z][temp_x+1][temp_y] = visited[temp_z][temp_x][temp_y]+1
                queue.append([temp_z, temp_x+1 , temp_y])
            
        if temp_y != 0:
            if visited[temp_z][temp_x][temp_y-1] > visited[temp_z][temp_x][temp_y]+1 and my_map[temp_z][temp_x][temp_y-1] !=-1:
                visited[temp_z][temp_x][temp_y-1] = visited[temp_z][temp_x][temp_y]+1
                queue.append([temp_z,temp_x, temp_y-1])
            
        if temp_y != c-1:
            if visited[temp_z][temp_x][temp_y+1] > visited[temp_z][temp_x][temp_y]+1 and my_map[temp_z][temp_x][temp_y+1] !=-1: 
                visited[temp_z][temp_x][temp_y+1] = visited[temp_z][temp_x][temp_y]+1
                queue.append([temp_z, temp_x, temp_y+1])
        
        if temp_z != 0 :
           if visited[temp_z-1][temp_x][temp_y] > visited[temp_z][temp_x][temp_y]+1 and my_map[temp_z-1][temp_x][temp_y] !=-1: 
                visited[temp_z-1][temp_x][temp_y] = visited[temp_z][temp_x][temp_y]+1
                queue.append([temp_z-1, temp_x, temp_y]) 
        if temp_z != h-1:
            if visited[temp_z+1][temp_x][temp_y] > visited[temp_z][temp_x][temp_y]+1 and my_map[temp_z+1][temp_x][temp_y] !=-1: 
                visited[temp_z+1][temp_x][temp_y] = visited[temp_z][temp_x][temp_y]+1
                queue.append([temp_z+1, temp_x, temp_y])             
    return visited
    
bfs()
  
my_max = -1     
no_tomato = 1
for k in range(h):
    for i in range(r):
        for j in range(c):
            if visited[k][i][j] == 6000000 and my_map[k][i][j] != -1:
                print("-1")
                exit()
            if visited[k][i][j] > my_max and my_map[k][i][j] != -1 :
                no_tomato =0
                my_max = visited[k][i][j]
if no_tomato == 0:
    print(my_max-1)
else:
    print("-1")
    
