#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;
int dp[51][500001];
int block[51];
int main() {
    int n;
    scanf("%d", &n);

    for(int i=1; i<=n ; i++){
        int temp;
        scanf("%d", &temp);
        block[i] = temp;
    }
    for(int i=1; i<=n ; i++){
        int now = block[i];

        for(int j=0; j<=500000; j++){
            if(dp[i-1][j] == 0 ) continue;

            int up = j+now; //17
            int down = j-now; //11

            //큰쪽에 넣기
            if(up <=500000) {
                if(dp[i][up] < dp[i-1][j] + now){
                    dp[i][up] = dp[i-1][j]+now;
                    //if(i==3 && up == 9) printf("으야얏1 %d %d\n", i-1, j);
                }
            }

            //이번에는 안고르기
            if(dp[i][j] < dp[i-1][j]){
                //if(i==3 && j==9) printf("으야얏2 %d %d\n", i-1,j);
                dp[i][j] = dp[i-1][j];
            }

            //작은 쪽에 넣기
            if(down<0){
                //작은 쪽이 오히려 더 커짐.
                int abs_down = abs(down); //now-j
                //if(i==3 && abs_down ==9) printf("으아앗3 %d %d\n", i-1, j);
                if(dp[i][abs_down] < dp[i-1][j] + abs_down) dp[i][abs_down] = dp[i-1][j] + abs_down;
            }else{
               // if(i==3 && down ==9) printf("으야얏4 %d %d\n", i-1, j);
                if(dp[i][down] < dp[i-1][j]) dp[i][down] = dp[i-1][j];
            }
        }

        if(dp[i][now] < now) dp[i][now]= now;
    }
    /*
    for(int i=1; i<=n ; i++){
        printf("\n");
        for(int j=0; j<=122; j++){
            printf("%d ", dp[i][j]);
        }
    }*/
    if(dp[n][0] !=0 )printf("%d", dp[n][0]);
    else printf("-1");
}