import sys

N = int(sys.stdin.readline()) + 2
expr = "0+" + sys.stdin.readline().strip()
result = -9876543210

def calculate(a,b,c):
    a = int(a)
    c = int(c)
    
    if b == '+':
        return a + c
    elif b == '-':
        return a - c
    elif b == '*':
        return a * c

    
def dfs(temp_result, index):
    global result
    if index >= N:
        if temp_result > result:
            result = temp_result
        return
    
    #이번에는 괄호를 추가한다 
    # 0 + (3 + 8) * 7
    # 11 * 7
    if index + 3 < N :
        dfs(calculate(temp_result, expr[index], calculate(expr[index+1], expr[index+2], expr[index+3])), index+4)
    
    #이번에는 괄호를 추가하지 않는다 
    # 0 + 3 + 8 * 7
    # 3 + 8 * 7
    dfs(calculate(temp_result, expr[index], expr[index+1]), index+2)

dfs(0, 1)
print(result)