class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if (q == null || k <= 0 || k > q.size()) return q;

        Vector<Integer> vec = new Vector<>();
        int remaining = q.size() - k;

        while (k > 0) {
            vec.add(q.peek());
            q.remove();
            k--;
        }
        Collections.reverse(vec);

        for (int i = 0; i < vec.size(); i++) {
            q.add(vec.get(i));
        }
        while (remaining > 0) {
            q.add(q.peek());
            q.remove();
            remaining--;
        }
        return q;
    }
}