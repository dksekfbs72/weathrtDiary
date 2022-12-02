package zerobase.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JpaMemoRepository;

@SpringBootTest
@Transactional
public class JpaMemoRepositoryTest {

	@Autowired
	JpaMemoRepository jpaMemoRepository;

	@Test
	void insertMemoTest() {
	    //given
		Memo memo = new Memo(2, "this is jpa memo~");
	    //when
		jpaMemoRepository.save(memo);
	    //then
		List<Memo> memoList = jpaMemoRepository.findAll();
		assertTrue(memoList.size() > 1);
	}

	@Test
	void findByIdTest() {
	    //given
		Memo memo = new Memo(11, "this is jpa memo~");
		//when
		Memo memo1 = jpaMemoRepository.save(memo);
		//then
		Optional<Memo> result = jpaMemoRepository.findById(memo1.getId());
		assertEquals(result.get().getText(), memo.getText());
	}
}