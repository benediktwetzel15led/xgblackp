package cn.xgblack.heatmap.service;

import cn.xgblack.heatmap.dao.JobDataDao;
import cn.xgblack.heatmap.dao.JobDataDaoImpl;
import cn.xgblack.heatmap.domain.JobHeatmapData;

import java.util.List;
import java.util.Map;

/**
 * @author 小光
 * @date 2019/6/1 14:29
 * className: JobDataServiceImpl
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class JobDataServiceImpl implements JobDataService {
    private JobDataDao dao = new JobDataDaoImpl();

    /**
     * 直接查找所有Job数据,只包含jid,lat,lon,minwage,maxwage
     * @return List<Job>
     */
    @Override
    public List<JobHeatmapData> findAllJobPonits() {
        return dao.findAllJobPonits();
    }

    /**
     * 按照索引和条数查询热力图的点
     * @param startStr 开始索引
     * @param eachPointsStr 每次查询热力图点的个数
     * @return List<JobHeatmapData>
     */
    @Override
    public List<JobHeatmapData> findSomeJob(String startStr, String eachPointsStr) {
        int start = Integer.parseInt(startStr);
        int eachPoint = Integer.parseInt(eachPointsStr);

        return dao.findSomeJob(start, eachPoint);
    }

    /**
     * 根据查找条件加载热力图点
     * @param condition 查找条件
     * @return List<JobHeatmapData>
     */
    @Override
    public List<JobHeatmapData> findSomePoints(Map<String, String[]> condition) {
        return dao.findSomePoints(condition);
    }

}
