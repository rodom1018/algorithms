import sys

N, E = map(int, sys.stdin.readline().split())
INF = 987654321
my_map = [ [INF] * (N+1) for i in range(N+1)]

for i in range(N+1):
    my_map[i][i] = 0

for i in range(E):
    a, b, c = map( int, sys.stdin.readline().split() )
    my_map[a][b] = c
    my_map[b][a] = c

c1, c2 = map(int, sys.stdin.readline().split()) 

# 중간에 지나는 정점은 가장 바깥쪽 for loop 에 있어야 한다.    
for k in range(1, N+1):
    for a in range(1, N+1):
        for b in range(1, N+1):
            if my_map[a][b] > my_map[a][k] + my_map[k][b]:
                my_map[a][b] = my_map[a][k] + my_map[k][b]
            
#1 - c1 - c2 - dest
result1 = my_map[1][c1] + my_map[c1][c2] + my_map[c2][N]
#1 - c2 - c1 - dest
result2 = my_map[1][c2] + my_map[c2][c1] + my_map[c1][N]

result = min(result1, result2)

if result >= INF:
    print("-1")
else:
    print(result)
    
    