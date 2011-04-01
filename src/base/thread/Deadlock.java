/**
 * 
 */
package base.thread;

/**
 * @author lj04482
 *
 */
public class Deadlock {
	 class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me!%n",this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
    	Deadlock dl = new Deadlock();
        final Friend alphonse = dl.new Friend("Alphonse");
        final Friend gaston = dl.new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}
