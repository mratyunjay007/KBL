package shop.akapp.com.kbl;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     TextView tvScore,tvQuestion,tvOpt1,tvOpt2,tvOpt3,tvOpt4,tvFScore,expertAnswer;
     TextView AudPoll1,AudPoll2,AudPoll3,AudPoll4;
    private Button btnLifeline,btnQuit;
    private CardView cvLife1,cvLife2;
    private ImageView ivExpert,ivPlayagain,ivStart,ivCross1,ivCross2,ivCross3;
    private View mainscreen,lifeline,gameOver,wrongAnswer,correctAnswer,exLayout,audiencePoll,startLayout;
    int j,index;
    int score,count=0;
    int life=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainscreen=findViewById(R.id.mainScreen);
        lifeline=findViewById(R.id.lifeline);
        gameOver=findViewById(R.id.gameover);
        tvScore =findViewById(R.id.tvScore);
        tvQuestion=findViewById(R.id.tvQuestion);
        tvOpt1=findViewById(R.id.tvOpt1);
        tvOpt2=findViewById(R.id.tvOpt2);
        tvOpt3=findViewById(R.id.tvOpt3);
        tvOpt4=findViewById(R.id.tvOpt4);
        cvLife1=findViewById(R.id.cvlife1);
        cvLife2=findViewById(R.id.cvLife2);
        ivExpert=findViewById(R.id.ivExpert);
        tvFScore=findViewById(R.id.tvFScore);
        btnLifeline=findViewById(R.id.btnLifeline);
        btnQuit=findViewById(R.id.btnQuit);
        ivPlayagain=findViewById(R.id.ivPlayagain);
        wrongAnswer=findViewById(R.id.wrongAnswer);
        correctAnswer=findViewById(R.id.correctAnswer);
        exLayout=findViewById(R.id.exLayout);
        expertAnswer=findViewById(R.id.expertAnswer);
        audiencePoll=findViewById(R.id.audiencePoll);
        AudPoll1=findViewById(R.id.tvAudPoll1);
        AudPoll2=findViewById(R.id.tvAudPoll2);
        AudPoll3=findViewById(R.id.tvAudPoll3);
        AudPoll4=findViewById(R.id.tvAudPoll4);
        ivStart=findViewById(R.id.ivStart);
        startLayout=findViewById(R.id.startLayout);
        ivCross1=findViewById(R.id.ivCross1);
        ivCross2=findViewById(R.id.ivCross2);
        ivCross3=findViewById(R.id.ivCross3);

        btnLifeline.setOnClickListener(this);
        gameOver.setOnClickListener(this);
        cvLife2.setOnClickListener(this);
        cvLife1.setOnClickListener(this);
        ivExpert.setOnClickListener(this);
        ivPlayagain.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        exLayout.setOnClickListener(this);
        correctAnswer.setOnClickListener(this);
        audiencePoll.setOnClickListener(this);

        ivStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startLayout.setVisibility(View.GONE);
                    mainscreen.setVisibility(View.VISIBLE);

            }
        });

        score=0;
        j=-1;
        index=0;
        SetQuestion();
        wrongAnswer.setVisibility(View.GONE);

    }

    public void OnSelect(View V)
    {


        switch(V.getId())
        {
            case R.id.tvOpt1:
                if(tvOpt1.getText().toString().equals(ApplicationClass.list.get(j).getResult()))
                                {
                                  CorrectAnswer();
                                }else{
                                        GameOver();
                                        wrongAnswer.setVisibility(View.VISIBLE);
                                    }
                                break;
            case R.id.tvOpt2:
                if(tvOpt2.getText().toString().equals(ApplicationClass.list.get(j).getResult()))
            {
                CorrectAnswer();
            }else{

                    wrongAnswer.setVisibility(View.VISIBLE);
                   GameOver();

            }
            break;

            case R.id.tvOpt3:
                if(tvOpt3.getText().toString().equals(ApplicationClass.list.get(j).getResult()))
            {
              CorrectAnswer();
            }else{
                    wrongAnswer.setVisibility(View.VISIBLE);
                   GameOver();    }
                break;

            case R.id.tvOpt4:
                if(tvOpt4.getText().toString().equals(ApplicationClass.list.get(j).getResult()))
            {
               CorrectAnswer();
            }else{
                    wrongAnswer.setVisibility(View.VISIBLE);
                   GameOver();
                }
                break;
        }



    }



    @Override
    public void onClick(View v) {
        switch(v.getId())
        {

            case R.id.correctAnswer: correctAnswer.setVisibility(View.GONE);
                                     mainscreen.setVisibility(View.VISIBLE);
                                     break;
            case R.id.btnLifeline:
                                    if(count!=3) {
                                        Toast.makeText(this, "Each Life Line can be used Once!", Toast.LENGTH_SHORT).show();
                                        mainscreen.setVisibility(View.GONE);
                                        lifeline.setVisibility(View.VISIBLE);
                                    }else if(count==3){
                                        Toast.makeText(this, "You don't have any lifeline now!", Toast.LENGTH_LONG).show();
                                    }
                                    break;
            case R.id.btnQuit:
                            AlertDialog.Builder alert=new AlertDialog.Builder(this);
                            alert.setTitle("Warning");
                            alert.setMessage("Are You Sure ! Do You want to quit?");
                            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    gameOver.setVisibility(View.VISIBLE);
                                    mainscreen.setVisibility(View.GONE);
                                    tvFScore.setText("SCORE : " +score);
                                }
                            });
                            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            alert.show();


                                break;
            case R.id.cvlife1:
                                life=1;count++;
                                cvLife1.setEnabled(false);
                                ivCross1.setVisibility(View.VISIBLE);

                                lifeline.setVisibility(View.GONE);
                                mainscreen.setVisibility(View.VISIBLE);
                                if(tvOpt1.getText().toString().equals(ApplicationClass.list.get(j).getResult()))
                                {
                                    tvOpt2.setVisibility(View.GONE);
                                    tvOpt3.setVisibility(View.GONE);
                                }
                                else if(tvOpt2.getText().toString().equals(ApplicationClass.list.get(j).getResult()))
                                {
                                    tvOpt1.setVisibility(View.GONE);
                                    tvOpt3.setVisibility(View.GONE);
                                }
                                else if(tvOpt3.getText().toString().equals(ApplicationClass.list.get(j).getResult()))
                                {
                                    tvOpt2.setVisibility(View.GONE);
                                    tvOpt4.setVisibility(View.GONE);
                                }
                                else if(tvOpt4.getText().toString().equals(ApplicationClass.list.get(j).getResult()))
                                {
                                    tvOpt2.setVisibility(View.GONE);
                                    tvOpt3.setVisibility(View.GONE);
                                }
                                break;

            case R.id.cvLife2:
                                life=2;count++;
                                cvLife2.setEnabled(false);
                                ivCross2.setVisibility(View.VISIBLE);

                                makePoll();
                                lifeline.setVisibility(View.GONE);
                                audiencePoll.setVisibility(View.VISIBLE);

                                break;
            case R.id.audiencePoll:     audiencePoll.setVisibility(View.GONE);
                                        mainscreen.setVisibility(View.VISIBLE);
                                        break;
            case R.id.ivExpert:
                                life=3;count++;
                                ivExpert.setEnabled(false);
                                ivCross3.setVisibility(View.VISIBLE);

                                lifeline.setVisibility(View.GONE);
                                exLayout.setVisibility(View.VISIBLE);
                                expertAnswer.setText("Correct Answer is "+ApplicationClass.list.get(j).getResult());
                                break;
            case R.id.exLayout:
                                exLayout.setVisibility(View.GONE);
                                mainscreen.setVisibility(View.VISIBLE);
                                break;

            case R.id.ivPlayagain:
                                gameOver.setVisibility(View.GONE);
                                startLayout.setVisibility(View.VISIBLE);
                                wrongAnswer.setVisibility(View.GONE);
                                score=0;
                                life=0;
                                count=0;
                                j=-1;
                                SetQuestion();
                                tvScore.setText("SCORE");

                                ivCross3.setVisibility(View.GONE);
                                ivCross2.setVisibility(View.GONE);
                                ivCross1.setVisibility(View.GONE);
                                cvLife1.setEnabled(true);
                                cvLife2.setEnabled(true);
                                ivExpert.setEnabled(true);
                                    break;
        }
    }


    public void SetQuestion()
    {
        if(j<4)
        {
        j++;}
        else{
            mainscreen.setVisibility(View.GONE);
            gameOver.setVisibility(View.VISIBLE);
            tvFScore.setText("SCORE :" +score);
        }
        tvQuestion.setText(ApplicationClass.list.get(j).getQuestion());
        tvOpt1.setText(ApplicationClass.list.get(j).getOption1());
        tvOpt2.setText(ApplicationClass.list.get(j).getOption2());
        tvOpt3.setText(ApplicationClass.list.get(j).getOption3());
        tvOpt4.setText(ApplicationClass.list.get(j).getOption4());

        tvOpt1.setVisibility(View.VISIBLE);
        tvOpt2.setVisibility(View.VISIBLE);
        tvOpt3.setVisibility(View.VISIBLE);
        tvOpt4.setVisibility(View.VISIBLE);

    }
    public void CorrectAnswer()
    {
        correctAnswer.setVisibility(View.VISIBLE);
        if(life!=0)
        {
            if(life==1)
            {
                score+=10000;
            }else if(life==2)
            {
                score+=15000;
            }else{
                score+=5000;
            }
        }else{
            score+=20000;
        }

        tvScore.setText(""+score);
        SetQuestion();
    }

    public void GameOver()
    {

        if(score>=10000)
        {
            score=10000;
        }else{
            score=0;
        }
        gameOver.setVisibility(View.VISIBLE);
        mainscreen.setVisibility(View.GONE);
        tvFScore.setText("SCORE : " +score);
    }

    private void makePoll() {
        if(ApplicationClass.list.get(j).getCorrect()==1)
        {
            AudPoll1.setText("80%");
            AudPoll2.setText("3%");
            AudPoll3.setText("8%");
            AudPoll4.setText("9%");
        }
        if(ApplicationClass.list.get(j).getCorrect()==2)
        {
            AudPoll1.setText("23%");
            AudPoll2.setText("75%");
            AudPoll3.setText("2%");
            AudPoll4.setText("0%");
        }  if(ApplicationClass.list.get(j).getCorrect()==3)
        {
            AudPoll1.setText("5%");
            AudPoll2.setText("20%");
            AudPoll3.setText("60%");
            AudPoll4.setText("15%");
        }  if(ApplicationClass.list.get(j).getCorrect()==4)
        {
            AudPoll1.setText("4%");
            AudPoll2.setText("5%");
            AudPoll3.setText("1%");
            AudPoll4.setText("90%");
        }
    }
}
