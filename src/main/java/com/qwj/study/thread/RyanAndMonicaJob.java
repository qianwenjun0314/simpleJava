package com.qwj.study.thread;

public class RyanAndMonicaJob implements Runnable{
	
	//确保只有一个bankaccount的实例
	private BankAccount account = new BankAccount();
	
	public void run(){
		for(int i=0;i<10;i++){
			makeWithdrawal(10);
			if(account.getBalance() < 0){
				System.out.println("已透支");
			}
		}
	}



	//synchronized这个关键词来修饰方法使他每次只能被单一的线程存取，他代表线程需要一把钥匙来存取被同步化过的线程
	//要保护数据，就需要吧作用在数据上的方法给同步化
	//让整个方法执行起来更具有原子化。。。

	//每个数据对象都具有锁，但大部分时间这个锁是没有锁上的，对象的锁只会在有同步化的方法上起作用
	//当对象有一个或多个同步化的方法时候，线程只有在取得对象锁的钥匙时才能进入同步化的方法
	
//	private void makeWithdrawal(int amount){
	private synchronized void makeWithdrawal(int amount){
		if(account.getBalance() >= amount){
			try {
				System.out.println(Thread.currentThread().getName() + "准备去提款");			
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "醒啦");	
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName() + "完成提款");	
		}else{
			System.out.println(Thread.currentThread().getName() + "不好意思，余额不足");	

		}
	}
	
	public static void main(String[] args){
		RyanAndMonicaJob myjob = new RyanAndMonicaJob();
		Thread one = new Thread(myjob);
		Thread two = new Thread(myjob);
		one.setName("Ryan");
		two.setName("Monica");
		one.start();
		two.start();		
	}

}
