package org.iodemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    static FileInputStream fis = null;
    static FileOutputStream fos = null;

    public static void main(String[] args) {

        moveTextFile("C:\\Users\\admin\\Desktop\\aaa\\ccc.txt", "E:\\aba\\bab.txt");
        System.out.println("----------------------------------------------------------------------------------");
        moveJpgFile("C:\\Users\\admin\\Desktop\\aaa\\jiawa.jpg", "E:\\aba\\jiawa.jpg");
        System.out.println("----------------------------------------------------------------------------------");
        moveMusicFile("C:\\Users\\admin\\Desktop\\aaa\\wmzr.mp3", "E:\\aba\\wmzr.mp3");

    }

    /**
     * 移动文本内容
     *
     * @param oldDicPath 原始路径
     * @param newDicPath 新路径
     */
    public static void moveTextFile(String oldDicPath, String newDicPath) {
        byte[] bytes = new byte[1024];
        try {
            fis = new FileInputStream(oldDicPath);
            fos = new FileOutputStream(newDicPath);
            while (fis.read(bytes) != -1) {
                for (byte b : bytes) {
                    System.out.println("\n" + b);
                    fos.write(b);
                }
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fis.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 移动图片文件
     *
     * @param oldDicPath 原始路径
     * @param newDicPath 新路径
     */
    public static void moveJpgFile(String oldDicPath, String newDicPath) {
        byte[] bytes = new byte[1024 * 1024];
        extracted(oldDicPath, newDicPath, bytes);
    }

    /**
     * 移动mp3文件
     *
     * @param oldDicPath 原始路径
     * @param newDicPath 新路径
     */
    public static void moveMusicFile(String oldDicPath, String newDicPath) {
        byte[] bytes = new byte[1024 * 1024];
        extracted(oldDicPath, newDicPath, bytes);

    }

    /**
     * 图片和音频文件中的异常处理
     *
     * @param oldDicPath 原始路径
     * @param newDicPath 新路径
     * @param bytes      读取大小
     */
    private static void extracted(String oldDicPath, String newDicPath, byte[] bytes) {
        try {
            fis = new FileInputStream(oldDicPath);
            fos = new FileOutputStream(newDicPath);
            while (fis.read(bytes) != -1) {
                fos.write(bytes);
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fis.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}