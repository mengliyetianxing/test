package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DrawImage")
public class DrawImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage bi = new BufferedImage(104, 40, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		g.setColor(Color.green);
		g.fillRect(0, 0, 104, 40);
		g.setColor(Color.red);
		g.drawRect(1, 1, 104 - 2, 40 - 2);
		g.setColor(Color.blue);
		 for (int i = 0; i < 15; i++) {
			 int x1 = new Random().nextInt(104);
			 int y1 = new Random().nextInt(40);
			 int x2 = new Random().nextInt(104);
			 int y2 = new Random().nextInt(40);
			 g.drawLine(x1, y1, x2, y2);
         }
		 g.setColor(Color.RED);
		 g.setFont(new Font("ËÎÌו", Font.BOLD, 20));
		 String baseNumLetter = "0123456789ABCDEFGHJKLMNOPQRSTUVWXYZ";
	
		 StringBuffer sb = new StringBuffer();
		 int x = 5;
		 String ch ="";
		 for (int i = 0; i < 4; i++) {
			 int degree = new Random().nextInt() % 30;
			 ch = baseNumLetter.charAt(new Random().nextInt(baseNumLetter.length())) + "";
			 sb.append(ch);
//			 ((Graphics2D)g).rotate(degree * Math.PI / 180, x, 20);
			 ((Graphics2D)g).drawString(ch, x, 20);
//			 ((Graphics2D)g).rotate(-degree * Math.PI / 180, x, 20);
			 x += 30;
		 }
		 request.getSession().setAttribute("checkcode", sb.toString());
		 response.setContentType("image/jpeg");
		 response.setDateHeader("expries", -1);
		 response.setHeader("Cache-Control", "no-cache");
		 response.setHeader("Pragma", "no-cache");
		 ImageIO.write(bi, "jpg", response.getOutputStream());
	}
}
