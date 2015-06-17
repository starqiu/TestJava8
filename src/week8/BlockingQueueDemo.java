package week8;

import java.util.concurrent.*;
class Producer1 implements Runnable
{
	private BlockingQueue<Integer> queue;
	public Producer1(BlockingQueue<Integer> queue){
		this.queue = queue;
	}
	public void run(){
		for(int i=0; i<=10; i++){
			try{
				Thread.sleep((int)(Math.random()*10));
				queue.put(i); 
				System.out.println("Produce "+i+".");
			}catch(InterruptedException ex){}
		}
	}
}
class Consumer1 implements Runnable
{
	private BlockingQueue<Integer> queue;
	public Consumer1(BlockingQueue<Integer> queue){
		this.queue = queue;
	}
	public void run(){
		for(int i=0; i<=10; i++){
			try{
				Thread.sleep((int)(Math.random()*20));
				Integer product = queue.take(); 
				System.out.println("Consume "+product+".");
			}catch(InterruptedException ex){}
		}
	}
}
class BlockingQueueDemo
{
	public static void main(String[] args) 
	{
		BlockingQueue<Integer> queue = 
			new ArrayBlockingQueue<>(3); 
		new Thread(new Producer1(queue)).start();
		new Thread(new Consumer1(queue)).start();
	}
}