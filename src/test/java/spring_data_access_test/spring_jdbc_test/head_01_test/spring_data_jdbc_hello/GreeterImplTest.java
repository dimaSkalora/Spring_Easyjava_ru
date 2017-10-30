package spring_data_access_test.spring_jdbc_test.head_01_test.spring_data_jdbc_hello;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.annotations.dao.GreeterDao;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.annotations.service.GreeterImpl;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static org.easymock.EasyMock.expect;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GreeterImplTest extends EasyMockSupport {
    @Rule
    public EasyMockRule em = new EasyMockRule(this);

    @Mock
    private GreeterDao dao;

    @TestSubject
    private GreeterImpl testedObject = new GreeterImpl();

    @Test
    public void testNoGreets() {
        expect(dao.getGreetings()).andReturn(Collections.EMPTY_LIST);

        replayAll();

        assertThat(testedObject.greet(), is("No greets"));
    }

    @Test
    public void testGreets() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("GREETING", "TEST");
        expected.put("TARGET", "TEST");
        expect(dao.getGreetings()).andReturn(Collections.singletonList(expected));

        replayAll();

        assertThat(testedObject.greet(), is("TEST, TEST"));
    }
}