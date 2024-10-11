import sys, copy

N, M, K = map(int, sys.stdin.readline().split(" "))

before_map = [[ [] for j in range(N)] for i in range(N)]
after_map = [[ [] for j in range(N)] for i in range(N)]

direction = [[-1,0], [-1,1], [0,1], [1,1], [1,0], [1,-1], [0,-1], [-1,-1]]

for i in range(M):
    r, c, m, s, d =map(int, sys.stdin.readline().split(" "))
    before_map[r-1][c-1].append([m,s,d])

for k in range(K):
    after_map = [[ [] for j in range(N)] for i in range(N)]
    
    # 1. 모든 파이어볼이 자신의 방향 d로 속력 s칸 만큼 이동한다.
    for row in range(N):
        for col in range(N):
            for now_fire in before_map[row][col]:
                m, s, d = now_fire[0], now_fire[1], now_fire[2]
                
                #파이어볼 옮기기
                temp_row = (row + (s * direction[d][0])) % N
                temp_col = (col + (s * direction[d][1])) % N
                
                after_map[temp_row][temp_col].append([m,s,d])
                 
    # 2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 경우 대처
    for row in range(N):
        for col in range(N):
            if len(after_map[row][col]) >= 2:
                odd_flag = 1
                even_flag = 1
                total_m = 0
                total_s = 0
                
                for now_fire in after_map[row][col]:
                    m, s, d = now_fire[0], now_fire[1], now_fire[2]
                    
                    total_m += m
                    total_s += s
                    
                    if d % 2 == 0:
                        odd_flag = 0
                    if d % 2 == 1:
                        even_flag = 0
                        
                total_m = total_m // 5
                total_s = total_s // len(after_map[row][col])
                
                after_map[row][col] = []
                
                if total_m == 0: 
                    continue
                
                if odd_flag or even_flag:
                    for now_d in range(0,8,2):
                        after_map[row][col].append([total_m,total_s,now_d])
                else:
                    for now_d in range(1,9,2):
                        after_map[row][col].append([total_m,total_s,now_d])
                        
    before_map = copy.deepcopy(after_map)
    #print(before_map)

result = 0 
for row in range(N):
    for col in range(N):
        for now_fire in before_map[row][col]:
            result += now_fire[0]
            
print(result)
                
                
            