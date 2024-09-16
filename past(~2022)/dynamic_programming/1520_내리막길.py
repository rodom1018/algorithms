from sys import stdin

dx = [0,-1,0,1]
dy = [1,0,-1,0]
def dfs(to_x, to_y):
    global result_map
    if result_map[to_x][to_y] == -1:
        result_map[to_x][to_y] = 0 
    
    for i in range(4):
        temp_x = to_x+dx[i]
        temp_y = to_y+dy[i]
            
        if temp_x<0 or temp_x>m-1 or temp_y<0 or temp_y>n-1:
            #index error 방지. 
            continue
        
        if result_map[temp_x][temp_y]==0:
            #못가는 길 . 
            continue
        
        if my_map[to_x][to_y]>my_map[temp_x][temp_y]:
            if temp_x == m-1 and temp_y == n-1 :
                result_map[to_x][to_y] += 1 
            elif result_map[temp_x][temp_y]>0:
                result_map[to_x][to_y]+=result_map[temp_x][temp_y]
            else:
                result_map[to_x][to_y]+=dfs(temp_x,temp_y)
            
            
    return result_map[to_x][to_y]
        
        

m,n = map(int, stdin.readline().split())
result_map = [[-1 for col in range(n)]for row in range(m)]
result_map[m-1][n-1] = 1
my_map = []
for i in range(m):
    my_map.append(list(map(int,stdin.readline().split())))
    
dfs(0,0)
print(result_map[0][0])