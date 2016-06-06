public class CircularArrayQueue implements Queue{
		
		private static final int capacity = 16;
	    private Object[] Q;
	    private final int N; // capacity
	    private int f = 0;
	    private int r = 0;	 
	     
	    public CircularArrayQueue(){
	        this(capacity);
	    }
	     
	    public CircularArrayQueue(int capacity){
	        N = capacity;
	        Q = new Object[N];
	    }
	 
	    public int size() {
	        if(r > f)
	            return r - f;
	        return N - f + r;
	    }
	 
	    public boolean isEmpty() {
	        return (r == f) ? true : false;
	    }
	 
	    public boolean isFull() {
	        int diff = r - f; 
	        if(diff == -1 || diff == (N -1))
	            return true;
	        return false;
	    }
	 
	    public void enqueue(Object obj) throws QueueFullException {
	        if(isFull()){
	            throw new QueueFullException("Queue is Full.");
	        }else{
	            Q[r] = obj;
	            r = (r + 1) % N;
	        }
	    }
	 
	    public Object dequeue() throws QueueEmptyException {
	        Object item; 
	        if(isEmpty()){
	            throw new QueueEmptyException();
	        }else{
	            item = Q[f];
	            Q[f] = null;
	            f = (f + 1) % N;
	        }
	       return item;
	    }
	 
	    public Instruction updateInstructionInROBQ(Instruction instructionObj){
	    	Instruction returnObj = null;
	    	
	    	for(int i=f;i<r;i++){
	    		returnObj=(Instruction) Q[i];
	    		if(instructionObj.getInstrNumber()==returnObj.getInstrNumber()){
	    			//System.out.println("Instruction Number is "+instructionObj.getInstrNumber());
	    			returnObj.setResult(instructionObj.getResult());
	    			returnObj.setDetsinationValidBit(true);
	    			returnObj.setStage("completed");
	    		}
	    	}
	    	return returnObj;
	    }
	    
	    public void printList(){
	    	Instruction returnObj = null;
	    	for(int i=f;i<r;i++){
	    		returnObj=(Instruction) Q[i];
	    		System.out.println("Printing "+returnObj);
	    	}
	    }
	    
	    public Instruction getHeadOfROB(){
	    	return (Instruction) Q[f];
	    }
}
