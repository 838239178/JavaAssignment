package deadlock;

public class Philosopher extends Thread{
    private final int id;
    private final Fork fork;

    public Philosopher(int id, Fork fork){
        this.id = id;
        this.fork = fork;
    }

    private void eat(){
        System.out.println(id + " " + "is eating");
        try {
            Thread.sleep((long) (Math.random()*500+500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think(){
        System.out.println(id + ":" + "is thinking");
        try {
            Thread.sleep((long) (Math.random()*1000+2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        double choice = Math.random();

        //先吃或者先思考
        if(choice>=0.5){
            think();
            fork.getForks(id);
            eat();
            fork.returnForks(id);
        } else {
            fork.getForks(id);
            eat();
            fork.returnForks(id);
            think();
        }

    }
}
