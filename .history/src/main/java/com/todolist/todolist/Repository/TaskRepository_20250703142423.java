package come.todolist.todolist.TaskRepository
import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.Model.Task;


public interface TaskRepository extends MongoRepository<Task, String> {
}
