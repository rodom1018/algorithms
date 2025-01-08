class Solution {
    public int solution(int[] money) {
        
        //noFirstHome은 첫 집을 털지 않을 경우
        //yesFirstHome은 첫 집을 털 경우
        int[] noFirstHome = new int[money.length];
        int[] yesFirstHome = new int[money.length];
        
        yesFirstHome[0] = money[0];
        
        
        //첫 집을 털지 않은 경우
        for(int i=1; i<money.length ;i++){
            
            //이번 집을 터는 경우
            int notStealThisHome = noFirstHome[i-1];
            
            //이번 집을 털지 않는 경우
            int stealThisHome;
            
            if(i-2 < 0){
                stealThisHome = money[i];
            }else{
                stealThisHome = money[i] + noFirstHome[i-2];
            }
            
            noFirstHome[i] = Math.max(notStealThisHome, stealThisHome);
        }
        
        
        //첫 집을 터는 경우, 마지막 집을 털면 안되서 money.length - 1 처리 
        for(int i=1; i<money.length -1 ;i++){
            
            //이번 집을 터는 경우
            int notStealThisHome = yesFirstHome[i-1];
            
            //이번 집을 털지 않는 경우
            int stealThisHome;
            
            if(i-2 < 0){
                stealThisHome = money[i];
            }else{
                stealThisHome = money[i] + yesFirstHome[i-2];
            }
            
            yesFirstHome[i] = Math.max(notStealThisHome, stealThisHome);
        }        
        
        yesFirstHome[money.length -1] = yesFirstHome[money.length -2];
        
        /*
        for(int i=0; i<money.length ; i++){
            System.out.print(noFirstHome[i] + " ");
        }
        
        System.out.println();
        
        for(int i=0; i<money.length ; i++){
            System.out.print(yesFirstHome[i] + " ");
        }
        */  
        
        int answer = Math.max(yesFirstHome[money.length - 1], noFirstHome[money.length - 1]) ;
        return answer;
    }
}