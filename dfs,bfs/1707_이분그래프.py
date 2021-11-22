from collections import deque
n = int(input())

dx = [0,-1,0,1]
dy = [-1,0,1,0]

def bfs(k):
    
    queue = deque()
    
    if visited[k] ==0:
        visited[k] =1
    
    queue.append(k)
    
    while queue:
        temp = queue.popleft()
        
        for i in range(len(my_tree[temp])):
            if visited[my_tree[temp][i]] == 0 :
                queue.append(my_tree[temp][i])
        
        for i in range(len(my_tree[temp])):
            if visited[my_tree[temp][i]] == visited[temp]:
                return -1 
            elif visited[my_tree[temp][i]] == 0 :
                visited[my_tree[temp][i]] = -visited[temp]
                
    return 1
        
    
for i in range(n):
    total_count = 0
    v,e = map(int,input().split())
    
    my_tree = [[] for i in range(v)]
    visited =[0 for i in range(v)]
    for j in range(e):
        a,b = map(int, input().split())
        
        my_tree[a-1].append(b-1)
        my_tree[b-1].append(a-1)
        
    flag = 0
    
    for k in range(v):
        if len(my_tree[k]) != 0:
            answer = bfs(k)
            
        if answer == -1:
            print("NO")
            flag =1
            break
        
    if flag == 0 :
        print("YES")
    
    
    