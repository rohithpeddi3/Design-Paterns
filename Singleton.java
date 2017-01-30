
/*
 * Used only when one instance of a class is to be created 
 * # Design of logger classes - provides a global logging access point
 * # Configuration classes - global access point+ an instance is stored in cache[No need of reloading all the values]
 * # Accessing resources in shared mode - application that works with the serial port[Used to manage all operations on port]
 * # Factories implemented as singletons - application with a factory to generate new objects, in multithreading environment 
 */

public class Singleton {
	
	private static Singleton instance;
	
	private Singleton(){
		
	}
	
	public static synchronized Singleton getInstance(){
		if(instance==null){
			instance = new Singleton();
		} 
		return instance;
	}
	
	public void doSomething(){
		
	}
	
}

//Uses double locking mechanism since synchronized operation is costly 
//each time the instance is required if process is synchronized then it takes a lot of time
class LazySingleton{
	private static LazySingleton instance;
	private LazySingleton(){
		
	}
	public static LazySingleton getInstance(){
		if(instance==null){
			synchronized(LazySingleton.class){
				if(instance==null){
					System.out.println("First time getInstance() is called ");
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
}

//Early instantiation of instance at the time of loading class

class EarlySingleton{
	
	private static EarlySingleton instance = new EarlySingleton();
	private EarlySingleton(){
		
	}
	
	public EarlySingleton getInstance(){
		return instance;
	}
	
}
