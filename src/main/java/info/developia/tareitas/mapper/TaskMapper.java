package info.developia.tareitas.mapper;

import info.developia.tareitas.model.Task;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TaskMapper {
    @Select(
            "select * from lep.notes")
    @Results(value = {
            @Result(property = "title", column = "lep_name")
    })
    List<Task> getAll();
}
