#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;
int dp[201][201];
int info[201];
int main() {
    int n, k ;
    scanf("%d %d" ,&n, &k);

    for(int i=1; i<=n; i++){
        int temp;
        scanf("%d", &temp);
        info[i] = temp;
    }


    for(int i=1; i<n ; i++){
        if(info[i] != info[i+1]) dp[i][i+1] = 1;
    }

    for(int i=2 ; i<n ; i++){
        for(int j=1 ; j<=n-i; j++){
            int min = 98765432;
            for(int a=j ; a<j+i ; a++){
                int temp = dp[j][a] + dp[a+1][j+i];
                if(info[j] != info[j+i]) temp += 1;
                if(temp< min) min = temp;
            }
            dp[j][j+i] = min;
        }
    }

    printf("%d", dp[1][n]);
}