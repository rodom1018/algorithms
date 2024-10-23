import sys

N = int(sys.stdin.readline()) 
school_map = [ [0]*(N+2) for i in range(N+2)]
friend_data = [[0]*4 for i in range(N**2 + 1)]
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

for i in range(N*N):
    #print(school_map)
    now_student, f1 , f2, f3, f4 = map(int, sys.stdin.readline().split(" "))
    now_friends = [f1,f2,f3,f4]

    friend_data[now_student][0] = f1
    friend_data[now_student][1] = f2
    friend_data[now_student][2] = f3
    friend_data[now_student][3] = f4

    # 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
    now_max = 0
    first_list = [ [] for i in range(5)]
    for r in range(1, N+1):
        for c in range(1, N+1):
            
            
            if school_map[r][c] != 0:
                continue

            now_count = 0

            for a in range(4):
                now_r = r + dx[a]
                now_c = c + dy[a]

                if school_map[now_r][now_c] in now_friends:
                    now_count += 1
            
            first_list[now_count].append([r,c])

            if now_count > now_max:
                now_max = now_count

    
    # 2-1. 1을 만족하는 칸이 한 칸인가?
    if len(first_list[now_max]) == 1:
        r = first_list[now_max][0][0]
        c = first_list[now_max][0][1]

        school_map[r][c] = now_student
        continue
    
    # 2-2. 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
    first_list = first_list[now_max]
    second_list = [ [] for i in range(5) ]
    now_max = 0

    for now_rc in first_list:
        r = now_rc[0]
        c = now_rc[1]
        now_count = 0
        for a in range(4):
            now_r = r + dx[a]
            now_c = c + dy[a]

            if now_r <= 0 or now_r >= (N+1) or now_c <= 0 or now_c >= (N+1):
                continue 
            if school_map[now_r][now_c] == 0:
                now_count += 1

        second_list[now_count].append([r,c])

        if now_max < now_count :
            now_max = now_count
            
    # 3-1. 2를 만족하는 칸이 한 칸인가 ?  
    if len(second_list[now_max]) == 1:
        r = second_list[now_max][0][0]
        c = second_list[now_max][0][1]

        school_map[r][c] = now_student
        continue

    # 3-2. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 작은 칸으로 자리를 정한다.
    second_list = second_list[now_max]
    second_list.sort()
    
    r = second_list[0][0]
    c = second_list[0][1]
    
    school_map[r][c] = now_student

#print(school_map)

score = 0

for r in range(1,N+1):
    for c in range(1, N+1):
        now_count = 0
        now_student = school_map[r][c]
        for a in range(4):
            now_r = r + dx[a]
            now_c = c + dy[a]

            if now_r <= 0 or now_r >= (N+1) or now_c <= 0 or now_c >= (N+1):
                continue

            if school_map[now_r][now_c] in friend_data[now_student]:
                now_count += 1

        if now_count == 0:
            continue
        
        score += 10 ** (now_count-1)

print(score)



