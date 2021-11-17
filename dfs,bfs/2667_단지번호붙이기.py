
n = int(input())

apt_num = []
apt_list = []

for i in range(n):
    apt_list.append(list(input()))

def dfs(start , end, apt):
    
    if start<0 or start>n-1 or end<0 or end>n-1: return
    
    if apt_list[start][end] =='0':
        return
    else:
        apt_list[start][end] = '0'
        apt_num[apt]+=1
    
    dfs(start,end-1, apt)
    dfs(start,end+1, apt)
    dfs(start-1,end, apt)
    dfs(start+1,end, apt)
    
        

new_apt = 0
for i in range(n):
    for j in range(n):
        if apt_list[i][j] == '1':
            apt_num.append(0)
            dfs(i,j,new_apt)
            new_apt+=1

print(new_apt)
apt_num.sort()
for i in range(new_apt):
    print(apt_num[i])

