package cn.xgblack.heatmap.web.servlet;

import cn.xgblack.heatmap.domain.JobHeatmapData;
import cn.xgblack.heatmap.service.JobDataService;
import cn.xgblack.heatmap.service.JobDataServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/findJobsPoints")
public class FindJobsPoints extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JobDataService service = new JobDataServiceImpl();




        //调用JobService方法，查询Job全部数据（不分页）便于展示所有点
        //List<JobHeatmapData> jobHeatmapDatas = service.findAllJobPonits();

        Map<String, String[]> condition = request.getParameterMap();
        List<JobHeatmapData> jobHeatmapDatas = service.findSomePoints(condition);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(jobHeatmapDatas);

        //System.out.println(json);

        response.setContentType("text/html;charset=utf-8");

        response.getWriter().write(json);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
