package Places;

import Items.Key;

public class LockDoor extends Exit {

	private boolean lock;
	private Key key = null;
	
	// =============================================================================
	// Constructor
	public LockDoor(String name, Place p1, Place p2) {
		super(name,p1, p2);
		this.lock = true;				
	}
	
	// =============================================================================
	public boolean isLock(){
		return this.lock;
	}
	
	// =============================================================================
	// Method to set a key
	public void setKey(Key k){
		if(k != null)
			this.key = k;
	}
	
	// =============================================================================
	// Method to get the key
	public Key getKey(){
		return this.key;
	}
	
	// =============================================================================
	public void open() {
		if(!this.lock)
			super.open();
	}
	
	// =============================================================================
	public void lock() {
		this.lock = true;
	}
	
	// =============================================================================
	public void unlock() {
		this.lock = false;
	}
	
	// =============================================================================
	public void close() {
		if(super.isOpen())
			super.close();
	}

}