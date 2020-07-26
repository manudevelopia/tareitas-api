package info.developia.tareitas.service;

import info.developia.tareitas.mapper.TaskMapper;
import info.developia.tareitas.model.Task;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;

public class Persistence {

    private final SqlSessionFactory sqlSessionFactory;

    public Persistence() {
        sqlSessionFactory = buildSqlSessionFactory();
    }

    public SqlSessionFactory buildSqlSessionFactory() {
        DataSource dataSource = new PooledDataSource(
                "org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/TAREITAS_DB",
                "admin",
                "password");
        Environment environment = new Environment("Development", new JdbcTransactionFactory(), dataSource);

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(TaskMapper.class);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        return builder.build(configuration);
    }

    List<Task> doSomething(){
        try(SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(TaskMapper.class).getAll();
        }
    }

}
