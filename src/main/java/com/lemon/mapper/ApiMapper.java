package com.lemon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.common.ApiListVO;
import com.lemon.common.ApiVO;
import com.lemon.pojo.Api;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
public interface ApiMapper extends BaseMapper<Api> {
	
	@Select("select * from api where api_classification_id = #{apiClassification}")
	public List<Api> findApi(Integer apiClassification);
	
	
	@Select("SELECT\r\n" + 
			"	t1.*,\r\n" + 
			"	t2.NAME classificationName,\r\n" + 
			"	t2.project_id \r\n" + 
			"FROM\r\n" + 
			"	api t1,\r\n" + 
			"	api_classification t2 \r\n" + 
			"WHERE\r\n" + 
			"	t1.api_classification_id = t2.id \r\n" + 
			"	AND t2.project_id = #{projectId}")
	public List<ApiListVO> showApiListByProject(Integer projectId);
	
	
	@Select("SELECT\r\n" + 
			"a.*,\r\n" + 
			"ac.id,ac.name classificationName\r\n" + 
			"FROM\r\n" + 
			"	api a\r\n" + 
			"	INNER JOIN api_classification ac ON a.api_classification_id = ac.id \r\n" + 
			"HAVING\r\n" + 
			"ac.id = #{apiClassificationId}")
	public List<ApiListVO> showApiLiarByClassifiacationId(Integer apiClassificationId);
	
	
//	@Select("SELECT t1.*,t2.username createUsername FROM api t1,USER t2 WHERE t1.id=#{apiId} AND t1.create_user=t2.id")
//	@Results({
//		@Result(property="id", column="id"),
//		@Result(property="requestParams", column="id", many=@Many(select="com.lemon.mapper.ApiRequestParamMapper.findAll"))
//	})
//	public ApiVO findApiVO(Integer apiId);
	
	
//	@SelectProvider(type=ApiMapperProvider.class, method="findApiVO")
//	@Results({
//		@Result(property="id", column="id"),
//		@Result(property="requestParams", column="id", many=@Many(select="com.lemon.mapper.ApiRequestParamMapper.findAll"))
//	})
	public ApiVO findApiVO(@Param(value="apiId") Integer apiId);
	
	
	
	
	
//	class ApiMapperProvider{
//		public String findApiVO(Integer apiId) {
//			SQL sql = new SQL() {{
//				SELECT("t1.*");
//				SELECT("t2.username createUsername");
//				FROM("api t1");
//				FROM("user t2");
//				if(apiId != null) {
//					WHERE("t1.id = #{apiId}");
//				}
//				WHERE("t1.create_user=t2.id");
//			}};
//			
//			return sql.toString();
//		}
//	}
	
}
