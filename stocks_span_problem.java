public class stocks_span_problem{
    public static class Node{
        int data;
        Node next;

        Node(int data){
           this.data = data;
           this.next = null;
        }
    }

    public static class Stack{
        static Node head = null;

        //isEmpty
        public static boolean isEmpty(){
            return head == null;
        }

        //Push
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        //pop
        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }
    }

    public static void stockSpan(int stocks[], int span[]){
        Stack s = new Stack();
        span[0] = 1;
        s.push(0);

        for(int i=1; i<stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice>stocks[s.peek()]) {
                s.pop();
            }
                if(s.isEmpty()){
                    stocks[i] = i+1;
                }
                else{
                    int prevHigh = s.peek();
                    span[i] = i-prevHigh;
                }
                s.push(i);
            }
        }
    public static void main(String args[]){
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for(int i=0; i<span.length; i++){
            System.out.print(span[i]+" ");
        }
    }
}