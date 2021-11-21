from collections import deque

visited = [0 for i in range(100002)]

a,b = map(int, input().split())

def bfs():
    queue = deque()
    queue.append(a)
    visited[a] = 1
    
    while True:
        temp = queue.popleft()
        if temp == b :
            print(visited[temp]-1)
            exit()
        if a<b:
            if temp >50000 :
                if temp >0:
                    if visited[temp-1]==0:
                        queue.append(temp-1)
                        visited[temp-1] = visited[temp]+1
                if temp<100000:
                    if visited[temp+1]==0:
                        queue.append(temp+1)
                        visited[temp+1] = visited[temp]+1
            else:
                if temp>0:
                    if visited[temp-1]==0 :
                        queue.append(temp-1)
                        visited[temp-1] = visited[temp]+1
                
                if temp<100000:
                    if visited[temp+1]==0:
                        visited[temp+1] = visited[temp]+1
                        queue.append(temp+1)
                
                if visited[temp*2]==0:
                    visited[temp*2] = visited[temp]+1
                    queue.append(temp*2)
        elif a==b:
            print("0")
            exit()
        else:
            if temp>0:
                if visited[temp-1]==0:
                    queue.append(temp-1)
                    visited[temp-1] = visited[temp]+1
                
bfs()
            
    