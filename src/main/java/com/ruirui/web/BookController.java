package com.ruirui.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruirui.dto.AppointExecution;
import com.ruirui.dto.Result;
import com.ruirui.enums.AppointStateEnum;
import com.ruirui.exception.NoNumberException;
import com.ruirui.exception.RepeatAppointException;
import com.ruirui.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list",bookService.getList());
		return "list";
	}
	
	@RequestMapping(value="/{bookId}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("bookId") long bookId,Model model) {
		model.addAttribute("detail", bookService.getById(bookId));
		return "detail";
	}
	
	@RequestMapping(value="/{bookId}/appoint", method = RequestMethod.POST, produces = {
    "application/json; charset=utf-8" })
	@ResponseBody
	public Result<AppointExecution> appoint(@PathVariable("bookId") long bookId,@RequestParam("studentId") Long studentId){
		if(studentId == null) {
			return new Result<>(false,"学生号不能为空！");
		}
		AppointExecution execution  = null;
		try {
			execution  = bookService.appoint(bookId, studentId);
		}catch (NoNumberException e1) {
			execution = new AppointExecution(bookId,AppointStateEnum.NO_NUMBER);
		}catch (RepeatAppointException e2) {
			execution = new AppointExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
		}catch (Exception e) {
			execution = new AppointExecution(bookId,AppointStateEnum.INNER_ERROR);
		}
		return new Result<AppointExecution>(true,execution);
	}
	
	
	
}
