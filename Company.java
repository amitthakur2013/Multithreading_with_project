class Company {
	int n;
	boolean f=false;

	// f is false then chance is for producer

	synchronized public void produce_item(int n){
		try {
			if(f) {
				wait();
			}
			this.n=n;
			System.out.println("produced : "+this.n);
			f=true;
			notify();
		} catch(Exception e){}
	}

	synchronized public int consume_item(){
		try{
			if(!f) {
				wait();
			}
			System.out.println("consumed : "+this.n);
			f=false;
			notify();
		} catch(Exception e){}
		return this.n;
	}
}