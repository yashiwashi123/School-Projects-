public class editBuffer{ 
    	
    	protected Node head;
    	protected int nums;        
    	public Cursor curse; 
        protected boolean DEBUG = true;
        protected char eof = '\u0003';
        protected char nulChar = '\u0000';

    	public editBuffer(){
    		head = new Node();
    		
    		head.prev = head;
    		head.next = head; 
            nums = 0;
            curse = new Cursor(head, 0); 
    	}
        
    	public int size(){
    		return nums;
    	}

    	public boolean isEmpty(){
    		return nums == 0;
    	}
    	/**
        need to reoptomize this code
        */


        public void insert(char e){ 
    		Node current = head; 
            //in theory, if the cursor is pointing at stuff[0] then it should create a new node before the current node
            //if the cursor is pointing at stuff[1] then it should create a new node after the current node
             if (curse.node.numitems == 2){ 
                if (curse.offset == 0){
                    Node newone = new Node(); 
                    newone.next= curse.node; 
                    newone.prev = curse.node.prev; 
                    curse.node.prev.next = newone;
                    curse.node.prev = newone;
                     

                    newone.stuff[0] = e;
                }
                else if(curse.offset == 1){

                    Node newone = new Node(); 
                    newone.prev= curse.node; 
                    newone.next = curse.node.next; 
                    curse.node.next.prev = newone;
                    curse.node.next = newone;

                    newone.stuff[0] = e; 
                }
            }
            //if the number of items in the node's array is 1, the same rule as a node with and array size of 1 and 2 applies
            else if (curse.node.numitems == 1){
               if (curse.offset == 0){ //if the node's array size is one, you just need to move the first element of the array to the right
                curse.node.stuff[1] = curse.node.stuff[0]; 
                //then you insert the chracter to the left 
                curse.node.stuff[0] = e;
            }
                else if (curse.offset == 1){
                    curse.node.stuff[1] = e; 
                }
            }
            //if the number of items is 0, then set the first element of the array to the thing you want to insert 
            else if (curse.node.numitems == 0){

                curse.node.stuff[0] = e; 
            }



    		
    	}



    	public void append(char c){
                Node curr = head.prev;
                //check if there is room in prev node, add there
                if (curr.numitems < 2){
                        curr.addChar(c);
                        //make cursor follow with 
                        //cursor.set(curr, curr.numChars);
                       // moveCursorRight();        

                }
                //make a new node for the new characters
                else{
                //make the null spaces and move cursor        
                curr.stuff[2] = nulChar;
                //moveCursorRight( curr.block[2]);
                curr.stuff[3] = nulChar;
                //moveCursorRight(curr.block[3]);

                Node newNode = new Node( c, curr, head);         
                curr.next = newNode;
                newNode.next = head;
                newNode.prev = head.prev;
                head.prev = newNode;
                nums++;

                }
                
        }
          public void backspace(){
                if (curse.pos == 0) return;
           
                moveCursorLeft();
                curse.node.stuff[curse.offset] = nulChar;
   
                System.out.println("pos" + curse.pos);

                
                //head.prev.data[head.prev.numChars] = NULLCHAR;
    }

        // you need to make a to string method 
    	public String toString(){
    		String result = "";
    		Node current = head.next; 
    		result += head.toString(); 
    		while (current != head){
    			result += current; 
    			current = current.next; 
    		}
    		return result; 
    		
    	}


    	
        
        public  void moveCursorRight(){
            Node temp = head; 
            //creates a Node "current" which is equal to the head node
            System.out.println(curse.offset + " " + curse.node + " " + curse.pos); 
            
            
            //sets the node of the cursor at current
            if (curse.pos != 40){ 
                //checks if the cursor is at the end of the line
                System.out.println(curse.offset + " " + curse.node + " " + curse.pos);
                int check = curse.offset+1;

                if (curse.offset < 4){ 
                    //checks if the next node is null or not
                    //if it's not then the offset of the cursor increments by one
                curse.set(curse.node, curse.offset +1); 
                //sets the cursor to have an offset of plus one
                curse.pos ++ ; 
                //position increments by one
                System.out.println(curse.offset + " " + curse.node + " " + curse.pos);
            }
                else {
                    System.out.println(curse.offset + " " + curse.node + " " + curse.pos);
                    curse.node = curse.node.next; 
                    //if the offset location in a node's array == nullchar, then the cursor moves to the next node
                    curse.offset = 0; 
                    //since the cursor moves to the next node, the offset is reset back to the first element of the next node's array
                    curse.pos ++ ; 
                    //position still increments by one
                    System.out.println(curse.offset + " " + curse.node + " " + curse.pos);
                    if (curse.node == temp){ 
                        curse.pos = 0; 
                    }

                }
            }
            else{ 
                //if the cursor reaches a position of 40, it resets to be back at the start of the array
                curse = new Cursor(head, 0); 

                System.out.println(curse.offset + " " + curse.node + " " + curse.pos);
            }
        
        }
        protected void moveCursorLeft(){
            //Node curr = head;
            //cursor.node = curr.prev;

            if (curse.pos == 0) curse = new Cursor(head, 0);
        else{

                if(curse.offset > 0)
                            curse.set(curse.node, curse.offset -1);
                        else{
                          curse.set(curse.node.prev, 1);
                        }
          }
        curse.pos--;
         }
         
    
    	public class Node{
    		int numitems= 0; 
    		protected char[] stuff;
    		protected Node prev;
    		protected Node next;
    		protected int asize = 4;
    		public Node(){

    			stuff = new char[asize];
    			prev = null;
    			next = null; 
    		}
            public Node(char c, Node x, Node y ){ 
                stuff = new char[asize]; 
                prev = x; 
                next = y; 
                addChar(c);
            }
    		
    		public void addChar(char thing){
    			if (numitems<5){

    				stuff[numitems] = thing;
    				numitems++;
    			}
    		}
    		public String toString(){ 
    			//turns the Node's array into string
                String b = new String(stuff);
    			return b; 
    		}
             
            
    	}
    	    /** Cursor indicates current editing point.
        It consists of a node pointer and the char offset of
        the first empty spot.
    */
	    protected class Cursor {
	        protected Node node; // current node
	        protected int offset; // offset in node's block
	        protected int pos; // position of cursor in chars from beginning of document.
	        // first char in buffer is at 0.
	        protected Cursor(Node thenode, int theoffset) {
	            node = thenode;
	            offset = theoffset;
	            pos = 0;
	        }
	        protected void set(Node n, int off) {
	            node = n;
	            offset = off;

	        }

	    }
    	
    }