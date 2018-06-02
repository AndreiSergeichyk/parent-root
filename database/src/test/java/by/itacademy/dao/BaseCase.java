package by.itacademy.dao;


import by.itacademy.config.TestConfiguration;
import by.itacademy.util.TestDataDelete;
import by.itacademy.util.TestDataImporter;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestConfiguration.class)
public class BaseCase {

    @Autowired
    private TestDataImporter testDataImporter;

    @Autowired
    private TestDataDelete testDataDelete;

    @Before
    public void clean() {
        testDataDelete.deleteTestData();
        testDataImporter.importTestData();
    }
}
