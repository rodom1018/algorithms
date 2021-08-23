# 문제 내용 간단 요약
#  0011
#  1111
#  0000
#  1111
#  0 이 얼음 1 이 벽, 여기서는 2 덩이가 답이다 .
 
#입력받기 
N,M = map(int, input().split())

ice = []
for i in range(N):
    ice.append(list(map(int, input())))


#dfs 함수
def dfs(a,b):
    #범위 밖이면 , 나간다. 
    if a<0 or b<0 or a>=N or b>=M:
        return False

    #이미 방문했거나, 벽임.
    if ice[a][b] == 1:
        return False
    
    #방문 처리(벽으로 만들기.)
    ice[a][b]=1
    

    #오른쪽 왼쪽 위쪽 아래쪽 재귀적으로 수색. 
    dfs(a-1,b)
    dfs(a,b-1)
    dfs(a,b+1)
    dfs(a+1,b)

    #얼음 한덩이
    return True
    


ice_count=0
for i in range (0,N):
    for j in range (0,M):
        #dfs 탐색이 되면 얼음덩어리 한개 . 카운트 +1
        if dfs(i,j) == True:
            ice_count +=1
print(ice_count)