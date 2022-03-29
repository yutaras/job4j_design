package ru.job4j.kiss;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {

    @Test
    public void jobByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Fix bugs", 4),
                new Job("Impl task", 2)
        );
        MaxMin maxMin = new MaxMin();
        Job expectedMax = maxMin.max(jobs, new JobByPriority());
        Job expectedMin = maxMin.min(jobs, new JobByPriority());
        assertThat(new Job("Fix bugs", 4), is(expectedMax));
        assertThat(new Job("Reboot server", 1), is(expectedMin));
    }

}