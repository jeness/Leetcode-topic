class Solution1 {
    // nums = "----->-->"; k =3
    // result = "-->----->";
    
    // reverse "----->-->" we can get "<--<-----"
    // reverse "<--" we can get "--><-----"
    // reverse "<-----" we can get "-->----->"
        
        // (AB)^T = B^T A^T in matrix theory
        public void rotate(int[] nums, int k) { 
            int len = nums.length;
            k = k % len;
            reverse(nums, 0, len - 1); //一定要先翻转整个数组，步骤不能错
            reverse(nums, 0, k - 1);
            reverse(nums, k, len - 1);
        }
        
        private void reverse(int[] nums, int start, int end){
            while(start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        } 
    }


    class Solution2 {

            public void rotate(int[] nums, int k) { 
               int r = k % nums.length; // get the actual position after rotation
                Queue<Integer> q = new ArrayDeque<>();
                for(int i = nums.length - r; i < nums.length; i++){
                    q.add(nums[i]);
                }
                for(int i = 0; i < nums.length - r; i++){
                    q.add(nums[i]);
                }
                int index = 0;
                while(!q.isEmpty()){
                    nums[index++] = q.remove(); 
                }
                
            }
    }
            