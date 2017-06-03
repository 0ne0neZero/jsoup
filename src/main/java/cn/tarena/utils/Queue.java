package cn.tarena.utils;



import java.util.LinkedList;


public  class Queue<T> {
	private   LinkedList<T> queue = new LinkedList<T>();
	public  void inQueue(T t){
		queue.add(t);
	}
	//队列加锁
	public synchronized T deQueue(){
		return queue.removeFirst();
	}
	public boolean isQueueEmpty(){
		return queue.isEmpty();
	}
	public boolean contains(T t){
		return queue.contains(t);
	}
	public boolean empty(){
		return queue.isEmpty();
	}

}
