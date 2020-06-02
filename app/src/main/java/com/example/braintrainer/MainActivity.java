package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button go,playAgain;
Button b0,b1,b2,b3;
TextView txtques;
TextView ans;
TextView txtscore;
TextView time;
int a,b,noOfQues=0;
int incorrectAns;
int score=0;
int locationofcorrectAns;
ArrayList<Integer> answer;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go=(Button)findViewById(R.id.btngo);
        txtques=(TextView)findViewById(R.id.txtques);
        b0=(Button)findViewById(R.id.btn0);
        b1=(Button)findViewById(R.id.btn1);
        b2=(Button)findViewById(R.id.btn2);
        b3=(Button)findViewById(R.id.btn3);
        ans=(TextView)findViewById(R.id.txtans);
        txtscore=(TextView)findViewById(R.id.txtscore);
        time=(TextView)findViewById(R.id.txtcount);
        playAgain=(Button)findViewById(R.id.btnpalyagain);

  playAgain.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view)
      {
           score=0;
           noOfQues=0;
          txtques.setVisibility(View.VISIBLE);
          b0.setVisibility(View.VISIBLE);
          b1.setVisibility(View.VISIBLE);
          b2.setVisibility(View.VISIBLE);
          b3.setVisibility(View.VISIBLE);

          txtscore.setText("0/0");
         playAgain.setVisibility(View.INVISIBLE);
        updateQuestion();

          new CountDownTimer(31000, 1000) {
              @Override
              public void onTick(long l)
              {
                  time.setText(String.valueOf(l/1000));
              }

              @Override
              public void onFinish()
              {
                  playAgain.setVisibility(View.VISIBLE);
                  ans.setText("Done!");
                  txtques.setVisibility(View.INVISIBLE);
                  b0.setVisibility(View.INVISIBLE);
                  b1.setVisibility(View.INVISIBLE);
                  b2.setVisibility(View.INVISIBLE);
                  b3.setVisibility(View.INVISIBLE);

              }
          }.start();

      }
  });

          b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
            if(locationofcorrectAns==0)
            {
              ans.setText("Correct!");
              score++;

            }
            else
            {
                ans.setText("Wrong!");
            }
              noOfQues++;
              txtscore.setText(String.valueOf(score)+"/"+String.valueOf(noOfQues));
              updateQuestion();
            }
        });

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(locationofcorrectAns==1)
            {
                ans.setText("Correct!");
                score++;

            }
            else
            {
                ans.setText("Wrong!");
            }
            noOfQues++;
            txtscore.setText(String.valueOf(score)+"/"+String.valueOf(noOfQues));
            updateQuestion();

        }
    });
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(locationofcorrectAns==2)
            {
                score++;
                ans.setText("Correct!");

            }
            else
            {

                ans.setText("Wrong!");
            }
            noOfQues++;
            txtscore.setText(String.valueOf(score)+"/"+String.valueOf(noOfQues));
            updateQuestion();

        }
    });
     b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(locationofcorrectAns==3)
            {
                ans.setText("Correct!");
                score++;

            }
            else
            {
                ans.setText("Wrong!");
            }
            noOfQues++;
            txtscore.setText(String.valueOf(score)+"/"+String.valueOf(noOfQues));
            updateQuestion();

        }
    });

    go.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
            go.setVisibility(View.INVISIBLE);

                txtques.setVisibility(View.VISIBLE);
                b0.setVisibility(View.VISIBLE);
                b1.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
                b3.setVisibility(View.VISIBLE);
                ans.setVisibility(View.VISIBLE);
                txtscore.setVisibility(View.VISIBLE);
                time.setVisibility(View.VISIBLE);
                start();
            }
        });

    }
   public void start()
   {

       updateQuestion();
       new CountDownTimer(31000, 1000) {
           @Override
           public void onTick(long l)
           {
               time.setText(String.valueOf(l/1000));
           }

           @Override
           public void onFinish()
           {
               playAgain.setVisibility(View.VISIBLE);
               ans.setText("Done!");
               txtques.setVisibility(View.INVISIBLE);
               b0.setVisibility(View.INVISIBLE);
               b1.setVisibility(View.INVISIBLE);
               b2.setVisibility(View.INVISIBLE);
               b3.setVisibility(View.INVISIBLE);
           }
       }.start();
   }
public void updateQuestion()
{

    answer=new ArrayList<>();
    Random r=new Random();
    a=r.nextInt(21);
    b=r.nextInt(21);
    txtques.setText(a+"+"+b);
    locationofcorrectAns=r.nextInt(4);
    for(int i=0;i<4;i++)
    {
        if(i==locationofcorrectAns)
        {
            answer.add(a+b);
        }
        else
        {

            incorrectAns=r.nextInt(41);
            while(incorrectAns==(a+b))
            {
                incorrectAns=r.nextInt(41);

            }
            answer.add(incorrectAns);
        }

    }
    b0.setText(String.valueOf(answer.get(0)));
    b1.setText(String.valueOf(answer.get(1)));
    b2.setText(String.valueOf(answer.get(2)));
    b3.setText(String.valueOf(answer.get(3)));


}


}
