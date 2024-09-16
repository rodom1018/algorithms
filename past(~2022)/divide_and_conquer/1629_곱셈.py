from sys import stdin
a,b,c = map(int, stdin.readline().split())

def sqrt(n):
    if n !=0:
        temp = sqrt(n//2)
        if n %2 == 1:
            return temp*temp*a % c
        else:
            return temp*temp %c 
    else:
        return 1

result = sqrt(b)
print(result)