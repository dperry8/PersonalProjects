/**
 * Model interface.
 *
 * The Natural Number Calculator model consists of the top and bottom operands
 * (which have only getter methods).
 *
 * @author Bruce W. Weide
 *
 * @mathmodel <pre>
 * type NNCalcModel is modeled by
 *   (top: NATURAL_NUMBER,
 *    bottom: NATURAL_NUMBER)
 * </pre>
 * @initially <pre>
 * ():
 *  ensures
 *   this = (0, 0)
 * </pre>
 */
public interface FGCalcModel {

    /**
     * sets current grade to the input
     *
     * @ensures this.currentGrade = current
     * @param current
     */
    void setCurrentGrade(String current);

    /**
     * sets final weight to the input
     *
     * @ensures this.finalWeight = weight
     * @param weight
     */
    void setFinalWeight(String weight);

    /**
     * sets the desired grade to the input
     *
     * @ensures this.desiredWeight = desired
     * @param desired
     */
    void setDesiredGrade(String desired);

    /**
     * sets the final grade to the input
     *
     * @ensures this.finalGrade = finalG
     * @param finalG
     */
    void setFinalGrade(String finalG);

    /**
     * Reports currentGrade operand.
     *
     * @return this.currentGrade
     * @ensures currentGrade = this.currentGrade
     */
    String currentGrade();

    /**
     * Reports finalWeight operand.
     *
     * @return this.finalWeight
     * @ensures finalWeight = this.finalWeight
     */
    String finalWeight();

    /**
     * Reports desiredGrade operand.
     *
     * @return this.desiredGrade
     * @ensures desiredGrade = this.desiredGrade
     */
    String desiredGrade();

    /**
     * Reports finalGrade operand.
     *
     * @return this.desiredGrade
     * @ensures desiredGrade = this.desiredGrade
     */
    String finalGrade();

}
