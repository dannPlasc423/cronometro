public class App {
    public static void main(String[] args) throws Exception {
        Cronometro c = new Cronometro();
        c.avanzar(); 
    }
}

class Cronometro{
    private int min, seg, hor;
    private String m, s, h;

    public Cronometro(){
        this.min = 0;
        this.seg = 0;
        this.hor = 0;
    }

    public void avanzar(){
        Hilo h1 = new Hilo();
        Thread t1 = new Thread(h1);

        Hilo h2 = new Hilo();
        Thread t2 = new Thread(h2);

        t1.start();
        try{
            t1.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        t2.start();
        try{
            t2.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    class Hilo extends Thread{
        public void run(){
            while(true){
                s = (seg < 10) ? "0" + seg: "" + seg;
                m = (min < 10) ? "0" + min: "" + min;
                h = (hor < 10) ? "0" + hor: "" + hor;
                seg++;
                if(seg > 60){
                    min++;
                    seg = 0;
                }
                if(min > 60){
                    hor++;
                    min = 0;
                }
                System.out.println(h + ":" + m + ":" + s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
