import sys

N = int(sys.stdin.readline())

# 각 queen이 몇 번째 column에 있는가?
queen_list = [0 for i in range(N+1)]
result = 0

def dfs(now_row):
    global result
    # n개의 퀸을 모두 올려 놓았음 
    if now_row == N+1:
        result += 1
        return
    
    #now_row의 퀸을 i번째 col 위에 놓을 수 있는가?
    for now_col in range(1,N+1):
        
        can = 1

        # 위에 있는 퀸들 때문에 못 놓는가?
        for prev_row in range(1,now_row):
            # 같은 열에 있는가? + 대각선에 있는가?
            if queen_list[prev_row] == now_col or (abs(prev_row - now_row) == abs(queen_list[prev_row] - now_col)):
                can = 0
                break

        if can :
            queen_list[now_row] = now_col
            dfs(now_row + 1)
            queen_list[now_row] = 0

dfs(1)
print(result)


