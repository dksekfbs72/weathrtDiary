package zerobase.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.config.GlobalExceptionHandler;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

@RestController
public class DiaryController extends GlobalExceptionHandler {

	private final DiaryService diaryService;

	public DiaryController(DiaryService diaryService) {
		this.diaryService = diaryService;
	}

	@ApiOperation(value = "날짜와 일기를 적으면 DB에 날짜와 날씨, 일기를 저장", notes = "이것은 노트")
	@PostMapping("/create/diary")
	void createDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "저장할 날짜", example = "2020-01-01") LocalDate date,
		@RequestBody String text) {

		diaryService.createDiary(date, text);
	}
	@ApiOperation("선택한 날짜의 모든 일기 데이터를 불러옵니다")
	@GetMapping("/read/diary")
	List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "조회할 날짜", example = "2020-01-01") LocalDate date) {
		return diaryService.readDiary(date);
	}
	@ApiOperation("선택한 기간의 모든 일기 데이터를 불러옵니다")
	@GetMapping("/read/diaries")
	List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "조회할 기간의 첫번째 날", example = "2020-01-01") LocalDate startDate,
		@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "조회할 기간의 마지막 날", example = "2020-01-01") LocalDate endDate) {
		return diaryService.readDiaries(startDate, endDate);
	}
	@ApiOperation("선택한 날짜의 첫번째 일기 내용을 수정합니다.")
	@PutMapping("/update/diary")
	void updateDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "수정할 날짜", example = "2020-01-01") LocalDate date, @RequestBody String text) {
		diaryService.updateDiary(date, text);
	}
	@ApiOperation("선택한 날짜의 모든 일기 데이터를 지웁니다.")
	@DeleteMapping("delete/diary")
	void deleteDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "삭제할 날짜", example = "2020-01-01") LocalDate date) {
		diaryService.deleteDiary(date);
	}

}
