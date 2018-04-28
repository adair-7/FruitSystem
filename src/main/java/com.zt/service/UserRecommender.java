package com.zt.service;

import com.zt.entity.Order;
import com.zt.mapper.AdminMapper;
import com.zt.mapper.UserMapper;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by admin on 2018/3/26.
 */
@Service
public class UserRecommender {
    @Autowired
    private UserMapper userMapper;

    //生成推荐数据文件
    public File getRecommendFile(){
        File file=new File("G:\\upload\\recommend.csv");
        try{
            if (!file.exists()){
                file.createNewFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
//        int count=userMapper.getAllOrderCount();


        return file;
    }

    //获取推荐结果项
    public void getRecommendItem( File file) throws  Exception{
        DataModel model = new FileDataModel(file);
        // Build the same recommender for testing that we did last time:
        RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
            @Override
            public Recommender buildRecommender(DataModel model) throws TasteException {
                ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
                return new GenericItemBasedRecommender(model, similarity);
            }
        };
        //获取推荐结果
        List<RecommendedItem> recommendations = recommenderBuilder.buildRecommender(model).recommend(1, 4);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }
    }
}
