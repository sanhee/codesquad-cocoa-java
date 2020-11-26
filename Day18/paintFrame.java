package com.example.Day18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class paintFrame extends JFrame {
    int x = 0;
    int y = 0;

    static final Dimension res = Toolkit.getDefaultToolkit().getScreenSize(); // 해상도 불러오는 함수

    public void init(){
        setTitle("그림판");
        setSize(res.width/2,900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null); //m 정중앙으로 옮겨주는 메소드
        setLayout(new BorderLayout());

        makeMenu();
        makeButton();
        makeSketchFrame();

        addEvent();

    }

    @Override
    public void paint(Graphics g) {
        g.drawString("●", x, y);

    }

    private void makeMenu() {

        MenuBar menuBar = new MenuBar();

        Menu mFile = new Menu("파일(F)");
        MenuItem mSave = new MenuItem("그림저장(S)");
        MenuItem mLoad= new MenuItem("불러오기(L)");

        mFile.add(mSave);
        mFile.add(mLoad);

        menuBar.add(mFile);

        setMenuBar(menuBar);

    }
    private void makeButton() {

        Panel p = new Panel();
        p.setLayout(new GridLayout(1,7));


        Button btDrawPencil= new Button("연필");
        Button btDrawRect= new Button("사각형");
        Button btDrawEllipse = new Button("원");
        Button btDrawLine = new Button("직선");
        Button btDrawCurve = new Button("곡선");

        Button btErase = new Button("지우개");
        Button btSelColor = new Button("색상변경");

        btDrawRect.setPreferredSize(new Dimension(70,70));

        p.add(btDrawPencil);
        p.add(btDrawRect);
        p.add(btDrawEllipse);
        p.add(btDrawLine);
        p.add(btDrawCurve);
        p.add(btErase);
        p.add(btSelColor);


        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(1,3));

        Label answerLabel = new Label("정답");
        answerLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        answerLabel.setAlignment(Label.CENTER);
        TextField answerFiled = new TextField();
        answerFiled.setFont(new Font("Serif", Font.PLAIN, 50));

        Button btAnswerSend = new Button("확인");
        btAnswerSend.setPreferredSize(new Dimension(60,60));



        p2.add(answerLabel);
        p2.add(answerFiled);
        p2.add(btAnswerSend);


        add(p,"North");
        add(p2,"South");


    }


    private void makeSketchFrame(){


    }

    private void addEvent() {

       addMouseMotionListener(new MouseMotionAdapter() {
           @Override
           public void mouseDragged(MouseEvent e) {
               x = e.getX();
               y = e.getY();
               repaint();
           }
       });

    }


    public paintFrame(){
        init();
        addEvent();

    }

}