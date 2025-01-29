package com.example.calculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

package com.example.calculator;

import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initTextViews();
    }
    TextView workingsTV;
    TextView resultsTV;

    String workings="";
    String formula="";
    String tempFormula="";

    private void initTextViews() {
        workingsTV = (TextView)findViewById(R.id.workingsTextView);
        resultsTV = (TextView)findViewById(R.id.resultTextView);
    }

    private void setWorkings(String givenValue) {
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void equalsOnClick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkForPowerOf();
        try {
            result = (double) engine.eval(formula);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if (result != null) {
            resultsTV.setText(String.valueOf(result.doubleValue()));
        }
    }


    private void changeFormula(int index){
        String numberLeft ="";
        String numberRight ="";

        for (int i = index + 1; i < workings.length(); i++){
            if (isNumeric(workings.charAt(i))) {
                numberRight = numberRight + workings.charAt(i);
            }
            else {
                break;
            }
        }
        for (int i = index - 1; i>= 0;i--) {
            if (isNumeric(workings.charAt(i))) {
                numberLeft = workings.charAt(i) + numberLeft;
            }
            else {
                break;
            }
        }
        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original, changed);
    }

    private boolean isNumeric(char c) {
        if ((c <= '9' && c >= '0') || c == ',') {
            return true;
        }
        return false;
    }

    private void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for (int i = 0; i < workings.length(); i++) {
            if (workings.charAt(i) == '^') {
                indexOfPowers.add(i);
            }
        }
        formula = workings;
        tempFormula = workings;
        for (int i = 0; i < indexOfPowers.size(); i++) {
            changeFormula(indexOfPowers.get(i));
        }
        formula = tempFormula;
    }

    public void clearOnClick(View view) {
        workingsTV.setText("");
        workings ="";
        resultsTV.setText("");
        leftBracket = true;
    }

    boolean leftBracket = true;

    public void bracketsOnClick(View view) {
        if (leftBracket == true) {
            setWorkings("(");
            leftBracket = false;
        }
        else {
            setWorkings(")");
            leftBracket  = true;
        }
    }
    public void  powerOfOnClick(View view){
        setWorkings("^");
    }

    public void  divisionOnClick(View view){
        setWorkings("/");
    }
    public void  mulOnClick(View view){
        setWorkings("*");
    }
    public void  addOnClick(View view){
        setWorkings("+");
    }
    public void  subOnClick(View view){
        setWorkings("-");
    }
    public void  oneOnClick(View view){
        setWorkings("1");
    }
    public void  twoOnClick(View view){
        setWorkings("2");
    }
    public void  threeOnClick(View view){
        setWorkings("3");
    }
    public void  fourOnClick(View view){
        setWorkings("4");
    }
    public void  fiveOnClick(View view){
        setWorkings("5");
    }
    public void  sixOnClick(View view){
        setWorkings("6");
    }
    public void  sevenOnClick(View view){
        setWorkings("7");
    }
    public void  eightOnClick(View view){
        setWorkings("8");
    }
    public void  nineOnClick(View view){
        setWorkings("9");
    }
}

