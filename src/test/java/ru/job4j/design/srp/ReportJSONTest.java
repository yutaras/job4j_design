package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportJSONTest {
    @Test
    public void whenJSONTest() {
        MemStore store = new MemStore();
        Calendar dateHired = new GregorianCalendar(2017, Calendar.JANUARY, 25);
        Calendar dateFired = new GregorianCalendar(2019, Calendar.JULY, 25);
        Employee worker = new Employee("Ivan", dateHired, dateFired, 100);
        store.add(worker);
        Report engine = new ReportJSON(store);
        StringBuilder expect = new StringBuilder()
                .append("[{")
                .append("\"name\":\"").append(worker.getName()).append("\",")
                .append("\"hired\":")
                .append("{\"year\":").append(worker.getHired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getHired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getHired().get(Calendar.DATE)).append(",")
                .append("\"hourOfDay\":").append(worker.getHired().get(Calendar.HOUR)).append(",")
                .append("\"minute\":").append(worker.getHired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getHired().get(Calendar.SECOND)).append("},")
                .append("\"fired\":")
                .append("{\"year\":").append(worker.getFired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getFired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getFired().get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(worker.getFired().get(Calendar.HOUR)).append(",")
                .append("\"minute\":").append(worker.getFired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getFired().get(Calendar.SECOND)).append("},")
                .append("\"salary\":").append(worker.getSalary())
                .append("}]");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}