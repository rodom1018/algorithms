from sys import stdin 

zero = [0 for i in range(41)]
one = [0 for i in range(41)]
zero[0] = 1
zero[1] = 0

one[0] = 0
one[1] = 1

for i in range(2,41):
    zero[i] = zero[i-1]+zero[i-2]
    one[i] = one[i-1]+one[i-2]
    
n = int(stdin.readline())

for i in range(n):
    sample = int(stdin.readline())
    print(zero[sample], end = " ")
    print(one[sample])