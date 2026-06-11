class threadA extends Thread{
    @Override
    public void run(){
        try{for(int i=1;i<11;i++){
            System.out.println(i);
            Thread.sleep(1000);
        }}
        catch(InterruptedException e){
            System.out.println("Error!");
        }
        
    }
}
class threadB extends Thread{
    threadA thA=new threadA();
    threadB(threadA thA){
        this.thA=thA;
    }
    @Override
    public void run(){
        try{thA.join();
        System.out.println("Blast Off!");}
        catch(InterruptedException e){
            System.out.println("Error!");
        }
    }
}
class Main {
    public static void main(String[] args) throws InterruptedException {
        threadA th1=new threadA();
        threadB th2=new threadB(th1);
        th1.start();
        th2.start();
    }
}
