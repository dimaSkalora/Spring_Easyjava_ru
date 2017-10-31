package spring_data_access_test.spring_jdbc_test.head_03_test.spring_data_jdbc_query.spring.data.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.dao.SkuRepositoryJdbc;
import spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.entity.Sku;

import javax.inject.Inject;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration("/Spring-Data-Access/SpringJDBC/Head_03/spring-data-jdbc-query/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuRepositoryJdbcIT {
    @Inject
    private SkuRepositoryJdbc testedObject;

    @DirtiesContext
    @Test
    public void testGetDescription() {
        assertThat(testedObject.getDescription(100), is("TEST"));
    }

    @DirtiesContext
    @Test
    public void testGetThirdDescription() {
        assertThat(testedObject.getThirdSkuDescription(), is("Sample SKU #3"));
    }

    @DirtiesContext
    @Test
    public void testCreate() {
        Sku expected = new Sku();
        expected.setId(500);
        expected.setDescription("NEWBIE");

        testedObject.add(expected);

        assertThat(testedObject.getDescription(500), is("NEWBIE"));
    }
}