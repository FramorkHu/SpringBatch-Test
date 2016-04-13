package com.springbatch.demo.writedb;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.FileWriter;

/**
 * Created by huyan on 2016/4/13.
 */
public class ThreadWriteDB {

    private static final String FILE_PATH = "d:\\home\\batch.txt";
    private static final String TARGET_FILE_PATH = "d:\\home\\batchTmp.txt";

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        File sourceFile = new File(FILE_PATH);
        File targetFile = new File(TARGET_FILE_PATH);
        copyFile2(sourceFile, targetFile);
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    public static boolean copyFile(File sourceFile, File targetFile) throws IOException {

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(sourceFile));
            outputStream = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] bufferBytes = new byte[1024 * 5];
            int len;
            while ( (len = inputStream.read(bufferBytes)) != -1) {
                outputStream.write(bufferBytes, 0, len);
            }
            // 刷新此缓冲的输出流
            outputStream.flush();
            return true;

        }  finally {

            if (inputStream != null){
                inputStream.close();
            }
            if (outputStream != null){
                outputStream.close();
            }
        }

    }

    public static void copyFile2(File sourceFile, File targetFile) throws IOException {

        try {

            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(sourceFile)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            BufferedWriter out = new BufferedWriter(new FileWriter(targetFile));
            while (line != null) {
                out.write(line+"\n");
                line = br.readLine(); // 一次读入一行数据
            }

            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
