package spring_data_access_test.spring_jdbc_test.head_05_test.spring_data_jdbc_batch.spring.data.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.dao.SkuRepositoryJdbc;
import spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.entity.Sku;

import javax.inject.Inject;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration("/Spring-Data-Access/SpringJDBC/Head_05/spring-data-jdbc-batch/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuRepositoryJdbcIT {
    @Inject
    private SkuRepositoryJdbc testedObject;

    @DirtiesContext
    @Test
    public void testCreate() {
        Sku expected = new Sku();
        expected.setId(500);
        expected.setDescription("NEWBIE");

        testedObject.add(Collections.singletonList(expected));

        assertThat(testedObject.getDescription(500), is("NEWBIE"));
    }
}