package com.example.android.floweryquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    /**
     * variables
     */
    boolean question1Completed = false;
    boolean question2Completed = false;
    boolean question3Completed = false;
    boolean question4Completed = false;
    boolean question5Completed = false;
    boolean question6Completed = false;
    boolean question7Completed = false;
    //RadioButtons questions
    boolean oneCorrect = false;
    boolean twoCorrect = false;
    boolean fourCorrect = false;

    /**
     * onCreate assigns OnClickListener to a checkbox in q.3
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Little hint for question 3.
        final CheckBox chk3C = (CheckBox) findViewById(R.id.checkbox_3_c);
        chk3C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action on click
                if (chk3C.isChecked()) {
                    Toast.makeText(getApplicationContext(), R.string.hint_q3,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * While question 1 is clicked - check which answer is chosen and assess if answer
     * for question 1 is correct.
     *
     * @param view gives information which Radio Group is checked
     */
    public void isOneCorrect(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_1_a:
                if (checked)
                    oneCorrect = true;
                break;
            case R.id.radio_1_b:
                if (checked)
                    oneCorrect = false;
                break;
            case R.id.radio_1_c:
                if (checked)
                    oneCorrect = false;
                break;
        }
        // Validates if question 1 is answered at all (works only onClick).
        question1Completed = true;
    }

    /**
     * While question 2 is clicked - check which answer is chosen and assess if answer
     * for question 2 is correct.
     *
     * @param view gives information which Radio Group is checked
     */
    public void isTwoCorrect(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_2_a:
                if (checked)
                    twoCorrect = false;
                break;
            case R.id.radio_2_b:
                if (checked)
                    twoCorrect = false;
                break;
            case R.id.radio_2_c:
                if (checked)
                    twoCorrect = true;
                break;
        }
        // Validates if question 2 is answered at all (works only onClick).
        question2Completed = true;
    }

    /**
     * This method checks if answers (check boxes) for 3rd question are correct.
     *
     * @return answers are correct or not?
     */
    public boolean isThreeCorrect() {
        CheckBox threeACheckBox = (CheckBox) findViewById(R.id.checkbox_3_a);
        CheckBox threeBCheckBox = (CheckBox) findViewById(R.id.checkbox_3_b);
        // Why does it work without R.id?!
        CheckBox threeCCheckBox = (CheckBox) findViewById(R.id.checkbox_3_c);
        CheckBox threeDCheckBox = (CheckBox) findViewById(R.id.checkbox_3_d);
        // Validate if any answer is checked
        if (!(threeACheckBox.isChecked() || threeBCheckBox.isChecked() || threeCCheckBox.isChecked() ||
                threeDCheckBox.isChecked())) {
            question3Completed = false;
            return false;
        } else {
            question3Completed = true;
            // Correct answers are A, B, D altogether. Return if correct boxes are now checked?
            return (threeACheckBox.isChecked() && threeBCheckBox.isChecked() && threeDCheckBox.isChecked());
        }
    }

    /**
     * While question 4 is clicked - check which answer is chosen and assess if answer
     * for question 4 is correct.
     *
     * @param view gives information which Radio Group is checked
     */
    public void isFourCorrect(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_4_a:
                if (checked)
                    fourCorrect = false;
                break;
            case R.id.radio_4_b:
                if (checked)
                    fourCorrect = true;
                break;
            case R.id.radio_4_c:
                if (checked)
                    fourCorrect = false;
                break;
        }
        // Validates if question 4 is answered at all (works only onClick).
        question4Completed = true;
    }

    /**
     * This method checks if answers (check boxes) for 5th question are correct.
     *
     * @return answers are correct or not?
     */
    public boolean isFiveCorrect() {
        CheckBox fiveACheckBox = (CheckBox) findViewById(R.id.checkbox_5_a);
        CheckBox fiveBCheckBox = (CheckBox) findViewById(R.id.checkbox_5_b);
        CheckBox fiveCCheckBox = (CheckBox) findViewById(R.id.checkbox_5_c);
        CheckBox fiveDCheckBox = (CheckBox) findViewById(R.id.checkbox_5_d);
        CheckBox fiveECheckBox = (CheckBox) findViewById(R.id.checkbox_5_e);
        // Validate if any answer is checked
        if (!(fiveACheckBox.isChecked() || fiveBCheckBox.isChecked() || fiveCCheckBox.isChecked() ||
                fiveDCheckBox.isChecked() || fiveECheckBox.isChecked())) {
            question5Completed = false;
            return false;
        } else {
            question5Completed = true;
            // Correct answers are A, B, E altogether. Return if correct boxes are now checked?
            return (fiveACheckBox.isChecked() && fiveBCheckBox.isChecked() && fiveECheckBox.isChecked());
        }
    }

    /**
     * This method checks if answer given in EditText field for 6th question is correct.
     *
     * @return input answer is correct or not?
     */
    public boolean isSixCorrect() {
        boolean sixCorrect = false;
        EditText sixEditText = (EditText) findViewById(R.id.question_6_input);
        String insertedSixAnswer = sixEditText.getText().toString();
        if (insertedSixAnswer.equalsIgnoreCase(getString(R.string.maple1)) ||
                insertedSixAnswer.equalsIgnoreCase(getString(R.string.maple2)) ||
                insertedSixAnswer.equalsIgnoreCase(getString(R.string.maple3)) ||
                insertedSixAnswer.equalsIgnoreCase(getString(R.string.maple4))) {
            sixCorrect = true;
        }
        // "If" must read current state of EditText field, even if user removes answer
        question6Completed = !(insertedSixAnswer.equals(""));
        return sixCorrect;
    }

    /**
     * This method checks if answers (check boxes) for 7th question are correct.
     *
     * @return answers are correct or not?
     */
    public boolean isSevenCorrect() {
        CheckBox sevenACheckBox = (CheckBox) findViewById(R.id.checkbox_7_a);
        CheckBox sevenBCheckBox = (CheckBox) findViewById(R.id.checkbox_7_b);
        CheckBox sevenCCheckBox = (CheckBox) findViewById(R.id.checkbox_7_c);
        CheckBox sevenDCheckBox = (CheckBox) findViewById(R.id.checkbox_7_d);
        // Validate if any answer is checked
        if (!(sevenACheckBox.isChecked() || sevenBCheckBox.isChecked() || sevenCCheckBox.isChecked() ||
                sevenDCheckBox.isChecked())) {
            question7Completed = false;
            return false;
        } else {
            question7Completed = true;
            // Correct answers are B, D altogether. Return if correct boxes are now checked?
            return (sevenBCheckBox.isChecked() && sevenDCheckBox.isChecked());
        }
    }

    /**
     * Shows hint for question 5 onClick.
     *
     * @param view gives view of the checkbox
     */
    public void onCheckbox5Clicked(View view) {
        // Is the question view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked.
        switch (view.getId()) {
            case R.id.checkbox_5_c:
                if (checked) {
                    // Little hint for question 5.
                    Toast.makeText(getApplicationContext(), R.string.hint_q5,
                            Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.checkbox_5_d:
                if (checked) {
                    // Hint again.
                    Toast.makeText(getApplicationContext(), R.string.hint_q5,
                            Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }

    /**
     * Checks if user gave his/her name.
     *
     * @return is name given in first input field?
     */
    public boolean isNameGiven() {
        //Is name given?
        boolean nameIsGiven = false;
        EditText nameEditText = (EditText) findViewById(R.id.name_input);
        String givenName = nameEditText.getText().toString();
        if (!(Arrays.asList("", " ", "  ", "   ").contains(givenName))) {
            nameIsGiven = true;
        }
        return nameIsGiven;
    }

    /**
     * Checks if all questions are answered. If not, displays message which should be filled.
     *
     * @return are all questions in quiz answered?
     */
    public boolean isQuizComplete() {
        //Check in questions that do not work 'onClick' if they were filled.
        isThreeCorrect();
        isFiveCorrect();
        isSixCorrect();
        isSevenCorrect();
        //Prepare message to be displayed if any question is not filled.
        String notCompletedMessage = getString(R.string.not_completed_message);
        if (!question1Completed) {
            notCompletedMessage += getString(R.string.q1);
        }
        if (!question2Completed) {
            notCompletedMessage += getString(R.string.q2);
        }
        if (!question3Completed) {
            notCompletedMessage += getString(R.string.q3);
        }
        if (!question4Completed) {
            notCompletedMessage += getString(R.string.q4);
        }
        if (!question5Completed) {
            notCompletedMessage += getString(R.string.q5);
        }
        if (!question6Completed) {
            notCompletedMessage += getString(R.string.q6);
        }
        if (!question7Completed) {
            notCompletedMessage += getString(R.string.q7);
        }
        //If any question is not completed - display message with list which of them need to be revised.
        boolean isCompleted = (question1Completed && question2Completed && question3Completed &&
                question4Completed && question5Completed && question6Completed && question7Completed);
        if (!isCompleted) {
            displayQuizMessage(notCompletedMessage);
        }
        return isCompleted;
    }

    /**
     * Counts score if each question is answered correctly.
     *
     * @return final score of the quiz
     */
    public int countScore() {
        int scoreFinal = 0;
        String incorrectFinalMessage = getString(R.string.incorrect_message);
        //Check scores or unsolved questions:
        if (oneCorrect) {
            scoreFinal += 1;
        } else {
            incorrectFinalMessage += getString(R.string.q1);
        }
        if (twoCorrect) {
            scoreFinal += 1;
        } else {
            incorrectFinalMessage += getString(R.string.q2);
        }
        if (isThreeCorrect()) {
            scoreFinal += 1;
        } else {
            incorrectFinalMessage += getString(R.string.q3);
        }
        if (fourCorrect) {
            scoreFinal += 1;
        } else {
            incorrectFinalMessage += getString(R.string.q4);
        }
        if (isFiveCorrect()) {
            scoreFinal += 1;
        } else {
            incorrectFinalMessage += getString(R.string.q5);
        }
        if (isSixCorrect()) {
            scoreFinal += 1;
        } else {
            incorrectFinalMessage += getString(R.string.q6);
        }
        if (isSevenCorrect()) {
            scoreFinal += 1;
        } else {
            incorrectFinalMessage += getString(R.string.q7);
        }
        //If all answers correct - you have 7 points
        if (scoreFinal < 7) {
            displayIncorrectMessage(incorrectFinalMessage);
        } else {
            TextView incorrectText = (TextView) findViewById(R.id.incorrect_text_view);
            incorrectText.setVisibility(View.GONE);
        }
        return scoreFinal;
    }

    /**
     * This method activates after Submit answers button is clicked.
     * Displays score in Toast message and below the button.
     *
     * @param view gives view of the button
     */
    public void submitAnswers(View view) {
        if (!isNameGiven()) {
            //Display Toast
            Toast.makeText(getApplicationContext(), R.string.name_not_given_message,
                    Toast.LENGTH_LONG).show();
        } else if (isQuizComplete()) {
            //Get name inserted at the beginning
            EditText nameEditText = (EditText) findViewById(R.id.name_input);
            String insertedName = nameEditText.getText().toString();
            //Summarize every answer, display text below
            String quizSummary = createQuizSummary(insertedName, countScore());
            displayQuizMessage(quizSummary);
            //Display Toast
            Toast.makeText(getApplicationContext(), quizSummary,
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This method creates a summary of quiz results as a String.
     *
     * @param yourName uses the name inserted by user
     * @param score    add information about the score to the summary text
     * @return summary text message
     */
    private String createQuizSummary(String yourName, int score) {
        String quizSummaryMessage = getString(R.string.quiz_summary_name, yourName);
        quizSummaryMessage += getString(R.string.quiz_summary_score, score);
        return quizSummaryMessage;
    }

    /**
     * Displays given message below Submit button - TextView for score.
     *
     * @param message - information to be displayed
     */
    public void displayQuizMessage(String message) {
        TextView summaryText = (TextView) findViewById(R.id.summary_text_view);
        summaryText.setVisibility(View.VISIBLE);
        summaryText.setText(message);
    }

    /**
     * Displays given message below Submit button - TextView for incorrect questions.
     *
     * @param message - information to be displayed
     */
    public void displayIncorrectMessage(String message) {
        TextView summaryText = (TextView) findViewById(R.id.incorrect_text_view);
        summaryText.setVisibility(View.VISIBLE);
        summaryText.setText(message);
    }
}
