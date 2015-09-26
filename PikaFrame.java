import javax.swing.*;
class PikaFrame extends Thread
{
	StringBuffer str=new StringBuffer( " ");
	JFrame f=new JFrame();
	JLabel b=new JLabel();
		PikaFrame()
		{
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.getContentPane().add(b);
			f.setSize(400,400);
			f.setVisible(true);
		}

	void run()
	{
		for()
			b.setText(str);
	}
}