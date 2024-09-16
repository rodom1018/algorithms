
#include <iostream>
#include <deque>

using namespace std;

struct num{
    long num;
    int index;
}nums[5000001];
int main() {
    int n, l;
    scanf("%d %d", &n, &l);

    for(int i=1; i<=n ; i++){
        long temp;
        scanf("%ld", &temp);
        nums[i].num = temp;
        nums[i].index = i;
    }

    deque<num> dq;

   for(int i=1 ; i<=n; i++){

       while(true){
           if(dq.size() ==0 ) break;
           if(dq.front().index <i-l+1) dq.pop_front();
           else break;
       }

       while(true){
           if(dq.size() == 0) break;
           if (dq.back().num > nums[i].num) { dq.pop_back(); }
           else break;
       }

       dq.push_back(nums[i]);

       printf("%ld ",dq.front().num);
   }
}

