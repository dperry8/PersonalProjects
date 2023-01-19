/**
 * Final Grade Calculator
 *
 * This is a calculator that uses strings to take 3 inputs and calculate what
 * grade you need on you finals to get the chosen grade you want in the class.
 * It asks you for 3 inputs: one is the current grade you have, the second is
 * the weight of you final in the class, and third is the grade you want to have
 * after the final. It takes these 3 values into consideration and calculates
 * what you need to score to get the grade you want.
 *
 * @author Dan Perry
 *
 */
public final class FinalGradeCalculator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private FinalGradeCalculator() {
    }

    /**
     * Main program that sets up main application window and starts user
     * interaction.
     *
     * @param args
     *            command-line arguments; not used
     */
    public static void main(String[] args) {
        /*
         * Create instances of the model, view, and controller objects;
         * controller needs to know about model and view, and view needs to know
         * about controller
         */
        FGCalcModel model = new FGCalcModel1();
        FGCalcView view = new FGCalcView1();
        FGCalcController controller = new FGCalcController1(model, view);

        view.registerObserver(controller);
    }

}
