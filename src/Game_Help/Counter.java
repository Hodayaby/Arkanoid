// 322209289 Hodaya Ben Yashar
package Game_Help;
/**
 * @author Hodaya Ben Yashar
 * The type Counter info.
 */
public class Counter {
    private int count;

    /**
     * Instantiates a new Counter.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * Add number to current count.
     * @param number the number that his value we add.
     */

   public void increase(int number) {
        this.count += number;
    }

    /**
     * Subtract number from current count.
     * @param number the number that his value we subtract.
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * Gets the current count.
     * @return the value of the count.
     */
   public int getValue() {
        return this.count;
    }
}
