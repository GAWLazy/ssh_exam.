package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.QuestionDao;
import com.entity.Question;

/**
 * 问题服务类
 * 处理问题相关业务
 */
@Service
@Transactional	//将此类中所有方法加入事务处理
public class QuestionService {

	@Resource
	private QuestionDao questionDao;
	
	
	//随机获取考题
	public Question getRandomQuestionIntro(int category_id) {
		return questionDao.getRandomQuestionIntro(category_id);
	}

	//根据id获取考题的所有信息
	public Question getQuestionById(int question_id) {
		return questionDao.getQuestionById(question_id);
	}

	//根据id获取考题的答案等信息
	public Question getQuestionResultById(int question_id) {
		return questionDao.getQuestionResultById(question_id);
	}
	
	//获取某考卷中的全部考题
	public List<Question> getAllCategoryQuestion(int category_id) {
		return questionDao.getAllCategoryQuestion(category_id);
	}
	
	//分页查询某考卷中的题目信息
	public Question getPartQuestionIntro(int paper_id, int begin, int rows) {
		return questionDao.getPartQuestionIntro(paper_id,begin,rows);
	}

	//获取全部考题
	public List<Question> getAllQuestions(){
		return questionDao.getAllQuestion();
	}
	
	//获取考题总数
	public int getQuestionTotal() {
		return getAllQuestions().size();
	}

	//分页获取考题信息
	public List<Question> getQuestionList(String sortname, String sortorder,int begin, int rows) {
		List<Question> questionList = questionDao.getQuestionList(sortname, sortorder, begin, rows);
		for (Question question : questionList) {
			question.setCategoryName(question.getCategory().getName());
		}
		return questionList;
	}

	//添加考题
	public boolean add(Question question) {
		return questionDao.save(question);
	}

	//修改考题
	public boolean update(Question question) {
		return questionDao.update(question);
	}

	//删除考题
	public boolean delete(Question question) {
		return questionDao.delete(question);
	}
	
}
