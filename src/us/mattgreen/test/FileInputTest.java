package us.mattgreen.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.mattgreen.FileInput;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class FileInputTest {
    private FileInput indata;
    @Before
    public void setup(){
       indata = new FileInput("the_book.csv");
    }

    @Test
    public void testFile(){
        FileInput indata = new FileInput("the_book.csv");
        assertNotNull( " Reader should return data. ",
                indata.fileReadLine());
    }

    @After
    public void tearDown(){
        indata.fileClose();
    }
}
