
store =[[[-9876 for i in range(51)]for i in range(51)]for i in range(51)]
def w(a,b,c):
    if a<=0 or b<=0 or c<=0:
        return 1
    elif store[a][b][c] != -9876:
        return store[a][b][c]
    elif a>20 or b>20 or c>20:
        return w(20,20,20)
    elif a<b and b<c:
        store[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c)
        return store[a][b][c]
    else:
        store[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1)
        return store[a][b][c]
while True:
    a,b,c = map(int, input().split())
    
    if a==-1 and b==-1 and c==-1:
        break
    else:
        print("w({0}, {1}, {2}) = {3}".format(a,b,c,w(a,b,c)))