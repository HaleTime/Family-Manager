package com.halemia.familymanager.dao.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/3/5 22:35
 */
@Slf4j
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class })})
//@Intercepts({@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})})
//@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
//@Intercepts( @Signature(type = ParameterHandler.class, method = "setParameters", args = PreparedStatement.class))

public class ResultInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap)invocation.getArgs()[1];
        Class dao = (Class) paramMap.get("daoClass");
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        List<ResultMap> resultMaps = mappedStatement.getResultMaps();
        ResultMap resultMap = resultMaps.get(0);
        if (resultMap.getType() != dao) {
            Class<? extends ResultMap> aClass = resultMap.getClass();
            Field type = aClass.getDeclaredField("type");
            type.setAccessible(true);
            type.set(resultMap, dao);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return (target instanceof Executor) ? Plugin.wrap(target, this) : target;
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
