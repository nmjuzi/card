package com.my.exe;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

import javax.swing.*;

public class panel extends WindowAdapter implements ActionListener,
		ItemListener
// 定义事件处理类，由它对按钮和框架上的窗口产生的事件进行处理
{

	Frame f; // 框架对象
	JButton btnAll;
	JButton btnOk;
	JButton btnOk2;
	JButton btnCopy;
	JButton btnCopy2;
	JButton btnCut;
	JTextField cardField;
	JTextField idcardField;
	JLabel cardLabel;
	JLabel idcardLabel;
	Label tsLabel;
	Label tsLabel1;
	Label tsLabel2;
	Label tsLabel3;
	Label tsLabel4;
	Label tsLabel5;
	Clipboard clipbd;

	public panel() // 构造窗口界面

	{
		clipbd = Toolkit.getDefaultToolkit().getSystemClipboard();
		cardField = new JTextField("");
		cardField.setFont(new Font("宋体",Font.BOLD,20));
		idcardField = new JTextField("");
		idcardField.setFont(new Font("宋体",Font.BOLD,18));
		tsLabel = new  Label("本软件只作测试使用,使用者不得用于商业用途或其他违法行为");
		tsLabel1 = new Label("");
		tsLabel2 = new Label("一切传播行为属使用者个人行为,一切后果由使用者本人自己承担");
		tsLabel3 = new Label("");
		tsLabel4 = new Label("一旦使用代表您同意以上协议");
		tsLabel5 = new Label("                  " +
				"                 " +
				"                                   author:wyw");
		f = new Frame("信用卡身份证生成器"); // 创建带标题的框架

		f.setSize(450, 300); // 设置框架大小
		f.setResizable(false);
		f.setLocationRelativeTo(null); 

		Panel p = new Panel();
		p.setLayout(null);  
		f.add(p);

		cardLabel = new JLabel("银行卡号:");
		idcardLabel = new JLabel("身份证号:");
		btnOk = new JButton("生成");
		btnOk2 = new JButton("生成");
		btnAll = new JButton("一键全部生成");
		btnCopy = new JButton("复制");
		btnCopy2 = new JButton("复制");
		btnCut = new JButton("剪切");
		cardLabel.setBounds(5, 10, 55, 40);
		cardField.setHorizontalAlignment(JTextField.LEADING);
		cardField.setBounds(65, 10, 195, 40);
		btnOk.setBounds(260, 12, 90, 35);
		btnCopy.setBounds(353, 12, 90, 35);
		
		idcardLabel.setBounds(5, 60, 55, 40);
		idcardField.setHorizontalAlignment(JTextField.LEADING);
		idcardField.setBounds(65, 60, 195, 40);
		btnOk2.setBounds(260, 62, 90, 35);
		btnCopy2.setBounds(353, 62, 90, 35);
		
		btnAll.setBounds(150, 110, 120, 35);
		
		//btnCut.setBounds(197, 80, 93, 35);
		tsLabel.setBounds(10, 150, 400, 30);
		//tsLabel1.setBounds(100, 130, 299, 30);
		tsLabel2.setBounds(10, 180, 400, 30);
		//tsLabel3.setBounds(100, 190, 299, 30);
		tsLabel4.setBounds(10, 210, 400, 30);
		tsLabel5.setBounds(150, 250, 299, 30);
		// 创建按钮对象

		
		btnOk.addActionListener(new Genrt());
		btnCopy.addActionListener(new CopyL());
		btnOk2.addActionListener(new Genrt2());
		btnCopy2.addActionListener(new CopyL2());
		btnAll.addActionListener(new GenrtAll());
		//btnCut.addActionListener(new CutL());
		
		p.add(cardLabel);
		p.add(cardField);
		p.add(btnOk); // 在框架中加入按钮
		p.add(btnCopy);
		p.add(btnCut);
		
		p.add(idcardLabel);
		p.add(idcardField);
		p.add(btnOk2); 
		p.add(btnCopy2);
		
		p.add(btnAll);
		
		p.add(tsLabel);
		//p.add(tsLabel1);
		p.add(tsLabel2);
		//p.add(tsLabel3);
		p.add(tsLabel4);
		p.add(tsLabel5);
		

		f.setVisible(true);           // 设置框架为可见
		f.addWindowListener(this);    // 注册监听框架上的窗口事件

	}
	class GenrtAll implements ActionListener {           //生成按钮处理事件
	    public void actionPerformed(ActionEvent e) {
	    	//RandomCreditCardNumberGenerator a = new RandomCreditCardNumberGenerator();
			String s = RandomCreditCardNumberGenerator.get_Bank_account();
			String ss = RandomIdCardNumberGenerator.generate();
			cardField.setText(s); 
			idcardField.setText(ss); 
	    }
	  }
	class Genrt implements ActionListener {           //生成按钮处理事件
	    public void actionPerformed(ActionEvent e) {
	    	//RandomCreditCardNumberGenerator a = new RandomCreditCardNumberGenerator();
			String s = RandomCreditCardNumberGenerator.get_Bank_account();
			System.out.println(s);
			cardField.setText(s); 
	    }
	  }
	class Genrt2 implements ActionListener {           //生成按钮处理事件
	    public void actionPerformed(ActionEvent e) {
			String s = RandomIdCardNumberGenerator.generate();
			System.out.println(s);
			idcardField.setText(s); 
	    }
	  }
	class CopyL implements ActionListener {            //复制按钮生成事件
	    public void actionPerformed(ActionEvent e) {
	      String selection = cardField.getText();
	      if (selection == null)
	        return;
	      StringSelection clipString = new StringSelection(selection);
	      clipbd.setContents(clipString, clipString);
	    }
	  }
	class CopyL2 implements ActionListener {            //复制按钮生成事件
	    public void actionPerformed(ActionEvent e) {
	      String selection = idcardField.getText();
	      if (selection == null)
	        return;
	      StringSelection clipString = new StringSelection(selection);
	      clipbd.setContents(clipString, clipString);
	    }
	  }
 	class CutL implements ActionListener {
	    public void actionPerformed(ActionEvent e) {    //剪切按钮事件
	      String selection = cardField.getText();
	      if (selection == null)
	        return;
	      StringSelection clipString = new StringSelection(selection);
	      clipbd.setContents(clipString, clipString);
	      cardField.setText("");
	    }
	  }
	public static void main(String args[]){
		panel stu = new panel();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	}

	public void windowClosing(WindowEvent e){// 处理窗口关闭事件
		System.exit(0); // 程序停止运行,关闭框架窗口
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}