#2차원배열쓰는 dp
my_list = [[0 for i in range(10)] for i in range(101)]

my_list[1][0]=0
for i in range(1,10):
    my_list[1][i] = 1

for i in range(2, 101):
    for j in range(10):
        if j ==0 :
            my_list[i][j] = my_list[i-1][j+1] % 1000000000
        elif j==9:
            my_list[i][j] = my_list[i-1][j-1] % 1000000000
        else:
            my_list[i][j] =( my_list[i-1][j-1] + my_list[i-1][j+1]) % 1000000000

n= int(input())
result = 0 
for i in range(10):
    result += my_list[n][i]
    
print(result  % 1000000000)