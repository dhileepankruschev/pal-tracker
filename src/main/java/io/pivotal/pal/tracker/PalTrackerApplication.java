package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {

    @Bean
    public TimeEntryRepository stringStore() {
        return new InMemoryTimeEntryRepository();
    }

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
}
