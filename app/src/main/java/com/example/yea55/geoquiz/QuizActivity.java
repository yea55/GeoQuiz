package com.example.yea55.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mBackButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question0, true),
            new Question(R.string.question1, false),
            new Question(R.string.question2, false),
            new Question(R.string.question3, true),
            new Question(R.string.question4, true),
            //new Question(R.string.question5, true),
            //new Question(R.string.question6, false),
    };
    private int mCurrentIndex = 0;
    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean pressedTrue){
        boolean isTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if (pressedTrue == isTrue){
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
        if (pressedTrue == isTrue){
            mCurrentIndex = (mCurrentIndex+1) %mQuestionBank.length;
            updateQuestion();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        //int question = mQuestionBank[mCurrentIndex].getTextResId();
        //mQuestionTextView.setText(question);

        mTrueButton=(Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(QuizActivity.this,
                //        R.string.correct_toast,
                //        Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });
        mFalseButton=(Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                //Toast.makeText(QuizActivity.this,
                                                //        R.string.incorrect_toast,
                                                //        Toast.LENGTH_SHORT).show();
checkAnswer(false);
                                            }               });
        mBackButton= (Button) findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(QuizActivity.this, R.string.nyi_toast, Toast.LENGTH_SHORT)
                .show();
            }
        });
                mNextButton= (Button) findViewById(R.id.next_button);
                mNextButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        mCurrentIndex = (mCurrentIndex+1) %mQuestionBank.length;
                        //int question = mQuestionBank[mCurrentIndex].getTextResId();
                        //mQuestionTextView.setText(question);
                        updateQuestion();

                    }
                });
        updateQuestion();


    }

}
