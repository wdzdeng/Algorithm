package github.com.wdzdeng.algorithm.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumerQueue<T> {
     private Object[] items;
     private int size;
     private int currentIndex = -1;
     private Lock lock = new ReentrantLock();
     private Condition producerCondition = lock.newCondition();
     private Condition consumerCondition =  lock.newCondition();
     public  ProducerAndConsumerQueue(int size){
         this.size = size;
         items = new Object[size];
     }
     public void add(T t){
         lock.lock();
         try{
             while (currentIndex == size-1){
                 System.out.println("满了");
                 producerCondition.await();
             }
             ++currentIndex;
             items[currentIndex] = t;
             consumerCondition.signalAll();
         }catch (Exception e){
             System.out.println(e);
         }finally {
             lock.unlock();
         }
     }

     public T  remove(){
         lock.lock();
         T t = null;
         try {
             while (currentIndex == -1) {
                 System.out.println("空的");
                 consumerCondition.await();
             }
             t = (T)items[currentIndex];
             if (--currentIndex <= 0) currentIndex=0 ;
             producerCondition.signalAll();
         }catch (Exception e){
             System.out.println(e);
         }finally {
             lock.unlock();
         }
         return t;
     }

    public static void main(String[] args) {
        ProducerAndConsumerQueue queue = new ProducerAndConsumerQueue(5);

        new Thread(()->{

            while (true){
                Object object = new Object();
                queue.add(object);
                System.out.println("我是生产者。。。。。。。。。");
                System.out.println(Thread.currentThread().getName()+" "+queue.currentIndex);
            }

        }).start();

        new Thread(() ->{
            while (true){
                Object object = queue.remove();
                System.out.println("我是消费者。");
                System.out.println(Thread.currentThread().getName()+" "+queue.currentIndex);
            }

        }).start();


    }
}
