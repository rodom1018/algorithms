from collections import deque

n, m = map(int, input().split())

map=[]
visited = [[0 for i in range(m)]for i in range(n)]
visited[0][0]=1

for i in range(n):
    map.append(list(input()))



def bfs():
    queue = deque()
    queue.append([0,0])
    
    while queue:
        temp_coord = queue.popleft()
        
        x = temp_coord[0]
        y = temp_coord[1]
        if map[x][y] == '0': continue
    
        if temp_coord[0] == n-1 and temp_coord[1] == m-1:
            print(visited[n-1][m-1])
            exit()
        
        map[x][y] = '0'
        if x != 0 :
            if map[x-1][y] == '1':
                visited[x-1][y] = visited[x][y]+1
                queue.append([x-1, y])
        
        if x != n-1:
            if map[x+1][y] == '1':
                visited[x+1][y] = visited[x][y]+1
                queue.append([x+1, y])
        
        if y != 0 :
            if map[x][y-1] == '1':
                visited[x][y-1] = visited[x][y]+1
                queue.append([x, y-1])
            
        if y != m-1:
            if map[x][y+1] =='1':
                visited[x][y+1] = visited[x][y]+1
                queue.append([x, y+1])

bfs()    
    