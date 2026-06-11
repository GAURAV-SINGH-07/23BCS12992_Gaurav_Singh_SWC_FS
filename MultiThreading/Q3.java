class PiggyBank extends Thread{
    static int balance=0;
    public void run(){
        for(int i=0;i<2000;i++){
            add();
        }
    }
    static synchronized void add(){ balance++;}
    int get() {return balance;}
}
class Main {
    public static void main(String[] args) throws InterruptedException {
        PiggyBank[] family=new PiggyBank[5];
        for(int i=0;i<5;i++){
            family[i]=new PiggyBank();
        }
        for(int i=0;i<5;i++){
            family[i].start();
        }
        for(int i=0;i<5;i++){
            family[i].join();
        }
        System.out.println("Balance: "+PiggyBank.balance);
    }
}
