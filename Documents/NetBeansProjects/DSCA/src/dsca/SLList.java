package dsca;

public class SLList implements LinkedListInterface {

    private Node head;
    private Node curr;
    private Node prev;
    private int size;

    public SLList() {
        size = 0;
        head = null;
        curr = null;
        prev = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public void addStop(int index, Object element) {

        if(index == 1){
            Node newNode = new Node(element, head);
            head = newNode;

        } else if(head == null){
            Node newNode = new Node(element);
            head = newNode;

        } else {
            setCurrentStop(index);

            Node newNode = new Node(element);

             newNode.next = curr;
            prev.next = newNode;
}

        size++;
    }

    private void setCurrentStop(int index){
        curr = head;
        prev = null;

        for(int i = 1; i < index; i++){
            prev = curr;
            curr = curr.getNext();
        }
    }

    @Override
    public void removeStop(int index){

        if(isEmpty()){
            return;
        }

        if(index == 1){
            head = head.getNext();

        } else{
            setCurrentStop(index);
            curr = curr.getNext();
            prev.next = curr;
        }

        size--;
    }

    public void printStopList(){
        Node aNode = head;

        while (aNode != null) {
            System.out.println(aNode.getElement().toString());
            aNode = aNode.getNext();
        }
    }

    public Node getHead(){
        return head;
    }
}