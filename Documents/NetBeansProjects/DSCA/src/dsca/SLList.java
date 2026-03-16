package dsca;

public class SLList implements LinkedListInterface { //uses the LinkedListInterface Methods

    private Node head; //private node called head
    private Node curr; //private node called curr
    private Node prev; //private node called prev
    private int size; //private node called size

    public SLList() { //this is the original weight to the above Nodes
        size = 0;
        head = null;
        curr = null;
        prev = null;
    }

    @Override
    public boolean isEmpty() { //checks to see if the SLL is empty
        return size == 0;
    }

    @Override
    public int size() { //returns the size of the SLL
        return size;
    }


    public void addStop(int index, Object element) { //adds stop to SLL

        if(index == 1){ //if inserting to beginning of list
            Node newNode = new Node(element, head); //creates newnode
            head = newNode; //update head to point at newnode

        } else if(head == null){ //if list is empty then
            Node newNode = new Node(element); //create a new node
            head = newNode; //sets the head as new node (only node)

        } else { //if inserting in the middle of list
            setCurrentStop(index); //changes curr and prev

            Node newNode = new Node(element); //creates new node with element

             newNode.next = curr; //new node next to curr at the target index
            prev.next = newNode; //link the prev node to new node
}

        size++; //increases the size of SLL
    }

    private void setCurrentStop(int index){
        curr = head; //sets curr to head
        prev = null; //changes prev to null

        for(int i = 1; i < index; i++){ 
            prev = curr; //prev is curr
            curr = curr.getNext(); //curr is getnext
        }
    }

    @Override
    public void removeStop(int index){
        //deletes stop from SLL
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

        size--; //reduces size of SLL
    }

    public void printStopList(){ //prints all stops in SLL
        Node aNode = head;

        while (aNode != null) {
            System.out.println(aNode.getElement().toString());
            aNode = aNode.getNext();
        }
    }

    public Node getHead(){ ///returns the head to the user
        return head;
    }
    
    
}