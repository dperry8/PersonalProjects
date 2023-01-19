import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * View class.
 *
 * @author Dan Perry
 */
public final class FGCalcView1 extends JFrame implements FGCalcView {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Controller object registered with this view to observe user-interaction
     * events.
     */
    private FGCalcController controller;

    /**
     * State of user interaction: last event "seen".
     */
    private enum State {
        /**
         * Last event was clear, enter, another operator, or digit entry, resp.
         */
        SAW_CLEAR, SAW_ENTER_OR_SWAP, SAW_OTHER_OP, SAW_DIGIT
    }

    /**
     * State variable to keep track of which event happened last; needed to
     * prepare for digit to be added to bottom operand.
     */
    private State currentState;

    /**
     * Text areas.
     */
    private final JTextArea currentGrade, finalWeight, desiredGrade, finalGrade;

    /**
     * Operator and related buttons.
     */
    private final JButton enter, clear;

    /**
     * Text box labels.
     */
    private final JLabel currentGradeLabel, finalWeightLabel, desiredGradeLabel,
            finalGradeLabel;

    /**
     * Useful constants.
     */
    private static final int TEXT_AREA_HEIGHT = 2, TEXT_AREA_WIDTH = 10,
            BUTTON_PANEL_GRID_ROWS = 5, BUTTON_PANEL_GRID_COLUMNS = 2;

    /**
     * Default constructor.
     */
    public FGCalcView1() {
        // Create the JFrame being extended

        /*
         * Call the JFrame (superclass) constructor with a String parameter to
         * name the window in its title bar
         */
        super("Final Grade Calculator");

        // Set up the GUI widgets --------------------------------------------

        /*
         * Set up initial state of GUI to behave like last event was "Clear";
         * currentState is not a GUI widget per se, but is needed to process
         * digit button events appropriately
         */
        this.currentState = State.SAW_CLEAR;
        /*
         * Create widgets
         */

        // Set up the GUI widgets --------------------------------------------

        this.currentGradeLabel = new JLabel("Enter your current grade:");
        this.finalWeightLabel = new JLabel("Enter the weight of your final:");
        this.desiredGradeLabel = new JLabel("Enter the final grade you want:");
        this.finalGradeLabel = new JLabel("This is what you need:");

        this.currentGrade = new JTextArea("", TEXT_AREA_HEIGHT,
                TEXT_AREA_WIDTH);
        this.finalWeight = new JTextArea("", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.desiredGrade = new JTextArea("", TEXT_AREA_HEIGHT,
                TEXT_AREA_WIDTH);
        this.finalGrade = new JTextArea("", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);

        this.enter = new JButton("enter");
        this.clear = new JButton("clear");
        /*
         * Text areas should wrap lines, and should be read-only; they cannot be
         * edited because allowing keyboard entry would require checking whether
         * entries are digits, which we don't want to have to do
         */
        this.currentGrade.setEditable(true);
        this.currentGrade.setLineWrap(true);
        this.currentGrade.setWrapStyleWord(true);
        this.finalWeight.setEditable(true);
        this.finalWeight.setLineWrap(true);
        this.finalWeight.setWrapStyleWord(true);
        this.desiredGrade.setEditable(true);
        this.desiredGrade.setLineWrap(true);
        this.desiredGrade.setWrapStyleWord(true);
        this.finalGrade.setEditable(false);
        this.finalGrade.setLineWrap(true);
        this.finalGrade.setWrapStyleWord(true);
        /*
         * Create scroll panes for the text areas in case number is long enough
         * to require scrolling
         */
        JScrollPane currentGradeScrollPane = new JScrollPane(this.currentGrade);
        JScrollPane finalWeightScrollPane = new JScrollPane(this.finalWeight);
        JScrollPane desiredGradeScrollPane = new JScrollPane(this.desiredGrade);
        JScrollPane finalGradeScrollPane = new JScrollPane(this.finalGrade);
        /*
         * Create button panel
         */
        JPanel buttonPanel = new JPanel(new GridLayout(BUTTON_PANEL_GRID_ROWS,
                BUTTON_PANEL_GRID_COLUMNS));
        /*
         * Adds everything to the buttonPanek from the left to right, top to
         * bottom
         */
        buttonPanel.add(this.currentGradeLabel);
        buttonPanel.add(currentGradeScrollPane);
        buttonPanel.add(this.finalWeightLabel);
        buttonPanel.add(finalWeightScrollPane);
        buttonPanel.add(this.desiredGradeLabel);
        buttonPanel.add(desiredGradeScrollPane);
        buttonPanel.add(this.finalGradeLabel);
        buttonPanel.add(finalGradeScrollPane);
        buttonPanel.add(this.enter);
        buttonPanel.add(this.clear);

        /*
         * Adds the button panel to this object
         */
        this.add(buttonPanel);
        /*
         * Register this object as the observer for all GUI events
         */
        this.enter.addActionListener(this);
        this.clear.addActionListener(this);

        // Set up the main application window --------------------------------

        /*
         * Make sure the main window is appropriately sized, exits this program
         * on close, and becomes visible to the user
         */
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void registerObserver(FGCalcController controller) {
        this.controller = controller;
    }

    @Override
    public void updateCurrentGradeDisplay(String current) {
        this.currentGrade.setText(current);
    }

    @Override
    public void updateFinalWeightDisplay(String weight) {
        this.finalWeight.setText(weight);
    }

    @Override
    public void updateDesiredGradeDisplay(String desired) {
        this.desiredGrade.setText(desired);
    }

    @Override
    public void updateFinalGradeDisplay(String finalG) {
        this.finalGrade.setText(finalG);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * Set cursor to indicate computation on-going; this matters only if
         * processing the event might take a noticeable amount of time as seen
         * by the user
         */
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        /*
         * Determine which event has occurred that we are being notified of by
         * this callback; in this case, the source of the event (i.e, the widget
         * calling actionPerformed) is all we need because only buttons are
         * involved here, so the event must be a button press; in each case,
         * tell the controller to do whatever is needed to update the model and
         * to refresh the view
         */
        Object source = event.getSource();
        if (source == this.enter) {
            this.controller.processEnterEvent(this.currentGrade.getText(),
                    this.finalWeight.getText(), this.desiredGrade.getText());
        } else if (source == this.clear) {
            this.controller.processClearEvent();
        }
        /*
         * Set the cursor back to normal (because we changed it at the beginning
         * of the method body)
         */
        this.setCursor(Cursor.getDefaultCursor());
    }

}
