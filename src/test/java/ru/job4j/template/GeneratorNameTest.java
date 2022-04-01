package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GeneratorNameTest {

    @Ignore
    @Test
    public void whenOk() {
        Generator gen = new GeneratorName();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String res = gen.produce("I am a ${name}, Who are ${subject}? ", map);
        assertThat(res, is("I am a Petr Arsentev, Who are you? "));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenTemplateHasExtraKeys() {
        Generator gen = new GeneratorName();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String res = gen.produce("I am a ${name}, I am &{age} old."
                + " Who are ${subject}? ", map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenMapHasExtraKeys() {
        Generator gen = new GeneratorName();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        map.put("age", "32");
        String res = gen.produce("I am a ${name}, Who are ${subject}? ", map);
    }
}