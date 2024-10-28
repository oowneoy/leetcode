class BrowserHistory {
    ListNode current;

    static class ListNode {
        String url;
        ListNode prev;
        ListNode next;
        public ListNode(String url) {
            this.url = url;
        }
    }

    public BrowserHistory(String homepage) {
        this.current = new ListNode(homepage);

    }
    
    public void visit(String url) {
        ListNode visit = new ListNode(url);
        visit.prev = this.current;
        this.current.next = visit;
        this.current = visit;
    }
    
    public String back(int steps) {
        while (steps-- > 0 && this.current.prev != null) {
            this.current = this.current.prev;
        }

        return this.current.url;
    }
    
    public String forward(int steps) {
        while (steps-- > 0 && this.current.next != null) {
            this.current = this.current.next;
        }
        return this.current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */