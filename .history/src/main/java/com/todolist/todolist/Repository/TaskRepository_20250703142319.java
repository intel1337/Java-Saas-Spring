import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.ode.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
}
