r1,c1 =map(int, input().split())
a_matrix = []
for i in range(r1):
    temp_list = list(map(int, input().split()))
    a_matrix.append(temp_list)
    
r2,c2 = map(int, input().split())
b_matrix = []
for i in range(r2):
    temp_list = list(map(int, input().split()))
    b_matrix.append(temp_list)

result_matrix = [[0 for col in range(c2)] for row in range(r1)]

for i in range(r1):
    for j in range(c2):
        
        for k in range(r2):
            result_matrix[i][j] += a_matrix[i][k] * b_matrix[k][j]

for i in range(r1):
    for j in range(c2):
        print(result_matrix[i][j], end=" ")
        
    print()
    
