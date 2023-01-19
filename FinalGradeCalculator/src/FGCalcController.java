/**
 * Controller interface.
 *
 * @author Dan Perry
 *
 * @mathmodel <pre>
 * type NNCalcController is modeled by
 *   (model: NNCalcModel,
 *    view: NNCalcView)
 * </pre>
 * @initially <pre>
 * (NNCalcModel model, NNCalcView view):
 *   ensures
 *     this.model = model  and
 *     this.view = view
 * </pre>
 */
public interface FGCalcController {
    /**
     * Processes event to enter bottom operand to top.
     *
     * @updates @updates this.model.currentGrade, this.model.finalWeight,
     *          this.model.desiredGrade, this.model.finalGrade, this.view
     * @ensures <pre>
     * this.model.currentGrade = this.model.currentGrade
     * this.model.finalWeight = this.finalWeight
     * this.model.desiredGrade = this.model.desiredGrade
     * this.model.finalGrade = (desired-current*(100%-weight%))/weight%
     *
     * </pre>
     * @param currentGrade
     *            the value of your current grade
     * @param finalWeight
     *            the weight of your final
     * @param desiredGrade
     *            the grade you want to get in the class
     */
    void processEnterEvent(String currentGrade, String finalWeight,
            String desiredGrade);

    /**
     * Processes event to enter bottom operand to top.
     *
     * @updates this.model.currentGrade, this.model.finalWeight,
     *          this.model.desiredGrade, this.model.finalGrade, this.view
     * @ensures <pre>
     * this.model.currentGrade = "";
     * this.model.finalWeight = "";
     * this.model.desiredGrade = "";
     * this.model.finalGrade = "";
     * </pre>
     */
    void processClearEvent();

}
