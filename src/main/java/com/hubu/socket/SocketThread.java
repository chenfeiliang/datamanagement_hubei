package com.hubu.socket;

import com.hubu.mapper.RecordMapper;
import com.hubu.pojo.Record;
import com.hubu.utils.RecordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 功能描述:  将数据插入到数据库的线程类。
 *
 *  Author:   chenfeiliang
 */
@Component
@Scope("prototype")
public class SocketThread extends Thread
{

    @Autowired
    RecordMapper recordMapper;  //操作数据库的接口，实现插入

    private Logger logger = LoggerFactory.getLogger(this.getClass());  //日志类

    private Socket socket;

/*
    private int clientNo;    核对执行次数，看看数据是否遗漏

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }
*/

    public SocketThread(){

    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void run()
    {
        InputStream inputStream = null;
        // 根据输入输出流和客户端连接
        try
        {
            inputStream = socket.getInputStream();
            //从输入流得到客户端传递的字节流（长度最大160）
            byte[] ReceiveDataTemp = new byte[160];
            int len = -1;
            while ((len  = inputStream.read(ReceiveDataTemp)) != -1) //((len  = inputStream.read(ReceiveDataTemp)) != -1) &&
            {
                Record record = RecordUtil.byteToRecord(ReceiveDataTemp);
/*                logger.info("线程" + clientNo + "正在执行");*/
                recordMapper.insertSelective(record);
/*                logger.info("线程" + clientNo + "执行完毕");*/
            }
        }
        catch (IOException e)
        {
            logger.error(e.getMessage());
        }
        finally {
            // 关闭相对应的资源
            try {
                if(inputStream!=null) {
                    inputStream.close();
                }
                if(socket!=null){
                    socket.close();
                }

            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }





}