package arduinosensor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.model.HumidityVO;


@WebServlet("/inputSensor_b")
public class inputSensor_b extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain;");
		int mysensor = Integer.parseInt(request.getParameter("mysensor"));
		System.out.println("서버로 들어온 값 : " + mysensor);
		SensorDAO dao = new SensorDAO();
		HumidityVO vo = dao.update_b(mysensor);
		String result = new Gson().toJson(vo);
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
