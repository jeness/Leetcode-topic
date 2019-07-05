class Solution {
    public int numSpecialEquivGroups1(String[] A) {
        //题意要理解一下
        //special equal:一个字符串的奇数位之间互换，偶数位之间互换，得到的新字符串可以成为其他串
        //问有几组这样做互换变换之后可以互相变的字符串
        //1. 可以把奇数位和偶数位分别抽出来，排序，放进set，返回set的size
        //2. 可以把奇数位偶数位hash一下，hash[ch[i] - 'a' + (i % 2) * 26]++,然后把hash扔进set，返回set的size
        Set<String> set = new HashSet<>();
        for(String s : A){
            int[] hash = new int[52];
            for(int i = 0; i < s.length(); i++){
                char[] ch = s.toCharArray();
                hash[ch[i] - 'a' + (i % 2) * 26]++;
            }
            String h = Arrays.toString(hash);
            set.add(h);
        }
        return set.size();
    }
}

class Solution {
    public int numSpecialEquivGroups2(String[] A) {
        //题意要理解一下
        //special equal:一个字符串的奇数位之间互换，偶数位之间互换，得到的新字符串可以成为其他串
        //问有几组这样做互换变换之后可以互相变的字符串
        //1. 可以把奇数位和偶数位分别抽出来，排序，放进set，返回set的size
        //2. 可以把奇数位偶数位hash一下，hash[ch[i] - 'a' + (i % 2) * 26]++,然后把hash扔进set，返回set的size
        Set<String> set = new HashSet<>();
        for(String s : A){
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if(i % 2 == 0){
                    even.append(s.charAt(i));
                }
                else{
                    odd.append(s.charAt(i));
                }
            }
            char[] evench = even.toString().toCharArray();
            Arrays.sort(evench);
            char[] oddch = odd.toString().toCharArray();
            Arrays.sort(oddch);
            String str = new String(evench);
            str = str + new String(oddch);
            set.add(str);
        }
        return set.size();
    }
}