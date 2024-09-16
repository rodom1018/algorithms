n= int(input())

my_list = []
for i in range(n):
    my_list.append(list(map(int, input().split())))

for i in range(1,n):
    for j in range(i+1):
        if j == 0 :
            my_list[i][j] = my_list[i][j]+my_list[i-1][0]
        elif j == i:
           my_list[i][j] = my_list[i][j]+my_list[i-1][j-1]
        else:
            my_list[i][j] = max(my_list[i][j]+my_list[i-1][j-1], my_list[i][j]+my_list[i-1][j])

max=-1
for i in range(n):
    if max< my_list[n-1][i] :
        max = my_list[n-1][i]
print(max)