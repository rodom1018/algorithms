def dfs(i, j,depth):

    if my_map[i][j] == 0 : return
    
    global result
    if depth==0: 
        result+=1
    
    my_map[i][j] = 0
    
    #상하좌우
    if i-1 >=0: dfs(i-1, j ,depth+1)
    if j-1 >=0: dfs(i, j-1, depth+1)
    if i+1 < m: dfs(i+1, j, depth+1)
    if j+1 < n: dfs(i, j+1, depth+1)
    
    #대각선
    if i-1 >=0 and j-1>=0: dfs(i-1,j-1,depth+1)
    if i-1 >=0 and j+1< n : dfs(i-1,j+1,depth+1)
    if i+1 < m and j-1>=0: dfs(i+1, j-1, depth+1)
    if i+1 < m and j+1< n: dfs(i+1, j+1, depth+1)

while True:
    n,m =map(int, input().split())
    
    if n == 0 and m ==0:
        break
    
    result = 0
    my_map = []
    
    for i in range(m):
        my_list =list(map(int, input().split()))
        my_map.append(my_list)
    
    for i in range(m):
        for j in range(n):
            dfs(i,j,0)
            
    print(result)