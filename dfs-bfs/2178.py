from collections import deque

N, M = map(int, input().split())

my_map = [[0]*(M+1) for i in range(N+1)]

for i in range(1,N+1):
    temp = input()
    for j in range(1,M+1):
        my_map[i][j] = int(temp[j-1])

# print(my_map)

def bfs(start_i, start_j):
    queue = deque()
    temp_list = [start_i, start_j]
    queue.append(temp_list)

    while queue:
        now_list = queue.popleft()
        now_value = my_map[now_list[0]][now_list[1]]
        # 상 하 좌 우
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]

        for i in range(4):
            temp_x = now_list[0] + dx[i]
            temp_y = now_list[1] + dy[i]
            
            if temp_x > N or temp_y > M :
                continue

            if my_map[temp_x][temp_y] == 1:

                if temp_x == 1 and temp_y ==1:
                    continue

                my_map[temp_x][temp_y] = now_value + 1
                temp_list = [temp_x, temp_y]
                queue.append(temp_list)

bfs(1,1)
#print(my_map)
print(my_map[N][M])