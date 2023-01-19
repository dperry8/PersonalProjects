import java.awt.event.ActionListener;

/**
 * View interface.
 *
 * @author Dan Perry
 */
public interface FGCalcView extends ActionListener {

    /**
     * Register argument as observer/listener of this; this must be done first,
     * before any other methods of this class are called.
     *
     * @param controller
     *            controller to register
     */
    void registerObserver(FGCalcController controller);

    /**
     * Updates the current grade operand display based on String provided as
     * argument.
     *
     * @param current
     *            new value of currentGrade operand display
     */
    void updateCurrentGradeDisplay(String current);

    /**
     * Updates the final weight operand display based on String provided as
     * argument.
     *
     * @param weight
     *            new value of currentGrade operand display
     */
    void updateFinalWeightDisplay(String weight);

    /**
     * Updates the desired grade operand display based on String provided as
     * argument.
     *
     * @param desired
     *            new value of currentGrade operand display
     */
    void updateDesiredGradeDisplay(String desired);

    /**
     * Updates the final grade operand display based on String provided as
     * argument.
     *
     * @param finalG
     *            new value of finalGrade operand display
     */
    void updateFinalGradeDisplay(String finalG);

}
