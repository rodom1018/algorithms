#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

pair<int ,int> golds[300030];

int bag[300030];



int main() {
    int n, k ;
    scanf("%d %d", &n , &k);

    for(int i=0 ; i<n; i++){
        int temp1 , temp2;
        scanf("%d %d", &temp1, &temp2);
        golds[i].first= temp1 ; golds[i].second = temp2;
    }

    for(int i=0 ; i<k ; i++){
        int temp;
        scanf("%d", &temp);
        bag[i] = temp;
    }

    sort(bag, bag+k);
    sort(golds, golds+n);
    long total = 0;

    priority_queue<int> pq;
    int p = 0;

    for(int i=0 ; i<k ; i++){
        //작은 가방부터 .
        while(golds[p].first <= bag[i] && p<n){
            //printf("%d ", golds[p].m);
            pq.push(golds[p].second);
            p++;
        }
        if(!pq.empty()) {
            int temp_max = pq.top();
            pq.pop();
            total += (long) temp_max;
        }
    }

    printf("%ld", total);

}
