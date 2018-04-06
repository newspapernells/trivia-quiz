package com.example.android.triviaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int currentCorrectAnswer;
    int currentQuestion;
    int playerCorrectScore;
    RadioButton radioButtonA;
    RadioButton radioButtonB;
    RadioButton radioButtonC;
    RadioButton radioButtonD;
    Button buttonSubmit;
    Button buttonNext;
    Button buttonReset;
    RadioGroup answersRadioGroup;
    TextView playerGuessView;
    TextView currentQuestionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentCorrectAnswer = 0;
        currentQuestion = 0;
        playerCorrectScore = 0;
        radioButtonA = findViewById(R.id.radio_button_a);
        radioButtonB = findViewById(R.id.radio_button_b);
        radioButtonC = findViewById(R.id.radio_button_c);
        radioButtonD = findViewById(R.id.radio_button_d);
        buttonSubmit = findViewById(R.id.button_submit);
        buttonNext = findViewById(R.id.button_next);
        buttonReset = findViewById(R.id.button_reset);
        answersRadioGroup = findViewById(R.id.answers_radio_group);
        playerGuessView = findViewById(R.id.response_text);
        currentQuestionId = findViewById(R.id.question_text);
    }

    public void checkAnswer(View view) {
        int playerGuess = 0;

        // find out if the player selected a radio button
        if (answersRadioGroup.getCheckedRadioButtonId() == -1) {
            // no radio buttons are checked
            Toast toastEmpty = Toast.makeText(this, R.string.empty, Toast.LENGTH_LONG);
            toastEmpty.show();
        } else {

            // hide 'submit' button and display 'next' button
            buttonSubmit.setVisibility(View.GONE);
            buttonNext.setVisibility(View.VISIBLE);

            // find out which radio button the player selected
            RadioButton answerRadioButton = findViewById(answersRadioGroup.getCheckedRadioButtonId());

            // assign numeric value to player's guess for grading
            if (answerRadioButton == radioButtonA) {
                playerGuess = 1;
            } else if (answerRadioButton == radioButtonB) {
                playerGuess = 2;
            } else if (answerRadioButton == radioButtonC) {
                playerGuess = 3;
            } else if (answerRadioButton == radioButtonD) {
                playerGuess = 4;
            }

            // prepare the toasts
            Toast toastCorrect = Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT);
            Toast toastIncorrect = Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT);

            // award point for correct answer, toast outcome
            if (playerGuess == currentCorrectAnswer) {
                playerCorrectScore = playerCorrectScore + 1;
                toastCorrect.show();
            } else {
                toastIncorrect.show();
            }

            displayScore(playerCorrectScore);

            // disable the radio group until the next question
            for (int i = 0; i < answersRadioGroup.getChildCount(); i++) {
                answersRadioGroup.getChildAt(i).setEnabled(false);
            }
        }
    }

    public void nextQuestion(View view) {
        // displays the next question in the quiz

        answersRadioGroup.clearCheck();
        enableRadioGroup();
        wipeScore();

        // hide 'next' button and display 'submit' button
        buttonSubmit.setVisibility(View.VISIBLE);
        buttonNext.setVisibility(View.GONE);

        // this is all horrible! horribly inefficient - fix once i figure out how
        if (currentQuestion == 0) {
            currentQuestionId.setText(R.string.question_1_question_text);
            currentCorrectAnswer = 2;
            radioButtonA.setText(getString(R.string.question_1_answer_a_text));
            radioButtonB.setText(getString(R.string.question_1_answer_b_text));
            radioButtonC.setText(getString(R.string.question_1_answer_c_text));
            radioButtonD.setText(getString(R.string.question_1_answer_d_text));

        } else if (currentQuestion == 1) {
            currentQuestionId.setText(R.string.question_2_question_text);
            currentCorrectAnswer = 4;
            radioButtonA.setText(getString(R.string.question_2_answer_a_text));
            radioButtonB.setText(getString(R.string.question_2_answer_b_text));
            radioButtonC.setText(getString(R.string.question_2_answer_c_text));
            radioButtonD.setText(getString(R.string.question_2_answer_d_text));

        } else if (currentQuestion == 2) {
            currentQuestionId.setText(R.string.question_3_question_text);
            currentCorrectAnswer = 4;
            radioButtonA.setText(getString(R.string.question_3_answer_a_text));
            radioButtonB.setText(getString(R.string.question_3_answer_b_text));
            radioButtonC.setText(getString(R.string.question_3_answer_c_text));
            radioButtonD.setText(getString(R.string.question_3_answer_d_text));

        } else if (currentQuestion == 3) {
            currentQuestionId.setText(R.string.question_4_question_text);
            currentCorrectAnswer = 3;
            radioButtonA.setText(getString(R.string.question_4_answer_a_text));
            radioButtonB.setText(getString(R.string.question_4_answer_b_text));
            radioButtonC.setText(getString(R.string.question_4_answer_c_text));
            radioButtonD.setText(getString(R.string.question_4_answer_d_text));

        } else if (currentQuestion == 4) {
            currentQuestionId.setText(R.string.question_5_question_text);
            currentCorrectAnswer = 1;
            radioButtonA.setText(getString(R.string.question_5_answer_a_text));
            radioButtonB.setText(getString(R.string.question_5_answer_b_text));
            radioButtonC.setText(getString(R.string.question_5_answer_c_text));
            radioButtonD.setText(getString(R.string.question_5_answer_d_text));

        } else if (currentQuestion == 5) {
            currentQuestionId.setText(R.string.question_6_question_text);
            currentCorrectAnswer = 2;
            radioButtonA.setText(getString(R.string.question_6_answer_a_text));
            radioButtonB.setText(getString(R.string.question_6_answer_b_text));
            radioButtonC.setText(getString(R.string.question_6_answer_c_text));
            radioButtonD.setText(getString(R.string.question_6_answer_d_text));

        } else if (currentQuestion == 6) {
            currentQuestionId.setText(R.string.question_7_question_text);
            currentCorrectAnswer = 3;
            radioButtonA.setText(getString(R.string.question_7_answer_a_text));
            radioButtonB.setText(getString(R.string.question_7_answer_b_text));
            radioButtonC.setText(getString(R.string.question_7_answer_c_text));
            radioButtonD.setText(getString(R.string.question_7_answer_d_text));

        } else if (currentQuestion == 7) {
            currentQuestionId.setText(R.string.question_8_question_text);
            currentCorrectAnswer = 1;
            radioButtonA.setText(getString(R.string.question_8_answer_a_text));
            radioButtonB.setText(getString(R.string.question_8_answer_b_text));
            radioButtonC.setText(getString(R.string.question_8_answer_c_text));
            radioButtonD.setText(getString(R.string.question_8_answer_d_text));

        } else if (currentQuestion == 8) {
            currentQuestionId.setText(R.string.question_9_question_text);
            currentCorrectAnswer = 4;
            radioButtonA.setText(getString(R.string.question_9_answer_a_text));
            radioButtonB.setText(getString(R.string.question_9_answer_b_text));
            radioButtonC.setText(getString(R.string.question_9_answer_c_text));
            radioButtonD.setText(getString(R.string.question_9_answer_d_text));

        } else if (currentQuestion == 9) {
            currentQuestionId.setText(R.string.question_10_question_text);
            currentCorrectAnswer = 3;
            radioButtonA.setText(getString(R.string.question_10_answer_a_text));
            radioButtonB.setText(getString(R.string.question_10_answer_b_text));
            radioButtonC.setText(getString(R.string.question_10_answer_c_text));
            radioButtonD.setText(getString(R.string.question_10_answer_d_text));

        } else if (currentQuestion == 10) {
            finishQuiz();
        }
        currentQuestion = currentQuestion + 1;
    }

    public void displayScore(int number) {
        // displays the selected number on the screen
        playerGuessView.setText(getString(R.string.current_score_text, playerCorrectScore));
    }

    public void wipeScore() {
        // clears the score from the screen
        playerGuessView.setText("");
    }

    public void enableRadioGroup() {
        // enable the radio group
        for (int i = 0; i < answersRadioGroup.getChildCount(); i++) {
            answersRadioGroup.getChildAt(i).setEnabled(true);
        }
    }

    public void finishQuiz() {
        // wipe question text
        currentQuestionId.setText("");

        // hide radio group
        answersRadioGroup.setVisibility(View.GONE);

        // hide 'next' button, display 'start' button
        buttonSubmit.setVisibility(View.GONE);
        buttonNext.setVisibility(View.GONE);
        buttonReset.setVisibility(View.VISIBLE);
        buttonReset.setText(R.string.start_over);

        // display final score
        playerGuessView.setText(getString(R.string.final_score_text, playerCorrectScore));

        // prepare judgement toasts
        Toast toastGood = Toast.makeText(this, R.string.good, Toast.LENGTH_LONG);
        Toast toastAverage = Toast.makeText(this, R.string.average, Toast.LENGTH_LONG);
        Toast toastPoor = Toast.makeText(this, R.string.poor, Toast.LENGTH_LONG);

        if (playerCorrectScore >= 7) {
            toastGood.show();
        } else if (playerCorrectScore >= 4) {
            toastAverage.show();
        } else {
            toastPoor.show();
        }
    }

    public void startQuiz(View view) {
        // display, enable and clear radio group
        enableRadioGroup();
        answersRadioGroup.setVisibility(View.VISIBLE);
        answersRadioGroup.clearCheck();

        wipeScore();

        // display only the 'submit' button
        buttonSubmit.setVisibility(View.VISIBLE);
        buttonNext.setVisibility(View.GONE);
        buttonReset.setVisibility(View.GONE);

        // set variables to initial states
        currentCorrectAnswer = 2;
        currentQuestion = 1;
        playerCorrectScore = 0;

        // show first question
        currentQuestionId.setText(R.string.question_1_question_text);
        radioButtonA.setText(R.string.question_1_answer_a_text);
        radioButtonB.setText(R.string.question_1_answer_b_text);
        radioButtonC.setText(R.string.question_1_answer_c_text);
        radioButtonD.setText(R.string.question_1_answer_d_text);
    }
}
