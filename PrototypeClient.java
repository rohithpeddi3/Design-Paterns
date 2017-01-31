/*
 * PROTOTYPE PATTERN
 * 
 * Client- creates a new object by asking prototype to clone itself
 * Prototype- declares an interface for cloning itself
 * ConcretePrototype- implements the operation for cloning itself
 * 
 */

interface Prototype{
	abstract Object clone();
}

class ConcretePrototype implements Prototype{
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

public class PrototypeClient {
	
	public static void main(String args[]){
		ConcretePrototype ob1 = new ConcretePrototype();
		ConcretePrototype ob2 = (ConcretePrototype) ob1.clone();
	}

}
