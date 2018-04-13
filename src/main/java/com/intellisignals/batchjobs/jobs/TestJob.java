package com.intellisignals.batchjobs.jobs;

import com.intellisignals.batchjobs.WordCount;
import com.intellisignals.batchjobs.entity.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by eellpp on 28/3/18.
 */
@Component
@ConditionalOnExpression("'${job.name}'.equals('testJob')")
public class TestJob implements CommandLineRunner {
    @Autowired
    WordCount wordCount;

    @Override
    public void run(String... strings) throws Exception {
        List<Count> res = wordCount.count();
        res.stream().forEach(c -> System.out.println(c.getWord() + " : " + c.getCount()));
    }
}
