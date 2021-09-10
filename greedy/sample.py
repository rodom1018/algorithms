x1, y1, x2, y2 = map(int, input().split())

x_start=[]
y_start=[]
start=[]
add=[]
max_num=0


for i in range(5000):
    x_start.append(i)
    y_start.append(i+1)
    start.append(((2*i+1)**2)+1)
    add.append(2*(i+1))

x_diff = x2-x1+1
y_diff = y2-y1+1

array = [[0 for col in range(y_diff)] for row in range(x_diff)]
result =[[0 for col in range(y_diff)] for row in range(x_diff)]

for x in range(x_diff):
    for y in range(y_diff):
        temp_x = x1+x
        temp_y = y1+y

        i= 0
        temp_value=0
        if(abs(temp_x)>abs(temp_y)):
            i = abs(temp_x)-1
        else:
            i = abs(temp_y)-1
            
        if temp_x ==0 and temp_y == 0:
            
            temp_value =1
            
        elif temp_y == y_start[i] and x_start[i]>=temp_x:
            
            temp_value = start[i] + (x_start[i] - temp_x)
            
        elif temp_x == -y_start[i]:
            
            temp_value = (start[i]+add[i])+ (y_start[i] - temp_y -1)
            
        elif temp_y == -y_start[i] :
            
            temp_value = (start[i]+2*add[i])+(y_start[i] + temp_x -1)
            
        elif temp_x == y_start[i]:
            
            temp_value = (start[i] + 3*add[i])+ (y_start[i]+temp_y -1 )

        if(max_num<temp_value):
            max_num = temp_value
        
        array[x][y] = temp_value
        
max_length= len(str(max_num))

for x in range(x_diff):
    for y in range(y_diff):
        temp = str(array[x][y])
        result[x][y] = ' ' *(max_length - len(temp))
        result[x][y]+=temp
        
for x in range(x_diff):
    for y in range(y_diff):
        print(result[x][y], end= '')
        if y != y_diff:
            print(end=' ')
        
    print()
        
    
    
            
        
        

 