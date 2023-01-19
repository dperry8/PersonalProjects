/**
 * Controller class.
 *
 * @author Dan Perry
 */
public final class FGCalcController1 implements FGCalcController {

    /**
     * Model object.
     */
    private final FGCalcModel model;

    /**
     * View object.
     */
    private final FGCalcView view;

    /**
     * useful double.
     */
    private static final double HUNDRED = 100.0;

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(FGCalcModel model,
            FGCalcView view) {

        String current = model.currentGrade();
        String weight = model.finalWeight();
        String desired = model.desiredGrade();
        String finalG = model.finalGrade();

        view.updateCurrentGradeDisplay(current);
        view.updateFinalWeightDisplay(weight);
        view.updateDesiredGradeDisplay(desired);
        view.updateFinalGradeDisplay(finalG);
    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public FGCalcController1(FGCalcModel model, FGCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    /**
     * Processes clear event.
     */
    @Override
    public void processClearEvent() {

        this.model.setCurrentGrade("");
        this.model.setFinalWeight("");
        this.model.setDesiredGrade("");
        this.model.setFinalGrade("");

        updateViewToMatchModel(this.model, this.view);

    }

    /**
     * Processes enter event.
     *
     * @param currentGrade
     *            the value of your current grade
     * @param finalWeight
     *            the weight of your final
     * @param desiredGrade
     *            the grade you want to get in the class
     */
    @Override
    public void processEnterEvent(String currentGrade, String finalWeight,
            String desiredGrade) {
        /**
         * Calculates the final grade (desired-current*(100%-weight%))/weight%
         */
        if (!currentGrade.equals("") && !finalWeight.equals("")
                && !desiredGrade.equals("")) {
            double weightPercentage = Double.valueOf(finalWeight) / HUNDRED;
            double grade = (Double.valueOf(desiredGrade)
                    - Double.valueOf(currentGrade) * (1.0 - weightPercentage))
                    / weightPercentage;

            this.model.setFinalGrade(
                    String.valueOf(Math.round(grade * HUNDRED) / HUNDRED));
        } else {
            this.model.setFinalGrade("");
        }
        this.model.setCurrentGrade(currentGrade);
        this.model.setFinalWeight(finalWeight);
        this.model.setDesiredGrade(desiredGrade);

        updateViewToMatchModel(this.model, this.view);
    }
}
