package com.hubu.socket;
import com.hubu.dao.LayoffMapper;
import com.hubu.pojo.Layoff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

@Component
public class SocketThread implements Runnable
{

   /* @Autowired(required = false)*/
    @Autowired
    LayoffMapper layoffMapper;

/*    @Autowired(required = false)*/
    private Socket socket;

    public SocketThread(){

    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void run()
    {

        // 根据输入输出流和客户端连接
        try
        {
            InputStream inputStream = socket.getInputStream();
            //从输入流得到客户端传递的字节流（长度最大160）
            byte[] ReceiveDataTemp = new byte[160];
            int len = -1;
            while ((len  = inputStream.read(ReceiveDataTemp)) != -1)
            {
                System.out.print("\\n接收客户端信息:");
                for(int iprint=0; iprint<160; iprint++)
                {
                    System.out.print((char)ReceiveDataTemp[iprint]);
                }
                System.out.print(",本地端口：" + socket.getLocalPort() + ",远程端口：" + socket.getPort() + ",远程IP地址：" + socket.getInetAddress() + "数据信息解析如下：\n");                Layoff layoff = byteToLayoff(ReceiveDataTemp);
                System.out.println(layoff.toString());
                layoffMapper.insertSelective(layoff);

            }
            // 关闭相对应的资源
            //bufferedReader.close();
            inputStream.close();
            //PrintWriter.close();
            //outputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @RequestMapping("/hi")
    @ResponseBody
    public String hi(){
        return "hi";
    }
    //数据解析处理成Layoff对象
    Layoff byteToLayoff(byte []temp)
    {
        Layoff  layoff = new Layoff();
        char[] NO = new char[3];
        //char[] BH = new char[10];
        String BH = null;
        int FirstWeight = 0;
        int SecondWeight = 0;
        float FirstDepth = 0;
        float SecondDepth = 0;
        float SumDepth = 0;
        char[] BT = new char[16];
        char[] ET = new char[16];
        int []KGM = new int[100];
        //时间格式初始化
        BT[0] = ET[0] = '2';
        BT[1] = ET[1] = '0';
        BT[4] = BT[7] = BT[10] = '/';
        ET[4] = ET[7] = ET[10] = '/';
        BT[13] = ET[13] = ':';

        int[] data = new int[80];

        int itemp = 0;
        for(int idata=0; idata<data.length; idata++)
        {
            //将明码转为16进制的字节码再进行数据解析处理
            data[idata] = (((char2hex((char)(temp[itemp]&0x00ff)))&0x0f)<<4) + ((char2hex((char)(temp[itemp+1]&0x00ff)))&0x0f);
            itemp = itemp + 2;
			/*
			//字节数组转存为int数组，为了解决非明码传输时ASCII码值大于127的字节解析出错的问题，协议明码传输无需考虑该问题
            if(temp[itemp]<0)
            {
                data[itemp]=temp[itemp]&0xff;
            }
            else
            {
                data[itemp]=temp[itemp];
            }
			*/
        }
        itemp = 0;

        //数据解析处理
        //明码：    04000000130000001600D10200000000D102120C161100120C161104040302020503030000000000000000000000000000000000000000000000000000000000000000000000000005120C09
        //16进制码：04 00 00 00 13 00 00 00 16 00 D1 02 00 00 00 00 D1 02 12 0C 16 11 00 12 0C 16 11 04 04 03 02 02 05 03 03 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 05 12 0C 09

        //处理桩机流水号
        int tempNO = data[0] + data[1]*256;
        NO[0] = (char)(tempNO%1000/100 + '0');
        NO[1] = (char)(tempNO%100/10 + '0');
        NO[2] = (char)(tempNO%10/1 + '0');
        layoff.setPileNo("" + NO[0] + NO[1] + NO[2]);
        System.out.println("桩机流水号:" + NO[0] + NO[1] + NO[2]);

        //处理第一次下料重量
        FirstWeight = data[4] + data[5]*256;
        layoff.setFirstWeight((float)FirstWeight);
        System.out.println("第一次下料重量:" + FirstWeight);

        //处理第二次下料重量
        SecondWeight = data[8] + data[9]*256;
        layoff.setSecondWeight((float)SecondWeight);
        System.out.println("第二次下料重量:" + SecondWeight);

        //处理第一次下料深度
        FirstDepth =Float.valueOf((data[10] + data[11]*256))/100;
        layoff.setFirstDepth((float)FirstDepth);
        System.out.println("第一次下料深度:" + FirstDepth);

        //处理第二次下料深度
        SecondDepth = Float.valueOf(data[12] + data[13]*256)/100;
        layoff.setSecondDepth((float)SecondDepth);
        System.out.println("第二次下料深度:" + SecondDepth);

        //处理总深度
        SumDepth = Float.valueOf(data[16] + data[17]*256)/100;
        layoff.setSumDepth((float)SumDepth);
        System.out.println("下料总深度:" + SumDepth);

        //处理开始时间
        BT[2] = (char)(data[18]%100/10 + '0');
        BT[3] = (char)(data[18]%10/1 + '0');
        BT[5] = (char)(data[19]%100/10 + '0');
        BT[6] = (char)(data[19]%10/1 + '0');
        BT[8] = (char)(data[20]%100/10 + '0');
        BT[9] = (char)(data[20]%10/1 + '0');
        BT[11] = (char)(data[21]%100/10 + '0');
        BT[12] = (char)(data[21]%10/1 + '0');
        BT[14] = (char)(data[22]%100/10 + '0');
        BT[15] = (char)(data[22]%10/1 + '0');
        layoff.setBeginTime("" + BT[0] + BT[1] + BT[2] + BT[3] + BT[4] + BT[5] + BT[6] + BT[7] + BT[8] + BT[9] + BT[10] + BT[11] + BT[12] + BT[13] + BT[14] + BT[15]);
        System.out.println("开始时间:" + BT[0] + BT[1] + BT[2] + BT[3] + BT[4] + BT[5] + BT[6] + BT[7] + BT[8] + BT[9] + BT[10] + BT[11] + BT[12] + BT[13] + BT[14] + BT[15]);

        //处理结束时间
        ET[2] = (char)(data[23]%100/10 + '0');
        ET[3] = (char)(data[23]%10/1 + '0');
        ET[5] = (char)(data[24]%100/10 + '0');
        ET[6] = (char)(data[24]%10/1 + '0');
        ET[8] = (char)(data[25]%100/10 + '0');
        ET[9] = (char)(data[25]%10/1 + '0');
        ET[11] = (char)(data[26]%100/10 + '0');
        ET[12] = (char)(data[26]%10/1 + '0');
        ET[14] = (char)(data[27]%100/10 + '0');
        ET[15] = (char)(data[27]%10/1 + '0');
        layoff.setEndTime("" + ET[0] + ET[1] + ET[2] + ET[3] + ET[4] + ET[5] + ET[6] + ET[7] + ET[8] + ET[9] + ET[10] + ET[11] + ET[12] + ET[13] + ET[14] + ET[15]);
        System.out.println("结束时间:" + ET[0] + ET[1] + ET[2] + ET[3] + ET[4] + ET[5] + ET[6] + ET[7] + ET[8] + ET[9] + ET[10] + ET[11] + ET[12] + ET[13] + ET[14] + ET[15]);

        //处理打桩记录
        //记录数量
        float icount = SumDepth/100;
        //加一处理标志位
        char icountFlag = 0;
        System.out.println("记录初值:" + icount);
        if(SumDepth%100 > 0)
        {
            icountFlag = 1;
            icount++;
        }
        System.out.println("记录终值:" + icount);
        for(int i=0; i<icount; i++)
        {
            KGM[i] = data[28+i]&0xFF;
            if(i < icount-1)
            {
                System.out.println("第 " + i + " 到 " + (i+1) + " 米下料: " + ((char)(KGM[i]%100/10 + '0')) + ((char)(KGM[i]%10/1 + '0')) + " KG");
            }
            else
            {
                if(icountFlag == 1)
                {
                    System.out.println("第 " + i + " 到 " + ((char)(SumDepth/1000 + '0')) + ((char)(SumDepth%1000/100 + '0')) + "." + ((char)(SumDepth%100/10 + '0')) + ((char)(SumDepth%10/1 + '0')) + " 米下料: " + ((char)(KGM[i]%100/10 + '0')) + ((char)(KGM[i]%10/1 + '0')) + " KG");
                }
                else
                {
                    System.out.println("第 " + i + " 到 " + (i+1) + " 米下料: " + ((char)(KGM[i]%100/10 + '0')) + ((char)(KGM[i]%10/1 + '0')) + " KG");
                }
            }
        }
        //标志位清零
        icountFlag = 0;

        //处理机台编号
        String BHtemp1 = null;
        String BHtemp2 = null;
        String BHtemp3 = null;
        String BHtemp4 = null;
        //机台编号拼接处理
        BHtemp1 = String.valueOf(data[72]%10/1);
        if(data[73]/100 == 0)
        {
            BHtemp2 = String.valueOf(data[73]%100/10) + String.valueOf(data[73]%10/1);
        }
        else
        {
            BHtemp2 = String.valueOf(data[73]%1000/100) + String.valueOf(data[73]%100/10) + String.valueOf(data[73]%10/1);
        }
        if(data[74]/100 == 0)
        {
            BHtemp3 = String.valueOf(data[74]%100/10) + String.valueOf(data[74]%10/1);
        }
        else
        {
            BHtemp3 = String.valueOf(data[74]%1000/100) + String.valueOf(data[74]%100/10) + String.valueOf(data[74]%10/1);
        }
        if(data[75]/100 == 0)
        {
            BHtemp4 = String.valueOf(data[75]%100/10) + String.valueOf(data[75]%10/1);
        }
        else
        {
            BHtemp4 = String.valueOf(data[75]%1000/100) + String.valueOf(data[75]%100/10) + String.valueOf(data[75]%10/1);
        }
        BH = BHtemp2 + BHtemp3 + BHtemp4 + BHtemp1;
        layoff.setMachineNo(BH);
        System.out.println("机台编号为：" + BH);

        return layoff;
    }


    //字节码转16进制
     byte char2hex(char chr)
    {
        if(chr>='0'&&chr<='9')
            return (byte)((chr-'0')&0x00ff);
        if(chr>='A'&&chr<='F')
            return (byte)((chr-'A'+10)&0x00ff);
        if(chr>='a'&&chr<='f')
            return (byte)((chr-'a'+10)&0x00ff);
        return 0;
    }


}