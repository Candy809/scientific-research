package com.psy.test.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class stu_CheckImgAction extends ActionSupport {

    public String execute() throws Exception {
        int width = 120;
        int height = 30;
        // 步骤一 绘制一张内存中图片
        BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        // 步骤二 图片绘制背景颜色 ---通过绘图对象
        Graphics graphics = bufferedImage.getGraphics();// 得到画图对象 --- 画笔
        // 绘制任何图形之前 都必须指定一个颜色
        graphics.setColor(getRandColor(200, 250));
        graphics.fillRect(0, 0, width, height);
        // 步骤三 绘制边框
        graphics.setColor(Color.WHITE);
        graphics.drawRect(0, 0, width - 1, height - 1);
        // 步骤四 四个随机数字
        Graphics2D graphics2d = (Graphics2D) graphics;
        // 设置输出字体
        graphics2d.setFont(new Font("微软雅黑", Font.BOLD, 18));
        // 大小写字母、数字
//        String words ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        String words ="1234567890";
        Random random = new Random();// 生成随机数
        // 定义StringBuffer
        StringBuffer sb = new StringBuffer();
        // 定义x坐标
        int x = 10;
        for (int i = 0; i < 4; i++) {
            // 随机颜色
            graphics2d.setColor(new Color(20 + random.nextInt(110), 20 + random
                    .nextInt(110), 20 + random.nextInt(110)));
            // 旋转 -30 --- 30度
            int jiaodu = random.nextInt(60) - 30;
            // 换算弧度
            double theta = jiaodu * Math.PI / 180;
            // 生成一个随机数字
            int index = random.nextInt(words.length()); // 生成随机数 0 到 length - 1
            // 获得字母数字
            char c = words.charAt(index);
            sb.append(c);
            // 将c 输出到图片
            graphics2d.rotate(theta, x, 20);
            graphics2d.drawString(String.valueOf(c), x, 20);
            graphics2d.rotate(-theta, x, 20);
            x += 30;
        }
        // 将生成的字母存入到session中
        ServletActionContext.getRequest().getSession().setAttribute("stu_checkcode", sb.toString());
        // 步骤五 绘制干扰线
        graphics.setColor(getRandColor(160, 200));
        int x1;
        int x2;
        int y1;
        int y2;
        for (int i = 0; i < 20; i++) {
            x1 = random.nextInt(width);
            x2 = random.nextInt(12);
            y1 = random.nextInt(height);
            y2 = random.nextInt(12);
            graphics.drawLine(x1, y1, x1 + x2, x2 + y2);
        }
        // 将上面图片输出到浏览器 ImageIO
        graphics.dispose();// 释放资源
        ImageIO.write(bufferedImage, "jpg", ServletActionContext.getResponse().getOutputStream());
        /*一定注意：验证码action不需要任何返回参数，所以直接返回none*/
        return NONE;
    }

    /**
     * 取其某一范围的color
     * @param fc
     *            int 范围参数1
     * @param bc
     *            int 范围参数2
     * @return Color
     */
    private Color getRandColor(int fc, int bc) {
        // 取其随机颜色
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
