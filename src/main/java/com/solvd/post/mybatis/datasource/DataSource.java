package com.solvd.post.mybatis.datasource;

import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.solvd.post.dao.models.Car;

public class DataSource {

	private static String resource = "mybatis-config.xml";
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private InputStream inputStream;

	public SqlSession getSqlSession() {
		
		
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession;

		

	}

	public void closeSesseion() {
		if (sqlSession != null)
			try {
				sqlSession.close();
			} catch (Exception ignored) {
			}

	}

	
	
}
