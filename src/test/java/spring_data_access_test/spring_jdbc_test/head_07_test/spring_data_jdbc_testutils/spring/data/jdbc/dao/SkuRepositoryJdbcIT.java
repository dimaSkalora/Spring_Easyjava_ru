package spring_data_access_test.spring_jdbc_test.head_07_test.spring_data_jdbc_testutils.spring.data.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import spring_data_access.spring_jdbc.head_07.spring_data_jdbc_testutils.spring.data.jdbc.dao.SkuRepositoryJdbc;
import spring_data_access.spring_jdbc.head_07.spring_data_jdbc_testutils.spring.data.jdbc.entity.Sku;

import javax.inject.Inject;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration("/Spring-Data-Access/SpringJDBC/Head_07/spring-data-jdbc-testutils/applicationContext.xml")
@SqlGroup({
        @Sql("/skus-table.sql"),
        @Sql("/skus-data.sql")

})
@Sql( scripts = "/skus-delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuRepositoryJdbcIT {
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Inject
    private SkuRepositoryJdbc testedObject;

    @Test
    public void testGetDescription() {
        assertThat(testedObject.getDescription(100), is("TEST"));
    }

    @Test
    public void testGetThirdDescription() {
        assertThat(testedObject.getThirdSkuDescription(), is("Sample SKU #3"));
    }

    @Test
    public void testCreate() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "skus");

        Sku expected = new Sku();
        expected.setId(1);
        expected.setDescription("NEWBIE");

        testedObject.add(expected);

        assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "skus"), is(1));
    }
}