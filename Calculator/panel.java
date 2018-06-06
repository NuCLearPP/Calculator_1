import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;


public class panel extends JPanel {

    private JButton numbers[] = new JButton[10];
    private JButton dot = new JButton(".");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton div = new JButton("/");
    private JButton mul = new JButton("*");
    private JButton equal = new JButton("=");
    private JButton clean = new JButton("<-");
    private JTextField field = new JTextField();

    boolean flag1 = false;
    boolean flag2 = false;

    public panel(){
        setLayout(null);
        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 240, 50, 50);
        add(numbers[0]);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                numbers[i*3+j+1] = new JButton(String.valueOf((i*3+j+1)));
                numbers[i*3+j+1].setBounds(i*(50+10)+10, j*(50+10)+60,50,50 );
                add(numbers[i*3+j+1]);
            }
        }

        dot.setBounds(130, 240, 50,50);
        add(dot);
        plus.setBounds(190, 60, 50,50);
        add(plus);
        minus.setBounds(190,120, 50,50 );
        add(minus);
        div.setBounds(190, 180, 50,50);
        add(div);
        mul.setBounds(190, 240, 50,50);
        add(mul);
        field.setBounds(10, 10, 170, 40);
        field.setEditable(false);
        add(field);
        equal.setBounds(10, 240, 50 ,50 );
        add(equal);
        clean.setBounds(190, 10, 50,40 );
        add(clean);
        listener();


    }
    public void listener() {

        ActionListener l = (ActionEvent event) -> {

            JButton b = (JButton) event.getSource();

            //field.setText(field.getText() + Double.parseDouble(b.getText()));
            if (!flag1) {
                field.setText(field.getText() + b.getText());
                flag2 = true;
            } else
                field.setText(field.getText() + b.getText());

        };

        for (JButton b : numbers) {

            b.addActionListener(l);


        }
        dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag2) {
                    field.setText(field.getText() + dot.getText());
                    flag2 = false;
                }
            }
        });

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (flag2) {
                    field.setText(field.getText() + plus.getText());
                    flag2 = false;
                }
            }


        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag2) {
                    field.setText(field.getText() + minus.getText());
                    flag2 = false;
                }
            }
        });
        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag2) {
                    field.setText(field.getText() + div.getText());
                    flag2 = false;
                }
            }
        });
        mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag2) {
                    field.setText(field.getText() + mul.getText());
                    flag2 = false;
                }
            }
        });
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == clean) {
                    field.setText(null);
                }
            }
        });
        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ExpressionParser parser = new SpelExpressionParser();
                Expression expression = parser.parseExpression(field.getText());
                double result = (double) expression.getValue();
                field.setText(null);
                field.setText(String.valueOf(result));

            }

        });

    }

}
