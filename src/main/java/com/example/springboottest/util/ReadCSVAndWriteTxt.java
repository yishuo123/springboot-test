package com.example.springboottest.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvReader;

public class ReadCSVAndWriteTxt {

    public static void main(String[] args) throws IOException {
        String csvFilePath="D:\\参考手册\\无名\\LSTM数据\\2019110101\\2019042701.csv";
        String xFileName="D:\\参考手册\\无名\\LSTM数据\\2019110101\\X_train.txt";
        String yFileName="D:\\参考手册\\无名\\LSTM数据\\2019110101\\y_train.txt";

        //readCSVAndWrite(csvFilePAth);
        //readCSVAndWriteData(csvFilePath,xFileName,yFileName);

        //String h1[] = {"A","B","C","D","E","F"};
        String h1[] = {"A","B","C","D","K","P"};
        //String h1[] = {"actionid","actionname","1","\'非该动作\'","\'异常\'","\'分水岭\'"};
        readCSVAndWrite1("D:\\参考手册\\无名\\190428 安全带动作数据组织1.csv",h1);
    }

    /**
     * 读取CSV文件内容
     * @param csvFileName
     * @throws IOException
     */
    public static void readCSVAndWrite(String csvFileName) throws IOException{
        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(csvFileName);
            // 读表头
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                // 读一整行
                //System.out.println(csvReader.getRawRecord());
                // 读这行的某一列
                System.out.println(csvReader.get("A")+"\t"+csvReader.get("B")+"\t"+csvReader.get("C"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCSVAndWrite1(String csvFileName,String h1[]) throws IOException{
        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(csvFileName);
            // 读表头
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                // 读一整行
                //System.out.println(csvReader.getRawRecord());
                // 读这行的某一列
                if(csvReader.get(h1[0]).contains("actionid")) {
                    //System.out.println(csvReader.get(h1[0])+"\t"+csvReader.get(h1[1])+"\t"+csvReader.get(h1[2])+"\t"+csvReader.get(h1[3])+"\t"+csvReader.get(h1[4])+"\t"+csvReader.get(h1[5]));
                }

                if(csvReader.get(h1[1]).endsWith("f") && !csvReader.get(h1[2]).equals("")) {
                    System.out.println(csvReader.get(h1[0])+"\t"+csvReader.get(h1[1])+"\t"+csvReader.get(h1[2])+"\t"+csvReader.get(h1[3])+"\t"+csvReader.get(h1[4])+"\t"+csvReader.get(h1[5]));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取CSV文件内容
     * @param csvFileName
     * @throws IOException
     */
    public static void readCSVAndWriteData(String csvFileName,String xFileName,String yFileName) throws IOException{
        File xFile = new File(xFileName);
        File yFile = new File(yFileName);

        xFile.createNewFile();
        yFile.createNewFile();

        FileWriter xFileWriter = new FileWriter(xFile);
        FileWriter yFileWriter = new FileWriter(yFile);

        BufferedWriter xBufferWriter = new BufferedWriter(xFileWriter);
        BufferedWriter yBufferWriter = new BufferedWriter(yFileWriter);

        String lineA = "A1";
        String lineB = "B1";
        String lineC = "C";

        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(csvFileName);

            // 读表头
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                // 读一整行
                //System.out.println(csvReader.getRawRecord());
                // 读这行的某一列
                System.out.println(csvReader.get(lineA)+"\t"+csvReader.get(lineB)+"\t"+csvReader.get(lineC));
                //xBufferWriter.write(csvReader.get(lineA)+"\t"+csvReader.get(lineB)+"\n");
                if(csvReader.get(lineC).equals("1")) {
                    yBufferWriter.write("1"+"\n");
                    xBufferWriter.write(csvReader.get(lineA)+"\t"+csvReader.get(lineB)+"\n");
                }else if(csvReader.get(lineC).equals("27")) {
                    yBufferWriter.write("2"+"\n");
                    xBufferWriter.write(csvReader.get(lineA)+"\t"+csvReader.get(lineB)+"\n");
                }else if(csvReader.get(lineC).equals("33")) {
                    yBufferWriter.write("3"+"\n");
                    xBufferWriter.write(csvReader.get(lineA)+"\t"+csvReader.get(lineB)+"\n");
                }
            }

            xBufferWriter.flush();
            yBufferWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
