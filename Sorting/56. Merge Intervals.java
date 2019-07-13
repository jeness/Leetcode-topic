class Solution {
    public int[][] merge(int[][] intervals) {
        //先按start排序，顺序排序
        //然后再比较last.end >= cur.start，则说明max(last.end, i[1]) 比较两个的end，最大的是新的end
        //last.end < cur.start, 则说明没有重合，last的start和end都更新
       List<int[]> list = new ArrayList<>();
        if(intervals == null || intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0])); //按start排序
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] i : intervals ){
            if(end >= i[0]){
                end = Math.max(end, i[1]);
            }
            else{
                list.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        list.add(new int[]{start, end});
        
        return list.toArray(new int[list.size()][2]);
    }
}

/** 老版的代码
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
public class Solution {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> ans = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) return ans;
        Collections.sort(intervals, (a, b) ->(a.start - b.start));
        Interval cur = new Interval(intervals.get(0).start, intervals.get(0).end);
        for(Interval i : intervals){
            if(cur.end >= i.start){ //cur和i有重合
                cur.end = Math.max(cur.end, i.end);
            }
            else{//cur和i无重合
                ans.add(new Interval(cur.start, cur.end));
                cur.start = i.start;
                cur.end = i.end;
            }
        }
        ans.add(new Interval(cur.start, cur.end));
        return ans;
    }
}