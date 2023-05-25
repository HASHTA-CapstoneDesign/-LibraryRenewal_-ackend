package hallym.hashtag.csvSave;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.abook.repostory.ABookRepository;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.domain.book.repository.BookRepository;
import hallym.hashtag.domain.notice.entity.Notice;
import hallym.hashtag.domain.notice.entity.NoticeImage;
import hallym.hashtag.domain.notice.repository.NoticeImageRepository;
import hallym.hashtag.domain.notice.repository.NoticeRepository;
import hallym.hashtag.domain.room.entity.Floor;
import hallym.hashtag.domain.room.entity.Room;
import hallym.hashtag.domain.room.entity.RoomReserve;
import hallym.hashtag.domain.room.entity.UseTime;
import hallym.hashtag.domain.room.repository.RoomRepository;
import hallym.hashtag.domain.room.repository.UseTimeRepository;
import hallym.hashtag.domain.roomRes.repository.RoomResRepository;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@SpringBootTest
public class csvSave {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ABookRepository aBookRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UseTimeRepository useTimeRepository;
    @Autowired
    NoticeRepository noticeRepository;
    @Autowired
    NoticeImageRepository noticeImageRepository;


    @Test
    public void UserSave() throws CsvValidationException, IOException {
        String url = "C:/study/project/LibraryRenewal_backend/src/main/resources/data/userdata.csv";

        CSVReader reader = new CSVReaderBuilder(new FileReader(url))
                .withSkipLines(1)
                .build();

        String[] line;
        while ((line = reader.readNext()) != null) {
            User u = User.builder().name(line[0]).number(line[1])
                    .phone(line[2]).department(line[3]).role(line[4])
                    .password(bCryptPasswordEncoder.encode(line[5]))
                    .build();
            userRepository.save(u);
        }
    }

    @Test
    public void bookSave() throws IOException, CsvValidationException {
        String url = "C:/study/project/LibraryRenewal_backend/src/main/resources/data/bookdata2.csv";

        CSVReader reader = new CSVReaderBuilder(new FileReader(url))
                .withSkipLines(1)
                .build();

        //SEQ_NO,ISBN_THIRTEEN_NO,TITLE_NM,AUTHR_NM,PUBLISHER_NM,PBLICTE_DE,IMAGE_URL,BOOK_INTRCN_CN,KDC_NM

        String[] line;
        int i= 1;
        while ((line = reader.readNext()) != null) {
//            if(i == 10) break;

            Book b = Book.builder().tag(Long.valueOf(line[1])).isbn(line[1]).title(line[2])
                    .author(line[3]).pud(line[4]).pudDate(line[5]).image(line[6])
                    .build();

            Book book = bookRepository.save(b);

            ABook aBook = ABook.builder().tag(String.valueOf(i)).book(book).build();
            i++;

            aBookRepository.save(aBook);
        }

    }

    @Test
    public void roomSave() throws IOException, CsvValidationException {
        String url = "C:/study/project/LibraryRenewal_backend/src/main/resources/data/roomdata.csv";

        CSVReader reader = new CSVReaderBuilder(new FileReader(url))
                .withSkipLines(1)
                .build();

        LocalDate now = LocalDate.now();

        String[] line;
        int i= 1;

        while ((line = reader.readNext()) != null){
//            if(i == 3) break;
            Room room = Room.builder().floor(Floor.valueOf(line[1])).name(line[2]).useData(now.toString()).build();
            roomRepository.save(room);

            for (int j = 0; j < 13; j++) {
                int start = 9+j;
                int end = start+1;
                UseTime useTime1 = UseTime.builder().time(start+":00-"+end+":00").roomReserve(RoomReserve.예약가능).room(room).build();
                useTimeRepository.save(useTime1);
            }
            i++;
        }
    }

    @Test
    public void noticeSave() throws IOException, CsvValidationException {
        String url = "C:/study/project/LibraryRenewal_backend/src/main/resources/data/noticedata.csv";

        CSVReader reader = new CSVReaderBuilder(new FileReader(url))
                .withSkipLines(1)
                .build();

        String[] line;
//        제목,내용,중요도,이미지1,이미지2,이미지3,작성자
        while ((line = reader.readNext()) != null) {
            Optional<User> user = userRepository.findById(Long.valueOf(line[6]));
            Notice notice = Notice.builder().title(line[0])
                    .content(line[1]).important(Boolean.parseBoolean(line[2])).user(user.get()).build();
            noticeRepository.save(notice);

            if (Objects.equals(line[3], "")) continue;
            noticeImageRepository.save(NoticeImage.builder()
                    .fileName(line[3]).notice(notice).build());

            if (Objects.equals(line[4], "")) continue;
            noticeImageRepository.save(NoticeImage.builder()
                    .fileName(line[4]).notice(notice).build());

            if (Objects.equals(line[5], "")) continue;
            noticeImageRepository.save(NoticeImage.builder()
                    .fileName(line[5]).notice(notice).build());
        }
    }
}
