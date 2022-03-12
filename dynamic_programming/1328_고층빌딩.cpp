#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;
long info[101][101][101];
const long MOD =  1000000007;
int main() {
    int n, left, right ;
    scanf("%d %d %d", &n, &left , &right);
    //printf("%d %d %d\n", n ,left, right);
    info[1][1][1] = 1;
    for(int i=2; i<=n ; i++){
        for(int l= 1 ; l<= left ;l++ ){
            for(int r=1 ; r<=right; r++){
                //printf("%d %d %d\n", i, l, r);
                if(l>i || r>i) continue;

                info[i][l][r] = ( (info[i-1][l][r] * (i-2))%MOD +
                        +(info[i-1][l-1][r] %MOD )
                        +(info[i-1][l][r-1] %MOD ) )%MOD;
            }
        }
    }

    printf("%ld", info[n][left][right]%MOD);

}