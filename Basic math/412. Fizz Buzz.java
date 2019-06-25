class Solution1 { //普通青年的常规解法
    public List<String> fizzBuzz(int n) {
        //3 -> Fizz
        //5 -> Buzz
        //both 3 and 5 -> FizzBuzz
        List<String> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                ans.add("FizzBuzz");
            }
            else if (i % 3 == 0){
                ans.add("Fizz");
            }
            else if(i % 5 == 0){
                ans.add("Buzz");
            }
            else{
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}

class Solution2 {
    public List<String> fizzBuzz(int n) {
        //3 -> Fizz
        //5 -> Buzz
        //both 3 and 5 -> FizzBuzz 
        //文艺青年的不用%解法
        List<String> ans = new ArrayList<>();
        for(int i = 1, fizz = 0, buzz = 0; i <= n; i++){
            fizz++;
            buzz++;
           if(fizz == 3 && buzz == 5){
               ans.add("FizzBuzz");
               fizz = 0;
               buzz = 0;
           }
            else if(fizz == 3){
                ans.add("Fizz");
                fizz = 0;
            }
            else if(buzz == 5){
                ans.add("Buzz");
                buzz = 0;
            }
            else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}

class Solution3 {
    public List<String> fizzBuzz(int n) {
        //3 -> Fizz
        //5 -> Buzz
        //both 3 and 5 -> FizzBuzz 
        //中二青年的只能用一个if的解法
        List<String> ans = new ArrayList<>();
       for(int i = 1; i <= n; i++){
           //s的顺序有讲究，15一定是在3 和 5 中间
           String s =  helper(i, 3, "Fizz") + helper(i, 15, "") + helper(i, 5, "Buzz");
           if(s.equals("")){
               s = s + i;
           }
           ans.add(String.valueOf(s));
       }
        return ans;
    }
    
    private String helper(int i, int num, String str){
        String ans = i % num == 0 ? str:"";
        return ans;
    }
}