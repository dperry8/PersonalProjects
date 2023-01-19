/**
 * Model class.
 *
 * @author Dan Perry
 */
public final class FGCalcModel1 implements FGCalcModel {

    /**
     * Model variables.
     */
    private String currentGrade, desiredGrade, finalWeight, finalGrade;

    /**
     * Default constructor.
     */
    public FGCalcModel1() {
        this.currentGrade = "";
        this.finalWeight = "";
        this.desiredGrade = "";
        this.finalGrade = "";
    }

    @Override
    public void setCurrentGrade(String current) {
        this.currentGrade = current;
    }

    @Override
    public String currentGrade() {
        return this.currentGrade;
    }

    @Override
    public void setFinalWeight(String weight) {
        this.finalWeight = weight;
    }

    @Override
    public String finalWeight() {
        return this.finalWeight;
    }

    @Override
    public void setDesiredGrade(String desired) {
        this.desiredGrade = desired;
    }

    @Override
    public String desiredGrade() {
        return this.desiredGrade;
    }

    @Override
    public void setFinalGrade(String finalG) {
        this.finalGrade = finalG;

    }

    @Override
    public String finalGrade() {
        return this.finalGrade;
    }

}
