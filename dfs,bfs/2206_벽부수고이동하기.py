from collections import deque

n,m = map(int, input().split())

my_map = []
visited = [[987654321 for i in range(m)]for i in range(n)]
for i in range(n):
    my_map.append(list(input()))
    
dx = [0,-1,1,0]
dy = [-1,0,0,1]

def bfs():
    queue = deque()
    
    queue.append([0,0,0])
    visited[0][0]=-1
    
    while queue:
        current_coord = queue.popleft()
        x = current_coord[0]
        y = current_coord[1]
        punch = current_coord[2]
        
        if x==n-1 and y==m-1:
            print(abs(visited[x][y]))
            exit(0)
            
        for i in range(4):
            if x+dx[i]>=0 and y+dy[i]>=0 and x+dx[i]<n and y+dy[i]<m:
                #벽이아니면
                if my_map[x+dx[i]][y+dy[i]] == '0':
                    if punch == 0 and (visited[x+dx[i]][y+dy[i]] < visited[x][y]-1 or visited[x+dx[i]][y+dy[i]] > 0):
                        visited[x+dx[i]][y+dy[i]] = visited[x][y]-1 
                        queue.append([x+dx[i],y+dy[i],punch])
                    if punch ==1 and visited[x+dx[i]][y+dy[i]] > visited[x][y]+1 and visited[x][y]>0 :
                        visited[x+dx[i]][y+dy[i]] = visited[x][y]+1
                        queue.append([x+dx[i],y+dy[i],punch])
                            
                else:
                    #벽일경우
                    if punch <= 0 and (visited[x+dx[i]][y+dy[i]] > visited[x][y]-1 and visited[x][y]<0):
                        queue.append([x+dx[i],y+dy[i],punch+1])
                        visited[x+dx[i]][y+dy[i]] = (-visited[x][y])+1
                        
bfs()
print("-1")

    