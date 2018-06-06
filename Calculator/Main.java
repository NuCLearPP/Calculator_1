import javax.swing.*;

public class Main {

    private  JFrame window;
    public Main(){
        window = new JFrame("Calculator");
        window.setSize(270,340);
        window.add(new panel());
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}