#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

char info[2500];
int answer[2500];
int main() {
    scanf("%s", info);
    int str_len = strlen(info);
    for(int i=0; i<str_len ; i++) answer[i] = 9999;
    answer[0] = 1;

    for(int i=0; i<str_len ; i++){
        int memory = 0;
        for(int j=str_len-1; j>i ;j--) {

            int fail = 0;
            int left = i;
            int right = j;

            while (left < right) {
                if (info[left] != info[right]) {
                    fail = 1;
                    break;
                }
                left++;
                right--;
            }

            if (fail == 0) {
                memory = j - i;
                if (answer[i - 1] + 1 <= answer[i + memory]) answer[i + memory] = answer[i - 1] + 1;
            }
        }

        for(int k=0 ; k<=i; k++){
            if(answer[k] + (i+1-k) <= answer[i+1]) answer[i + 1] = answer[k] + (i+1-k);
        }
    }
    printf("%d", answer[str_len-1]);
}
