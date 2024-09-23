// 322209289 Hodaya Ben Yashar
package Game_Help;
/**
 * @author Hodaya Ben Yashar
 * The interface HitNotifier.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl the hit listener
     */
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl the hit listener
     */
    void removeHitListener(HitListener hl);
}
