package com.bd1904;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DjlMapper extends Mapper<LongWritable,Text,Text,NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //火狐-win7-山东省-http://gh.duowan.com-http://www.tiantiandy.net/wind/nn_pettopall.asp-1920*1080-65-222.45.134.219-2018 9 19  22:28:3
        String [] messages = value.toString().split("-");
        if(messages.length == 9){
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0 ;i < messages.length-1 ;i++){
                stringBuffer.append(messages[i]).append("\t");
            }
            //2018 9 19  22:28:3 --  2018 9 19 -- 2018 \t 9 \t 19
            String [] times = messages[8].split("  ")[0].split(" ");
            stringBuffer.append(times[0]).append("\t").append(times[1]).append("\t").append(times[2]);
            context.write(new Text(stringBuffer.toString()),NullWritable.get());
        }

    }
}
