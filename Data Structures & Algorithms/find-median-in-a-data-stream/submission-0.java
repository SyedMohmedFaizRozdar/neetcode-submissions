class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //first we will add data stream number to small
        small.offer(num);

        //then we will add the largest of small to large.
        large.offer(small.poll());

        //make sure that heaps are balanced, always make sure that small has only one element more than large.
        if(small.size()<large.size()){
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        //if there are numers of odd length in data stream return the top most from small.
        if(small.size() > large.size()){
            return small.peek();
        }

        return (double)(small.peek() + large.peek())/2;
    }
}
