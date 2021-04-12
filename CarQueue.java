import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	
	private Queue<Integer> queue;
	private int direction;
	Random rand;
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int RIGHT = 2;
	public static final int LEFT = 3;
	
	public CarQueue() {
		rand = new Random();
		queue = new ArrayDeque<Integer>();
		
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
	}
	
	public void addToQueue() {
		
		rand = new Random();
		
		class Movement implements Runnable{

			@Override
			public void run() {
				try {
					while(true) {
						direction = rand.nextInt(4);
						queue.add(direction);
						Thread.sleep(200);
						}
					} catch(InterruptedException e) {
					} finally {
						
					}
				}
			}
		
		Runnable r = new Movement();
		Thread t = new Thread(r);
		t.start();
		
	}
	
	
	public Integer deleteQueue() {
		return queue.remove();
	}

}
