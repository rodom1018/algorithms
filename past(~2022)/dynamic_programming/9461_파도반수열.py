block = [-1 for i in range(1000001)]
block[1]= 1
block[2]= 1
block[3]= 1
block[4]= 2
block[5]= 2
block[6]= 3


for i in range(7,101):
    block[i] = block[i-1] + block[i-5]



n = int(input())

for i in range(n):
    temp = int(input())
    print(block[temp])