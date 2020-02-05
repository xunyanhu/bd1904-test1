package com.bd1904;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DjlDriver {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(DjlDriver.class);
        job.setMapperClass(DjlMapper.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);


        FileInputFormat.addInputPath(job,new Path(args[0]));//运行程序时指定输入路径
        FileOutputFormat.setOutputPath(job,new Path(args[1]));//输出路径

        //提交任务
        boolean result = job.waitForCompletion(true);

        System.out.println("完成任务");
        //退出程序
        System.exit(result?0:-1);


    }
}
