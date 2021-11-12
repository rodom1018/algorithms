from collections import deque
n , m ,v = map(int, input().split())

my_list = [[0 for i in range(n+1)]for i in range(n+1)]
visited = [0 for i in range(n+1)]

apple= 0 
for i in range(m):
    a,b = map(int, input().split())
    my_list[a][b] = 1
    my_list[b][a] = 1



def dfs(src):
    visited[src] = 1
    print(src,end = " ")
    
    for i in range(n+1):
        if visited[i] == 0 and my_list[src][i] == 1:
            dfs(i)
        
    

def bfs(src):
    apple =1
    queue = [src]
    visited[src]=0
    
    while queue:
        temp = queue.pop(0)
        print(temp, end = " ")
        for i in range(n+1):
            if visited[i] == 1 and my_list[temp][i]==1:
                visited[i] = 0
                queue.append(i)
                
    

dfs(v)
print()
bfs(v)
#bfs(v)
