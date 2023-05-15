package hallym.hashtag.csvSave;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.FileReader;
import java.io.IOException;

@SpringBootTest
public class CsvFileSave {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void UserSave() throws CsvValidationException, IOException {
        String url = "C:/study/project/LibraryRenewal_backend/src/main/resources/data/userdata.csv";

        CSVReader reader = new CSVReaderBuilder(new FileReader(url))
                .withSkipLines(1)
                .build();

        String[] line;
        while ((line = reader.readNext()) != null) {
            User u = User.builder().name(line[0]).number(line[1])
                    .phone(line[2]).department(line[3]).roles(line[4])
                    .password(bCryptPasswordEncoder.encode(line[5])).build();

            userRepository.save(u);
        }


    }
}
