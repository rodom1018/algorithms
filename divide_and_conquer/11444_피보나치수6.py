matrix = [[1,1],[1,0]]

def mulmat(a_matrix, b_matrix):
    
    temp_matrix = [[0,0],[0,0]]
    for i in range(2):
        for j in range(2):
            for k in range(2):
                temp_matrix[i][j] += a_matrix[i][k] * b_matrix[k][j]
            temp_matrix[i][j] = temp_matrix[i][j] % 1000000007
    return temp_matrix
    

def daq(n):
    if n>1:
        temp = daq(n//2)
        if n%2 == 0:
            return mulmat(temp,temp)
        else:
            return mulmat(mulmat(temp,temp), matrix)
    else:
        return matrix

n = int(input())
if n==1:
    print("1")
elif n==2:
    print("1")
else:
    result_matrix = daq(n-1)
        
    print(result_matrix[0][0] %  1000000007)
