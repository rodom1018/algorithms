import copy
from dataclasses import dataclass

n = int(input())

@dataclass
class Queen:
    x: int = None
    y: int = None
    
queen_list = []
result= 0
    
def dfs(start):
    global queen_list
    global result
    
    if len(queen_list) == n:
        result += 1
        return
    
    for j in range(n):
        
        flag=1
        
        for queen in queen_list:
            if start == queen.x: 
                flag=0
                break
            if j == queen.y : 
                flag=0
                break
            if abs(start-queen.x) == abs(j-queen.y):
                flag=0
                break
            
        if flag ==1:
            temp_queen = Queen()
            temp_queen.x = start
            temp_queen.y = j
            queen_list.append(temp_queen)
            
            dfs(start+1)
            
            queen_list.pop()
            
        
dfs(0)
print(result)