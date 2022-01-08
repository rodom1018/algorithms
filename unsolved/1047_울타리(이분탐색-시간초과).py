
from sys import stdin
MIN = -1
MAX = 1000001
yes = 0
stop_flag = 0 
n= int(stdin.readline())

tree_info = []
for i in range(n):
    temp_tree = list(map(int, stdin.readline().split()))
    tree_info.append(temp_tree)

def dfs(cut, start,cut_index):
    global yes
    global stop_flag
    
    if stop_flag ==1 :
        return
    if cut==max:
        
        have_trees = 0
        have_index = 0
        max_x = MIN
        min_x = MAX
        max_y = MIN
        min_y = MAX
        
        for i in range(n):
            if i == cut_index[have_index]:
                if have_index != len(cut_index)-1:
                    have_index+=1
                have_trees +=tree_info[i][2]
                continue
            
            if tree_info[i][0] <min_x:
                min_x = tree_info[i][0]
                
            if tree_info[i][0] > max_x:
                max_x = tree_info[i][0]
                
            if tree_info[i][1] < min_y:
                min_y = tree_info[i][1]
                
            if tree_info[i][1] > max_y:
                max_y = tree_info[i][1]
        width = max_x-min_x
        height = max_y - min_y
        cost = (width+height) *2
        if cost<=have_trees:
            yes = 1 
            stop_flag =1 
            return
    else:
        for i in range(start ,n):
            if stop_flag ==1 :
                return
            cut_index.append(i)
            dfs(cut+1, i+1, cut_index)
            cut_index.pop(len(cut_index)-1)

start = 1 
end = n 
answer = -1
while start <=end:
    mid = (start+end)//2
    yes = 0
    stop_flag = 0 
    max = mid
    dfs(0,0,[])
    
    if yes == 1 : 
        end = mid - 1
        answer = mid
    else:
        start= mid+1

print(answer)
    
