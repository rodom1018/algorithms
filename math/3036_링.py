n = int(input())

my_list = list(map(int,input().split()))

for i in range(n):
    if i == 0 : continue

    temp_a = my_list[i]
    temp_b = my_list[0]
    
    gcd = 1 
    for j in range(1,min(temp_a,temp_b)+1):
        if temp_a % j == 0 and temp_b % j == 0:
            gcd = j
    print(str(int(temp_b/gcd))+"/"+str(int(temp_a/gcd)))
