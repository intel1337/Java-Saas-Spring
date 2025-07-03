package come.todo
import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.Model.Task;


public interface TaskRepository extends MongoRepository<Task, String> {
}
