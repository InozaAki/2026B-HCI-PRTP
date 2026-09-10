package com.blank.template;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    public TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        setButtons();
    }

    public void setButtons(){
        ButtonInfo.buttonData.forEach(
                (id, value) -> findViewById(id).setOnClickListener(v -> handleButtonClick(value))
        );
    }

    public void calculate(String input){
        try {
            Expression e = new ExpressionBuilder(input).build();
            BigDecimal result = new BigDecimal(e.evaluate());
            display.setText(result.stripTrailingZeros().toPlainString());
        }
        catch (ArithmeticException | IllegalArgumentException ex) {
            display.setText("Syntax Error");
            return;
        }
    }

    public void handleButtonClick(String value){
        switch (value) {
            case "=":
                calculate(display.getText().toString());
                break;
            case "AC":
                display.setText("");
                break;
            case "DEL":
                deleteLastCharacter();
                break;
            case "()":
                addParentheses();
                break;
            default:
                display.append(value);
                break;
        }
    }

    public void addParentheses() {
        String currentText = display.getText().toString();
        int openCount = currentText.length() - currentText.replace("(", "").length();
        int closeCount = currentText.length() - currentText.replace(")", "").length();

        if (openCount == closeCount || currentText.endsWith("(")) {
            display.append("(");
        } else if (openCount > closeCount && !currentText.endsWith("(")) {
            display.append(")");
        }
    }

    public void deleteLastCharacter() {
        String currentText = display.getText().toString();
        if (!currentText.isEmpty()) {
            display.setText(currentText.replaceAll(".$", ""));
        }
    }
}