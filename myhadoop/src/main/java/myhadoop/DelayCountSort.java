package myhadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import myhadoop.reducer.DelayCountSortReducer;
import myhadoop.support.DateKey;
import myhadoop.support.DateKeyComparator;
import myhadoop.support.GroupKeyComparator;
import myhadoop.support.GroupKeyPartitioner;
import myhdoop.mappers.DelayCountSortMapper;

public class DelayCountSort {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: DelayCountSort <input> <output>");
			System.exit(2);
		}

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "DelayCountSort");
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setJarByClass(DelayCountSort.class);
		//	파티셔너 클래스
		job.setPartitionerClass(GroupKeyPartitioner.class);
		//	그룹 키 비교기 등록
		job.setGroupingComparatorClass(GroupKeyComparator.class);
		//	복합 키 비교기 등록
		job.setSortComparatorClass(DateKeyComparator.class);
		
		job.setMapperClass(DelayCountSortMapper.class);
		job.setReducerClass(DelayCountSortReducer.class);
		
		//	매퍼 출력 키 클래스
		job.setMapOutputKeyClass(DateKey.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		job.setOutputKeyClass(DateKey.class);
		job.setOutputValueClass(IntWritable.class);
		
		MultipleOutputs.addNamedOutput(job, 
				"departure", 
				TextOutputFormat.class, 
				DateKey.class, 
				IntWritable.class);
		
		MultipleOutputs.addNamedOutput(job, 
				"arrival", 
				TextOutputFormat.class, 
				DateKey.class, 
				IntWritable.class);

		job.waitForCompletion(true);
	}

}
