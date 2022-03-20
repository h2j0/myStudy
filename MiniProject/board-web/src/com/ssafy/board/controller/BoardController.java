package com.ssafy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	private BoardDao dao;

	private static final long serialVersionUID = 1L;

	public BoardController() {
		dao = MyAppSqlConfig.getSession().getMapper(BoardDao.class);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// GET 요청은 안해도되는데 POST에서는 해야하는 작업
		if (request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}

		// Front-Controller 패턴
		String act = request.getParameter("act");
		switch (act) {
		case "list":
			list(request, response);
			break;
		case "writeform":
			writeForm(request, response);
			break;
		case "write":
			write(request, response);
			break;

		case "detail":
			detail(request, response);
			break;
		case "updateform":
			updateform(request, response);
			break;
		case "update":
			update(request, response);
			break;
		case "delete":
			delete(request, response);
			break;

		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// request.getParameter("id") 가지고 있다면 
		int id = Integer.parseInt(request.getParameter("id"));
		// dao야 딜리트 해줘
		dao.deleteBoard(id);
		// 그리고 다시 메인으로 돌아가고 싶다
		response.sendRedirect("board?act=list");

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Board board = new Board();
		// 새롭게 객체 생성이 아니라 그냥 가지고 와도 된다
//		Board board = Integer.parseInt(request.getParameter("id"));
		board.setId(Integer.parseInt(request.getParameter("id")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));

		dao.updateBoard(board);

		response.sendRedirect("board?act=list");
	}

	private void updateform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기존의 값이 남아있으면 좋겠다
		request.setAttribute("board", dao.selectBoardById(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher("/board/updateform.jsp").forward(request, response);
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디를 뽑아내야죠
		int id = Integer.parseInt(request.getParameter("id"));
		// 조회수 1증가
		dao.updateViewCnt(id);
		request.setAttribute("board", dao.selectBoardById(id));
		// 리퀘스트에 심어놨으니까
		request.getRequestDispatcher("/board/detail.jsp").forward(request, response);
	}

	private void write(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Board board = new Board();

		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));

		dao.insertBoard(board);
		response.sendRedirect("board?act=list");
	}

	private void writeForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/board/writeform.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", dao.selectBoard());
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
	}

}
