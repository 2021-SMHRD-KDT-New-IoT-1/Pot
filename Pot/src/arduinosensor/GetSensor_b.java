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

@WebServlet("/GetSensor_b")
public class GetSensor_b extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		SensorDAO dao = new SensorDAO();
		
		HumidityVO vo = dao.getSensor_b();
		if(vo == null) {
			vo = new HumidityVO(0);
		}
		
		String result = new Gson().toJson(vo);
		PrintWriter out = response.getWriter();
		out.print(result);
		System.out.println(result);
		Integer value = null;
		try {
			value = vo.getMysensor();
			vo = dao.update_b(value);
			System.out.println(value);
		} catch (Exception e) {
			System.out.println("value : 0");
		}
	}
}
