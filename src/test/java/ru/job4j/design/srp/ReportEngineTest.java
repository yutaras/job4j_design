package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.design.srp.ReportAccountant.DOLLAR;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportAccountant() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report accountant = new ReportAccountant(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() / DOLLAR).append(";")
                .append(System.lineSeparator());
        assertThat(accountant.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Max", now, now, 200);
        Employee worker2 = new Employee("Ivan", now, now, 100);
        Employee worker3 = new Employee("Nikola", now, now, 300);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report hr = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(hr.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportProgrammer() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Max", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report programmer = new ReportProgrammer(store);
        StringBuilder expect = new StringBuilder()
                .append("<html>" + "<table>" + "<body>"
                        + "<tr>"
                        + "<th>Name</th>"
                        + "<th>Hired</th>"
                        + "<th>Fired</th>"
                        + "<th>Salary</th>"
                        + "</tr>").append(System.lineSeparator())
                .append("<tr>")
                .append("<td>").append(worker1.getName()).append("</td>")
                .append("<td>").append(worker1.getHired()).append("</td>")
                .append("<td>").append(worker1.getFired()).append("</td>")
                .append("<td>").append(worker1.getSalary()).append("</td>")
                .append("</tr>")
                .append(System.lineSeparator())
                .append("<tr>")
                .append("<td>").append(worker2.getName()).append("</td>")
                .append("<td>").append(worker2.getHired()).append("</td>")
                .append("<td>").append(worker2.getFired()).append("</td>")
                .append("<td>").append(worker2.getSalary()).append("</td>")
                .append("</tr>")
                .append(System.lineSeparator())
                .append("</body>" + "</table>" + "</html>");
        assertThat(programmer.generate(em -> true), is(expect.toString()));
    }
}