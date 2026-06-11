class Search extends Thread{
    String[] arr;
    int start,end;
    String word;
    static volatile boolean found = false;
    Search(String[] arr,int start,int end,String word){
        this.arr=arr;
        this.start=start;
        this.end=end;
        this.word=word;
    }
    public void run(){
        for(int i=start;i<=end && !found;i++){
            if(arr[i].equals(word)){
                found=true;
                System.out.println("Found by " + Thread.currentThread().getName());
                
                break;
            }
        }   
    }
}
class Main {
    public static void main(String[] args) throws InterruptedException{
        String str="A single chef chopping onions pausing to stir the soup and pausing again to answer the phone They are executing multiple tasks concurrently but can only physically do one action at a exact moment";
        String[] arr=str.split(" ");
        String word="to";
        int sz=arr.length;
        int prt=(sz+1)/3;
        int start1=0,end1=prt-1,start2=prt,end2=start2+prt-1,start3=end2+1,end3=sz-1;
        Search t1=new Search(arr,start1,end1,word);
        Search t2=new Search(arr,start2,end2,word);
        Search t3=new Search(arr,start3,end3,word);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Search completed");
    }
}
