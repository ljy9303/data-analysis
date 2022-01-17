package ziller.core.crawler.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class QuasarCrawlerTest {

    @Autowired
    QuasarCrawler quasarCrawler;
    
    @Test
    void getData() {
        try {
            quasarCrawler.getQuasarData();    
        } catch(IOException e) {
            System.out.println("e = " + e);
        }
        
    }
}
