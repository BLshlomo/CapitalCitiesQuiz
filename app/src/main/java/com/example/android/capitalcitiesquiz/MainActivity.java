package com.example.android.capitalcitiesquiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quizScore = 0 ;
    int quizCorrectAnswers = 0 ;
    int quizWrongAnswer = 0 ;
    int quizNoAnswer = 0 ;
    int rbCountAustralia, rbCountMostVisited, llCountBolivia, rbCountBiggestLandSize, llCountBrazil, rbCountBerlinUnification ;
    RadioGroup rgAustralia, rgMostVisited, rgBiggestLandSize, rgBerlinUnification ;
    LinearLayout llBolivia, llBrazil ;
    EditText etBudapest, etSwitzerland, etChina ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize variables

        // Initialize radio groups
        // Declare rgAustralia as australia_rg radio group.
        rgAustralia = (RadioGroup) findViewById(R.id.australia_rg);
        // Declare rgMostVisited as most_visited_rg radio group.
        rgMostVisited = (RadioGroup) findViewById(R.id.most_visited_rg);
        // Declare llBolivia as bolivia_ll linear layout.
        llBolivia = (LinearLayout) findViewById(R.id.bolivia_ll);
        // Declare etBudapest as budapest_et edit text.
        etBudapest = (EditText) findViewById(R.id.budapest_et);
        // Declare rgBiggestLandSize as biggest_Land_size_rg radio group.
        rgBiggestLandSize = (RadioGroup) findViewById(R.id.biggest_land_size_rg);
        // Declare llBrazil as brazil_ll linear layout.
        llBrazil = (LinearLayout) findViewById(R.id.brazil_ll);
        // Declare etSwitzerland as switzerland_et edit text.
        etSwitzerland = (EditText) findViewById(R.id.switzerland_et);
        // Declare rgBerlinUnification as unification_berlin_rg radio group.
        rgBerlinUnification = (RadioGroup) findViewById(R.id.unification_berlin_rg);
        // Declare etChina as china_et edit text.
        etChina = (EditText) findViewById(R.id.china_et) ;


    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState

    //This method is called when the Submit Quiz button is clicked.
    public void submitQuiz(View view) {

        // Count the number of radio buttons in the group
        rbCountAustralia = rgAustralia.getChildCount();
        rbCountMostVisited = rgMostVisited.getChildCount();
        llCountBolivia = llBolivia.getChildCount();
        rbCountBiggestLandSize = rgBiggestLandSize.getChildCount();
        llCountBrazil = llBrazil.getChildCount();
        rbCountBerlinUnification = rgBerlinUnification.getChildCount();

        // Declare rbCanberra as canberra_cptl_australia radio button.
        RadioButton rbCanberra = (RadioButton) findViewById(R.id.canberra_cptl_australia);

        // Get checked radio button out of australia radio group.
        int selectedAustralia = rgAustralia.getCheckedRadioButtonId();

        //Declare the checked radio button as checkedAustralia variable.
        RadioButton checkedAustralia = (RadioButton) findViewById(selectedAustralia);

        // Check if the right answer is checked, if it is add 11 points to quizScore
        // and set the answer text color to green
        if (checkedAustralia == rbCanberra) {
            rbCanberra.setTextColor(Color.GREEN);
            quizScore += + 11;
            quizCorrectAnswers += + 1;
            // Check if no answer is marked in the radio group question
        } else if (selectedAustralia == -1) {
            quizWrongAnswer += 1 ;
            // Loop through the radio buttons in the group to change their colors to the red color
            for (int i=0; i < rbCountAustralia; i++) {
                RadioButton answer = (RadioButton) rgAustralia.getChildAt(i);
                answer.setTextColor(Color.RED);
            }
            // change text color of the wrong answer checked radio button to red.
        } else {
            quizNoAnswer += 1 ;
            checkedAustralia.setTextColor(Color.RED);
        }



        // Declare rbBangkok as bangkok_most_visited radio button.
        RadioButton rbBangkok = (RadioButton) findViewById(R.id.bangkok_most_visited);

        // Get checked radio button out of biggest most visited radio group.
        int selectedMostVisited = rgMostVisited.getCheckedRadioButtonId();

        //Declare the checked radio button as checkedMostVisited variable.
        RadioButton checkedMostVisited = (RadioButton) findViewById(selectedMostVisited);

        // Check if the right answer is checked, if it is add 11 points to quizScore
        // and set the answer text color to green
        if (checkedMostVisited == rbBangkok) {
            rbBangkok.setTextColor(Color.GREEN);
            quizScore += + 11;
            quizCorrectAnswers += + 1;
            // Check if no answer is marked in the radio group question
        } else if (selectedMostVisited == -1) {
            quizWrongAnswer += 1 ;
            // Loop through the radio buttons in the group to change their colors to the red color
            for (int i=0; i < rbCountMostVisited; i++) {
                RadioButton answer = (RadioButton) rgMostVisited.getChildAt(i);
                answer.setTextColor(Color.RED);
            }
            // change text color of the wrong answer checked radio button to red.
        } else {
            quizNoAnswer += 1 ;
            checkedMostVisited.setTextColor(Color.RED);
        }

        // Declare cbLaPaz as la_paz_cptl_bolivia checkbox.
        CheckBox cbLaPaz = (CheckBox) findViewById(R.id.la_paz_cptl_bolivia);

        // Declare cbSantaCruz as santa_cruz_cptl_bolivia checkbox.
        CheckBox cbSantaCruz = (CheckBox) findViewById(R.id.santa_cruz_cptl_bolivia);

        // Declare cbCochabamba as cochabamba_cptl_bolivia checkbox.
        CheckBox cbCochabamba = (CheckBox) findViewById(R.id.cochabamba_cptl_bolivia);

        // Declare cbSucre as sucre_cptl_bolivia checkbox.
        CheckBox cbSucre = (CheckBox) findViewById(R.id.sucre_cptl_bolivia);

        // Check if SantaCruz wrong answer checkbox is marked and if it does change text color to red.
        if (cbSantaCruz.isChecked()) {
            quizWrongAnswer += 1 ;
            cbSantaCruz.setTextColor(Color.RED);
            // Check if Cochabamba wrong answer checkbox is marked and if it does change text color to red
            // if SantaCruz is marked.
            if (cbCochabamba.isChecked()) {
                cbCochabamba.setTextColor(Color.RED);
            }
            // Check if Cochabamba wrong answer checkbox is marked and if it does change text color to red.
        } else if (cbCochabamba.isChecked()) {
            quizWrongAnswer += 1 ;
            cbCochabamba.setTextColor(Color.RED);

            // Check if correct answers are marked and if they do change their text color to green
            // and add the right score to quizScore int.
        } else if (cbLaPaz.isChecked()) {
            cbLaPaz.setTextColor(Color.GREEN);
            if (cbSucre.isChecked()) {
                quizScore += + 11 ;
                quizCorrectAnswers += 1 ;
                cbSucre.setTextColor(Color.GREEN);
            } else quizScore += + 6 ;
        } else if (cbSucre.isChecked()) {
            quizScore += + 6 ;
            cbSucre.setTextColor(Color.GREEN);

            // Change the entire LinearView checkboxes color to red if nothing is marked.
        } else {
            quizNoAnswer += 1 ;
            // Loop through the check boxes in the linear layout to change color to red.
            for (int i=0; i < llCountBolivia; i++) {
                CheckBox checked = (CheckBox) llBolivia.getChildAt(i);
                checked.setTextColor(Color.RED);
            }
        }

        // Declare budapestETValue as extracted String from Budapest edit text.
        String budapestETValue = etBudapest.getText().toString();

        // Declare budapestValueUpperCase as the extracted string in all caps.
        String budapestValueUpperCase = budapestETValue.toUpperCase();


        // Check if budapest edit text is empty.
        if (budapestValueUpperCase.trim().length() == 0) {
            quizNoAnswer += 1;
            etBudapest.setBackgroundColor(Color.RED);
        }
        // Check if the string contains the words "Buda " and " Pest" as the right answer
        // if it does, add 11 to quizScore
        // and set the Budapest edit text background color to green.
        else if (budapestValueUpperCase.contains("BUDA ")) {
            if (budapestValueUpperCase.contains(" PEST")) {
                quizScore += + 11 ;
                quizCorrectAnswers += 1;
                etBudapest.setBackgroundColor(Color.GREEN);
            }
            // Set the Budapest edit text background color to red if the answer is wrong.
        } else {
            quizWrongAnswer += 1 ;
            etBudapest.setBackgroundColor(Color.RED);
        }

        // Declare rbTokyo as Tokyo_land_size radio button.
        RadioButton rbTokyo = (RadioButton) findViewById(R.id.tokyo_land_size);

        // Get checked radio button out of biggest land size radio group.
        int selectedLandSize = rgBiggestLandSize.getCheckedRadioButtonId();

        //Declare the checked radio button as checkedLandSize variable.
        RadioButton checkedLandSize = (RadioButton) findViewById(selectedLandSize);

        // Check if the right answer is checked, if it is add 11 points to quizScore
        // and set the answer text color to green.
        if (checkedLandSize == rbTokyo) {
            rbTokyo.setTextColor(Color.GREEN);
            quizScore += + 11;
            quizCorrectAnswers += 1;
            // Check if no answer is marked in the radio group question.
        } else if (selectedLandSize == -1) {
            quizNoAnswer += 1;
            // Loop through the radio buttons in the group to change their colors to the red color.
            for (int i=0; i < rbCountBiggestLandSize; i++) {
                RadioButton answer = (RadioButton) rgBiggestLandSize.getChildAt(i);
                answer.setTextColor(Color.RED);
            }
          // change text color of the wrong answer checked radio button to red.
        } else {
            quizWrongAnswer += 1;
            checkedLandSize.setTextColor(Color.RED);
        }

        // Declare cbRio as rio_cptl_brazil checkbox.
        CheckBox cbRio = (CheckBox) findViewById(R.id.rio_cptl_brazil);

        // Declare cbPaulo as paulo_cptl_brazil checkbox.
        CheckBox cbPaulo = (CheckBox) findViewById(R.id.paulo_cptl_brazil);

        // Declare cbRecife as recife_cptl_brazil checkbox.
        CheckBox cbRecife = (CheckBox) findViewById(R.id.recife_cptl_brazil);

        // Declare cbBrasilia as brasilia_cptl_brazil checkbox.
        CheckBox cbBrasilia = (CheckBox) findViewById(R.id.brasilia_cptl_brazil);

        // Declare cbSalvador as salvador_cptl_brazil checkbox.
        CheckBox cbSalvador = (CheckBox) findViewById(R.id.salvador_cptl_brazil);

        // Check if paulo wrong answer checkbox is marked and if it does change text color to red.
        if (cbPaulo.isChecked()) {
            quizWrongAnswer += 1;
            cbPaulo.setTextColor(Color.RED);
            // Check if recife wrong answer checkbox is marked and if it does change text color to red
            // if paulo is marked.
            if (cbRecife.isChecked()) {
                cbRecife.setTextColor(Color.RED);
            }
        }
        // Check if recife wrong answer checkbox is marked and if it does change text color to red.
        else if (cbRecife.isChecked()) {
            quizWrongAnswer += 1 ;
            cbRecife.setTextColor(Color.RED);
        }
        // Check if correct answers are marked and if they do change their text color to green
        // and add the right score to quizScore int.
        else if (cbRio.isChecked()) {
            cbRio.setTextColor(Color.GREEN);
            if (cbBrasilia.isChecked()) {
                cbBrasilia.setTextColor(Color.GREEN);
                if (cbSalvador.isChecked()) {
                    quizScore += + 11 ;
                    quizCorrectAnswers += 1 ;
                    cbSalvador.setTextColor(Color.GREEN);
                } else quizScore += + 8 ;
            } else quizScore += + 4 ;
        } else if (cbBrasilia.isChecked()) {
                   cbBrasilia.setTextColor(Color.GREEN);
                   if (cbSalvador.isChecked()) {
                       quizScore += + 8;
                       cbSalvador.setTextColor(Color.GREEN);
                   } else quizScore += + 4 ;
        } else if (cbSalvador.isChecked()) {
            quizScore += + 4 ;
            cbSalvador.setTextColor(Color.GREEN);

            // Change the entire LinearView checkboxes color to red if nothing is marked.
        } else {
            quizNoAnswer += 1 ;
            // Loop through the check boxes in the linear layout to change color to red.
            for (int i=0; i < llCountBrazil; i++) {
                CheckBox checked = (CheckBox) llBrazil.getChildAt(i);
                checked.setTextColor(Color.RED);
            }
        }

        // Declare switzerlandETValue as extracted String from Switzerland edit text.
        String switzerlandETValue = etSwitzerland.getText().toString();

        // Declare switzerlandValueUpperCase as the extracted string in all caps.
        String switzerlandValueUpperCase = switzerlandETValue.toUpperCase();

        // Check if switzerland edit text is empty.
        if (switzerlandValueUpperCase.trim().length() == 0) {
            quizNoAnswer += 1;
            etSwitzerland.setBackgroundColor(Color.RED);
        }

        // Check if the string contains the words "BERN", "CAPITAL", "DE JURE" and "DE FACTO" as the right answer
        // if it does, add 11 to quizScore
        // and set the Switzerland edit text background color to green.
        if (switzerlandValueUpperCase.contains("BERN")) {
            if (switzerlandValueUpperCase.contains("DE FACTO")) {
                if (switzerlandValueUpperCase.contains("CAPITAL")) {
                    if (switzerlandValueUpperCase.contains("DE JURE")) {
                        quizScore += +11;
                        quizCorrectAnswers += 1 ;
                        etSwitzerland.setBackgroundColor(Color.GREEN);
                    }
                }
            }
        }
        // Set the Switzerland edit text background color to red if the answer is wrong.
        else {
            quizWrongAnswer += 1 ;
            etSwitzerland.setBackgroundColor(Color.RED);
        }

        // Declare rbCorrectYear as year_3_unification_berlin radio button.
        RadioButton rbCorrectYear = (RadioButton) findViewById(R.id.year_3_unification_berlin);

        // Get checked radio button out of unification berlin radio group.
        int selectedBerlinUnification = rgBerlinUnification.getCheckedRadioButtonId();

        //Declare the checked radio button as checkedBerlinUnification variable.
        RadioButton checkedBerlinUnification = (RadioButton) findViewById(selectedBerlinUnification);

        // Check if the right answer is checked, if it is add 11 points to quizScore
        // and set the answer text color to green.
        if (checkedBerlinUnification == rbCorrectYear) {
            rbCorrectYear.setTextColor(Color.GREEN);
            quizScore += + 11;
            quizCorrectAnswers += 1 ;
            // Check if no answer is marked in the radio group question.
        } else if (selectedBerlinUnification == -1) {
            quizNoAnswer += 1 ;
            // Loop through the radio buttons in the group to change their colors to the red color.
            for (int i=0; i < rbCountBerlinUnification; i++) {
                RadioButton answer = (RadioButton) rgBerlinUnification.getChildAt(i);
                answer.setTextColor(Color.RED);
            }
            // change text color of the wrong answer checked radio button to red.
        } else {
            quizWrongAnswer += 1 ;
            checkedBerlinUnification.setTextColor(Color.RED);
        }

        // Declare chinaETValue as extracted String from China edit text.
        String chinaETValue = etChina.getText().toString();

        // Declare chinaValueUpperCase as the extracted string in all caps.
        String chinaValueUpperCase = chinaETValue.toUpperCase();

        // Check if china edit text is empty.
        if (chinaValueUpperCase.trim().length() == 0) {
            quizNoAnswer += 1;
            etChina.setBackgroundColor(Color.RED);
        }

        // Check if the string contains the words "NO" as the right answer
        // if it does, add 11 to quizScore
        // and set the China edit text background color to green.
        if (chinaValueUpperCase.contains("NO")) {
            quizScore += 11 ;
            quizCorrectAnswers += 1 ;
            etChina.setTextColor(Color.GREEN);
            // Set the China edit text background color to red if the answer is wrong.
        } else {
            quizWrongAnswer += 1 ;
            etChina.setBackgroundColor(Color.RED);
        }

        disableAll();

        String summaryPerfect = "Congratulations your score is " + quizScore ;
        summaryPerfect += " based on " + quizCorrectAnswers + " correctly answered questions." ;
        summaryPerfect += "\nPlease tap yourself on your back, great job !" ;


        String summaryMistakes = summaryPerfect ;
        summaryMistakes += "\nAlso,you had " + quizWrongAnswer + " wrong answers" ;

        String summaryNoAnswers = summaryPerfect ;
        summaryNoAnswers = "\nAlso, you haven't answered " + quizNoAnswer + " questions !." ;

        String summaryWorse = summaryMistakes ;
        summaryWorse += "\nAnd, you haven't answered " + quizNoAnswer + " questions !." ;

        if (quizNoAnswer == 0) {
            if (quizWrongAnswer == 0) {
                //display in long period of time
                Toast.makeText(this, summaryPerfect,
                        Toast.LENGTH_LONG).show();
            } else {
                //display in long period of time
                Toast.makeText(this, summaryMistakes,
                        Toast.LENGTH_LONG).show();
            }
        } else if (quizWrongAnswer == 0) {
            //display in long period of time
            Toast.makeText(this, summaryNoAnswers,
                    Toast.LENGTH_LONG).show();
        } else {
            //display in long period of time
            Toast.makeText(this, summaryWorse,
                    Toast.LENGTH_LONG).show();
        }
    }

    // Public void to disable all questions in the page
    public void disableAll() {
        disableAustralia();
        disableMostVisited();
        disableBolivia();
        disableBudapest();
        disableBiggestLandSize();
        disableBrazil();
        disableSwitzerland();
        disableBerlinUnification();
        disableChina();
    }

    // public void method to disable Australia radio group
    public void disableAustralia() {
        // Loop through the radio buttons in the group to disable the radio buttons
        for (int i=0; i < rbCountAustralia; i++) {
            RadioButton answer = (RadioButton) rgAustralia.getChildAt(i);
            answer.setEnabled(false);
        }
    }
    // public void method to disable most visited radio group
    public void disableMostVisited() {
        // Loop through the radio buttons in the group to disable most visited radio group
        for (int i=0; i < rbCountMostVisited; i++) {
            RadioButton answer = (RadioButton) rgMostVisited.getChildAt(i);
            answer.setEnabled(false);
        }
    }

        // public void method to disable bolivia linear layout checkboxes
    public void disableBolivia() {
        // Loop through the check boxes in the linear layout to disable bolivia linear layout
        for (int i=0; i < llCountBolivia; i++) {
            CheckBox checked = (CheckBox) llBolivia.getChildAt(i);
            checked.setEnabled(false);
        }
    }

    // public void method to disable budapest edit text
    public void disableBudapest() {
        etBudapest.setEnabled(false);
        etBudapest.setClickable(false);
        etBudapest.setFocusable(false);
    }

    // public void method to disable biggest land size radio group
    public void disableBiggestLandSize() {
        // Loop through the radio buttons in the group to change their colors to the red color.
        for (int i=0; i < rbCountBiggestLandSize; i++) {
            RadioButton answer = (RadioButton) rgBiggestLandSize.getChildAt(i);
            answer.setEnabled(false);
        }
    }

    // public void method to disable brazil linear layout checkboxes
    public void disableBrazil() {
        // Loop through the check boxes in the linear layout to disable brazil linear layout
        for (int i=0; i < llCountBrazil; i++) {
            CheckBox checked = (CheckBox) llBrazil.getChildAt(i);
            checked.setEnabled(false);
        }
    }

    // public void method to disable switzerland edit text
    public void disableSwitzerland() {
        etSwitzerland.setEnabled(false);
        etSwitzerland.setClickable(false);
        etSwitzerland.setFocusable(false);
    }

    // public void method to disable berlin unification radio group
    public void disableBerlinUnification() {
        for (int i=0; i < rbCountBerlinUnification; i++) {
            RadioButton answer = (RadioButton) rgBerlinUnification.getChildAt(i);
            answer.setEnabled(false);
        }
    }

    // public void method to disable china edit text
    public void disableChina() {
        etChina.setEnabled(false);
        etChina.setClickable(false);
        etChina.setFocusable(false);
    }
}
